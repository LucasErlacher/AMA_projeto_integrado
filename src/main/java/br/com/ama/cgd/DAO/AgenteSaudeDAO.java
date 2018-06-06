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

    //--------------------------- Funções do Caso de Uso do Agente de Saúde ---------------------------------

    public void cadastraHorarioAtendimento(AgenteSaude agenteSaude, HorarioAtendimento horarioAtendimento){
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

    public List<HorarioAtendimento> getHorarioAtendimento(AgenteSaude agenteSaude){
        //Resultado
        List<HorarioAtendimento> horariosAtendimento = new ArrayList<>();

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
                "where pc.\"cpf\" like '" + cpf + "'";

        try {
            //Preparação da Query
            PreparedStatement ps = conexao.prepareStatement(query);
            //ps.setString(1, cpf); -> Query está dando problema

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
