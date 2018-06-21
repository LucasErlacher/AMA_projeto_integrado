package br.com.amawebinterface.cgd.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOGeneric {

    protected Connection con;

    protected void openConnection() {
        con = ConnectionFactory.getConnection();
    }

    protected ResultSet executeQuery(PreparedStatement statement) {
        try {
            ResultSet rs = statement.executeQuery();

            return rs;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected int executeUpdate(PreparedStatement statement) {
        int numero = 0;
        // Comando para update, insert e delete		
        try {
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()) {
                numero = rs.getInt(1);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return numero;
        }

    }

    protected void closeConnection() {
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
