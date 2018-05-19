package Teste;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import br.com.ama.connection.ConnectionFactory;

public class TesteConnectionFactory {

	@Test
	public void TesteConexao(){
		Connection con = null;
		try {
			String stringConnection = "jdbc:postgresql://localhost:5432/AMA";
			String user = "postgres";
			String password = "admin";
			con = DriverManager.getConnection(stringConnection,user,password);			
		}catch(SQLException e) {
			System.out.print("Erro de Conexao: " + e.getMessage());
		}
		ConnectionFactory fabricaConexao = new ConnectionFactory();
		Connection resultadoConexao = fabricaConexao.getConnection();
		try {
			assertEquals(con.isReadOnly(),resultadoConexao.isReadOnly());
		} catch (SQLException e) {
		}
	}
}
