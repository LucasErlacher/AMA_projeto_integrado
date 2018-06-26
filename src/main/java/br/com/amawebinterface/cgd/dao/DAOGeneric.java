package br.com.amawebinterface.cgd.dao;

import br.com.amawebinterface.util.excecoes.DadoRepetidoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.postgresql.util.PSQLException;

public class DAOGeneric {

    protected Connection con;
    private static final Logger logger = Logger.getLogger(DAOGeneric.class.getName());

    protected void openConnection() {
        con = ConnectionFactory.getConnection();
        //this.hashError.new HashMap<Integer,Integer>();
    }

    protected ResultSet executeQuery(PreparedStatement statement) {
        // Comando para select
        ResultSet rs = null;
        try {
            rs = statement.executeQuery();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
        return rs;
    }

    protected int executeUpdate(PreparedStatement statement) {
        int numero = 0;
        try {
            statement.executeUpdate();
        } catch (PSQLException e) {
            //Class 23 — Integrity Constraint Violation by PostGreSQL Error Code Between 23000 and 24000
            if (Integer.parseInt(e.getSQLState()) >= 23000 && Integer.parseInt(e.getSQLState()) <= 24000) //
            {
                throw new DadoRepetidoException("Ja existe um registro com as informações dadas");
            }
            logger.log(Level.SEVERE, e.getMessage());
        } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
        try (ResultSet rs = statement.getGeneratedKeys()) {
            while (rs.next()) {
                numero = rs.getInt(1);
            }
        } catch (PSQLException e) {
            //Class 23 — Integrity Constraint Violation by PostGreSQL Error Code Between 23000 and 24000
            if (Integer.parseInt(e.getSQLState()) >= 23000 && Integer.parseInt(e.getSQLState()) <= 24000) //
            {
                throw new DadoRepetidoException("Ja existe um registro com as informações dadas");
            }
            logger.log(Level.SEVERE, e.getMessage());
        } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
        return numero;
    }

    protected void closeConnection() {
        try {
            con.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

}
