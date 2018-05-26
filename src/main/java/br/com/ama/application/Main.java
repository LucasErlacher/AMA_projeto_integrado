package br.com.ama.application;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import br.com.ama.cgd.DAO.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tarcisio
 */
public class Main {
    public static void main(String[] args ){
        Connection con = new ConnectionFactory().getConnection();
        
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
         // Comentario para teste de commit
    }
}
