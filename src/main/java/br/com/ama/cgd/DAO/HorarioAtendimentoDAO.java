package br.com.ama.cgd.DAO;

import br.com.ama.cdp.HorarioAtendimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HorarioAtendimentoDAO {

    private Connection conexao;

    public void insert(HorarioAtendimento ha){
        this.conexao = new ConnectionFactory().getConnection();

        int idDiaSemana = 0;

        //Consulta qual o ID do dia da semana no horário de atendimento
        String queryConsultaIdDiaSemana = "select iddiasemana from diasemana where descricao like '?'";

        try {
            PreparedStatement ps = conexao.prepareStatement(queryConsultaIdDiaSemana);
           // ps.setString(1,ha.getDiaSemana());

            //Tabela contendo o dia da semana
            ResultSet rs = ps.executeQuery();
            rs.next(); //Primeira linha
            idDiaSemana = rs.getInt("iddiasemana"); //Pegando o id do result set
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //Insere o horario de atendimento na tabela
        String query = "insert into horarioatendimento (horainicio, horafim, intervalo, iddiasemana) values (?, ?, ?, ?)";

        try {
            PreparedStatement ps = conexao.prepareStatement(query);

//            ps.setString(1,ha.getHoraInicio());
//            ps.setString(2,ha.getHoraFinal());
//            ps.setString(3,ha.getIntervalo());
            ps.setInt(4,idDiaSemana);

            ps.executeUpdate();

            //Fechando conexão
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<HorarioAtendimento> getAll(){
        this.conexao = new ConnectionFactory().getConnection();

        List<HorarioAtendimento> horariosAtendimento = new ArrayList<>();

        String query = "select * from \"horarioatendimento\" ha inner join diasemana ds on (ha.iddiasemana = ds.\"iddiasemana\")";

        try {
            PreparedStatement ps = conexao.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                HorarioAtendimento ha = new HorarioAtendimento();
                ha.setHoraInicio(rs.getString("horainicio"));
                ha.setHoraFinal(rs.getString("horafim"));
                ha.setIntervalo(rs.getString("intervalo"));
                ha.setDiaSemana(rs.getString("descricao"));
                horariosAtendimento.add(ha);
            }

            rs.close();
            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return horariosAtendimento;
    }

}
