package br.com.ama.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() {
		Connection con = null;
		try {
			String stringConnection = "jdbc:postgresql://localhost:5432/AMA";
			String user = "postgres";
			String password = "admin";
			con = DriverManager.getConnection(stringConnection,user,password);			
		}catch(SQLException e) {
			System.out.print("Erro de Conexao: " + e.getMessage());
		}
		return con;
	}
}
