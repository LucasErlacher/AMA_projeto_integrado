package br.com.ama.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.ama.connection.ConnectionFactory;
import br.com.ama.enums.EUsuario;
import br.com.ama.modelo.Paciente;;

public class PacienteDAO {
	private Connection conexao;
	
	public PacienteDAO() {
		
	}
	
	public List<Paciente> getAll() {

		List<Paciente> pacientes = new ArrayList<>();
		this.conexao = new ConnectionFactory().getConnection();
		try {
			String query  = "select * from paciente";
			PreparedStatement stmt;
			stmt = this.conexao.prepareStatement(query);
			ResultSet rs;
			rs = stmt.executeQuery();
			while (rs.next()) {
				Paciente paciente = new Paciente();
				paciente.setId(Integer.parseInt(rs.getString("id")));
				paciente.setNome(rs.getString("nome"));
				paciente.setCpf(rs.getString("cpf"));
				paciente.setEmail(rs.getString("email"));
				paciente.setLogin(rs.getString("cpf"));
				paciente.setSenha(rs.getString("senha"));
				
				Calendar data = Calendar.getInstance();
		        data.setTime(rs.getDate("datanascimento"));
		        
		        paciente.setDataNascimento(data);	        
		        pacientes.add(paciente);
			}
			this.conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return pacientes;		
	}
	public void delete(Paciente paciente) {
		this.conexao = new ConnectionFactory().getConnection();
		try {
			String query = "delete from paciente where id = ?";
			PreparedStatement stmt = this.conexao.prepareStatement(query);
			stmt.setInt(1,paciente.getId());
			stmt.executeUpdate();
			this.conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void insert(Paciente paciente) {
		this.conexao = new ConnectionFactory().getConnection();
		try {
			String query = "insert into paciente (id, senha,cpf,datanascimento,nome,email,idtipousuario,idendereco,idsexo)"
							+ " values "
							+ " (?,?,?,?,?,?,?,?,?) ";
			PreparedStatement stmt = conexao.prepareStatement(query);
			stmt.setString(1, "default");
			stmt.setString(2, paciente.getSenha());
			stmt.setString(3, paciente.getCpf());
			stmt.setDate(4, (java.sql.Date) new Date (paciente.getDataNascimento().getTimeInMillis()));
			stmt.setString(5, paciente.getNome());
			stmt.setString(6, paciente.getEmail());
			stmt.setInt(7, paciente.getTipoUsuario().getCodigo());
			stmt.setInt(8, paciente.getTipoSexo().getCodigo());
			stmt.executeUpdate();
			this.conexao.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void update(Paciente paciente) {
		this.conexao = new ConnectionFactory().getConnection();
		try {
			String query = "update paciente set senha = ?,  email=? "
					+ " where id=? ";
			PreparedStatement stmt = conexao.prepareStatement(query);
			stmt.setString(1,paciente.getSenha());
			stmt.setString(2,paciente.getEmail());
			stmt.setInt(3, paciente.getId());
			stmt.executeUpdate();
			this.conexao.close();
		}catch(SQLException e) {
				e.printStackTrace();		
		}		
	}
	
	public Paciente getByLoginAndSenha(String _login, String _senha) {
		Paciente paciente = new Paciente();
		this.conexao = new ConnectionFactory().getConnection();
		try {
			String query  = "select * from paciente where login = ? and senha=?";
			PreparedStatement stmt;
			stmt = this.conexao.prepareStatement(query);
			stmt.setString(1, _login);
			stmt.setString(2, _senha);
			ResultSet rs;
			rs = stmt.executeQuery();
			while(rs.next()) {
				paciente.setId(Integer.parseInt(rs.getString("id")));
				paciente.setNome(rs.getString("nome"));
				paciente.setCpf(rs.getString("cpf"));
				paciente.setEmail(rs.getString("email"));
				paciente.setLogin(rs.getString("cpf"));
				paciente.setSenha(rs.getString("senha"));
				
				Calendar data = Calendar.getInstance();
		        data.setTime(rs.getDate("datanascimento"));	        
		        paciente.setDataNascimento(data);				
			}			
			this.conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return paciente;		
	}
}
