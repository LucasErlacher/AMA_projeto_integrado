package br.com.amawebinterface.cgd.dao;

import br.com.amawebinterface.util.excecoes.DadoRepetidoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.postgresql.util.PSQLException;

public class DAOGeneric {

    protected Connection con;
    
    protected void openConnection() {
        con = ConnectionFactory.getConnection();
        //this.hashError.new HashMap<Integer,Integer>();
    }

    protected ResultSet executeQuery(PreparedStatement statement) {
        // Comando para select		
        try {
            ResultSet rs = statement.executeQuery();

            return rs;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected int executeUpdate(PreparedStatement statement){
        int numero = 0;
        // Comando para update, insert e delete		
        try {
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()) {
                numero = rs.getInt(1);
            }
            statement.close();
        } catch (PSQLException e) {
            //Class 23 — Integrity Constraint Violation by PostGreSQL Error Code Between 23000 and 24000
            if(Integer.parseInt(e.getSQLState()) >= 23000 && Integer.parseInt(e.getSQLState()) <= 24000) //
                throw new DadoRepetidoException("Ja existe um registro com as informações dadas");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return numero;
    }

    protected void closeConnection() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
