package br.com.ama.cgd.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DiaSemanaDAO {
    Connection conexao;

    public int getId(String diaSemana){
        conexao = new ConnectionFactory().getConnection();

        //Resultado
        int resultado = 0;

        //Query p/ Postgresql
        String query = "select iddiasemana from diasemana where descricao like \'"+ diaSemana + "\'";

        try {
            PreparedStatement ps = conexao.prepareStatement(query);
            //ps.setString(1,diaSemana);
            ResultSet rs = ps.executeQuery();
            rs.next();
            resultado = rs.getInt("iddiasemana");

            //Encerrando Conexão
            rs.close();
            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultado;
    }
}
