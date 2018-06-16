package br.com.ama.cgd.DAO;

import br.com.ama.cdp.AgenteSaude;
import br.com.ama.cdp.HorarioAtendimento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgenteSaudeDAO {
    private Connection conexao;

    //--------------------------------------- CRUD básico -----------------------------------------------

    public void insert(AgenteSaude agenteSaude){
        conexao = new ConnectionFactory().getConnection();

        String query = "";

        try{
            PreparedStatement ps = conexao.prepareStatement(query);

            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void alter(AgenteSaude agenteSaude){
        conexao = new ConnectionFactory().getConnection();

        String query = "";

        try{
            PreparedStatement ps = conexao.prepareStatement(query);

            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getByCpf(String cpf){
        conexao = new ConnectionFactory().getConnection();

        String query = "";

        try{
            PreparedStatement ps = conexao.prepareStatement(query);

            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void getAll(){

    }

    //--------------------------- Funções do Caso de Uso do Agente de Saúde ---------------------------------

    public void cadastraHorarioAtendimento(AgenteSaude agenteSaude, HorarioAtendimento horarioAtendimento){
        conexao = new ConnectionFactory().getConnection();

        //Lista com todos horários do banco de dados;
        ArrayList<HorarioAtendimento> list_horarios = (ArrayList<HorarioAtendimento>) new HorarioAtendimentoDAO().getAll();

        boolean exists = false;
        int id_ha = 0;
        int id_as = agenteSaude.getId();

        HorarioAtendimentoDAO haDAO = new HorarioAtendimentoDAO();

        //Varre a lista de horários em busca de um horário igual
        for (HorarioAtendimento ha : list_horarios) {
            if(horarioAtendimento.compareTo(ha) == 0){
                id_ha = haDAO.getIdHorarioAtendimento(ha);
                exists = true;
                break;
            }
        }

        //Se não existe um horário igual, cria e pega o ID
        if(!exists){
            haDAO.insert(horarioAtendimento);
            id_ha = haDAO.getIdHorarioAtendimento(horarioAtendimento);
        }

        //Insere os dados na tabela
        String query = "insert into agentesaude_horarioatendimento " +
                       "(id_agentesaude_horarioatendimento, idagentesaude, idhorarioatendimento) " +
                       "values (default, ?, ?)";

        try {
            PreparedStatement ps = conexao.prepareStatement(query);
            ps.setInt(1, id_as);
            ps.setInt(2, id_ha);
            ps.executeUpdate();

            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return;
    }

    public void alteraHorarioAtendimento(AgenteSaude agenteSaude, HorarioAtendimento horarioAtendimentoAntigo,
                                         HorarioAtendimento horarioAtendimentoNovo) throws RuntimeException{
        /*
        * Pega Horarios de Atendimento do Agente de Saúde.
        * Procura o horário de atendimento que é do mesmo dia da semana que foi passado no horário de atendimento;
        * */
        List<HorarioAtendimento> lst_ha = consultaHorarioAtendimento(agenteSaude);

        boolean exists = false;

        for (HorarioAtendimento ha : lst_ha) {
            if(ha.getDiaSemana().equals(horarioAtendimentoNovo.getDiaSemana())){
                exists = true;
                break;
            }
        }

        if(!exists) {
            excluiHorarioAtendimento(agenteSaude, horarioAtendimentoAntigo);

            cadastraHorarioAtendimento(agenteSaude, horarioAtendimentoNovo);
        }else{
            throw new RuntimeException("Você já tem um horário neste dia da semana");
        }
    }

    public void excluiHorarioAtendimento(AgenteSaude agenteSaude, HorarioAtendimento horarioAtendimento){
        conexao = new ConnectionFactory().getConnection();

        String query = "delete from agentesaude_horarioatendimento where idagentesaude = ? and idhorarioatendimento = ?";

        HorarioAtendimentoDAO haDAO = new HorarioAtendimentoDAO();

        int id_as = agenteSaude.getId();
        int id_ha = haDAO.getIdHorarioAtendimento(horarioAtendimento);

        try {
            PreparedStatement ps = conexao.prepareStatement(query);

            ps.setInt(1, id_as);
            ps.setInt(2, id_ha);

            ps.executeUpdate();

            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<HorarioAtendimento> consultaHorarioAtendimento(AgenteSaude agenteSaude){
        //Resultado
        ArrayList<HorarioAtendimento> horariosAtendimento = new ArrayList<>();

        //CPF do Agente
        String cpf = agenteSaude.getCpf();

        //Abrindo Conexão
        this.conexao = new ConnectionFactory().getConnection();

        //Query do Postgresql
        String query =  "select to_char(horainicio,'HH24:MI:SS') as \"Hora Inicio\", " +
                "to_char(horafim,'HH24:MI:SS') as \"Hora Termino\", " +
                "to_char(intervalo,'HH24:MI:SS') as \"Intervalo\", " +
                "ds.descricao as \"Descricao\" " +
                "from  agentesaude_horarioatendimento asha " +
                "inner join agentesaude ags on (asha.idagentesaude = ags.idagentesaude) " +
                "inner join horarioatendimento ha on (asha.idhorarioatendimento = ha.idhorarioatendimento) " +
                "inner join diasemana ds on (ha.iddiasemana = ds.iddiasemana) " +
                "inner join paciente pc on (asha.idagentesaude = pc.idpaciente) " +
                "where pc.\"cpf\" like ? ";

        try {
            //Preparação da Query
            PreparedStatement ps = conexao.prepareStatement(query);
            ps.setString(1, cpf);// -> Query está dando problema

            //Resultado da execução da query
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                //Instancía e Setta os atributos da classe
                HorarioAtendimento ha = new HorarioAtendimento();

                ha.setHoraInicio(rs.getString("Hora Inicio"));
                ha.setHoraFinal(rs.getString("Hora Termino"));
                ha.setIntervalo(rs.getString("Intervalo"));
                ha.setDiaSemana(rs.getString("Descricao"));

                horariosAtendimento.add(ha);
            }

            //Encerra conexão
            rs.close();
            ps.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return horariosAtendimento;
    }
}
