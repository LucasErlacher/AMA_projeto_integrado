package br.com.amawebinterface.cgd.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static  String URL = "jdbc:postgresql://dumbo.db.elephantsql.com:5432/sxkmvllg";
    private static  String USER = "sxkmvllg";
    private static  String PASS = "RgEYHVSVFZkV08cXHGOymH9wO6HOllmP";

    public static Connection getConnection() {
        Connection con = null;
        try {
            //URL = "jdbc:postgresql://localhost:5432/AMA BD2";
            //USER = "postgres";
            //PASS = "admin";
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

}
