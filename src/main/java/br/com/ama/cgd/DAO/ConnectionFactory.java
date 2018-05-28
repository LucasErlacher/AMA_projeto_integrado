package br.com.ama.cgd.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {

    //private static final String DRIVER = "PostgreSQL AMA";
    private static final String URL = "jdbc:postgresql://dumbo.db.elephantsql.com:5432/yvbafcvx";
    private static final String USER = "yvbafcvx";
    private static final String PASS = "osEf57D9s7viNhSnefqWCXTbQABn48ez";

    public Connection getConnection() {
        Connection con = null;
        try {
            //            String URL = "jdbc:postgresql://localhost:5432/AMA";
            //            String USER = "postgres";
            //            String PASS = "admin";
            con = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conexao Realizada");
        } catch (SQLException e) {
            System.out.print("Erro na criacao de conexao: " + e.getMessage());
        }
        return con;
    }
    
}