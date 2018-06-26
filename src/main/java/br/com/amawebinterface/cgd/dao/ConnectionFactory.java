package br.com.amawebinterface.cgd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {

    private static final  String url = "jdbc:postgresql://dumbo.db.elephantsql.com:5432/sxkmvllg";
    private static final  String user = "sxkmvllg";
    private static final  String pass = "RgEYHVSVFZkV08cXHGOymH9wO6HOllmP";
    
    private static final Logger logger = Logger.getLogger(AgenteSaudeDAO.class.getName());
    
    public ConnectionFactory(){
    
    }
    
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
        return con;
    }

}
