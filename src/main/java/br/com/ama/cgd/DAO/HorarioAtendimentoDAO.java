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
        idDiaSemana = new DiaSemanaDAO().getId(ha.getDiaSemana());

        //Query idhorarioatendimento	horainicio	horafim	intervalo	iddiasemana
        String query = "insert into horarioatendimento (idhorarioatendimento, horainicio, horafim, intervalo, iddiasemana) " +
                "values (default, ?, ?, ?, ?)";

        try{
            PreparedStatement ps = conexao.prepareStatement(query);

            String intervalo = ha.getIntervalo().getValue();
            String[] intervalo_token = intervalo.split(" ");
            intervalo = intervalo_token[6] + ":" + intervalo_token[8] + ":" + intervalo_token[10].split(".")[0];

            ps.setString(1, ha.getHoraInicio().toString());
            ps.setString(2, ha.getHoraFinal().toString());
            ps.setString(3, intervalo);
            ps.setString(4, ha.getDiaSemana());

            ps.executeUpdate();

            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getIdHorarioAtendimento(HorarioAtendimento ha){
        return 0;
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
