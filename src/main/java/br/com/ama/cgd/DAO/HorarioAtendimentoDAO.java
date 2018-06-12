package br.com.ama.cgd.DAO;

import br.com.ama.cdp.HorarioAtendimento;
import org.joda.time.format.DateTimeFormat;
import org.postgresql.util.PGInterval;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HorarioAtendimentoDAO {

    private Connection conexao;

    public void insert(HorarioAtendimento ha){
        this.conexao = new ConnectionFactory().getConnection();

        //Query idhorarioatendimento	horainicio	horafim	intervalo	iddiasemana
        String query = "insert into horarioatendimento (idhorarioatendimento, horainicio, horafim, intervalo, iddiasemana) " +
                       "values (default, ?, ?, ?, ?)";

        try{
            PreparedStatement ps = conexao.prepareStatement(query);

            Time horainicio = new Time(ha.getHoraInicioMilisseconds());
            Time horafinal = new Time(ha.getHoraFinalMilisseconds());
            PGInterval intervalo = ha.getIntervalo();
            int idDiaSemana = new DiaSemanaDAO().getId(ha.getDiaSemana());

            ps.setTime(1,horainicio);
            ps.setTime(2,horafinal);
            ps.setObject(3,intervalo);
            ps.setInt(4,idDiaSemana);

            ps.executeUpdate();

            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getIdHorarioAtendimento(HorarioAtendimento ha){
        conexao = new ConnectionFactory().getConnection();

        String query =  "select idhorarioatendimento from horarioatendimento where\n" +
                        "horainicio = '12:30:00' and\n" +
                        "horafim = '18:30:00' and\n" +
                        "intervalo = '00:30:00' and\n" +
                        "iddiasemana = 2";

        int id = -1;

        try {
            PreparedStatement ps = conexao.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            rs.next();

            id = rs.getInt(0);

            rs.close();
            ps.close();
            conexao.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
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
