package br.com.ama.cgd.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.ama.cdp.*;

public class PacienteDAO {

    private Connection conexao;

    public PacienteDAO() {
    }

    public List<Paciente> getAll() throws SQLException {
        List<Paciente> pacientes = new ArrayList<>();
        try {
            this.conexao = new ConnectionFactory().getConnection();
            String query = "select * from paciente";
            PreparedStatement stmt;
            stmt = this.conexao.prepareStatement(query);
            ResultSet rs;
            rs = stmt.executeQuery();
            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setId(Integer.parseInt(rs.getString("idpaciente")));
                paciente.setNome(rs.getString("nome"));
                paciente.setCpf(rs.getString("cpf"));
                paciente.setEmail(rs.getString("email"));
                paciente.setSenha(rs.getString("senha"));
                paciente.setDataNascimento(rs.getDate("datanascimento"));
                paciente.setEnum_sexo(rs.getInt("idtiposexo"));
                pacientes.add(paciente);
            }
            this.conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pacientes;
    }

    public void delete(Paciente paciente) {
        try {
            this.conexao = new ConnectionFactory().getConnection();
            String query = "delete if exists from paciente where id = ?";
            PreparedStatement stmt = this.conexao.prepareStatement(query);
            stmt.setInt(1, paciente.getId());
            stmt.executeUpdate();
            this.conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int insert(Paciente paciente) {
        int i = 0;
        try {
            this.conexao = new ConnectionFactory().getConnection();
            String query
                    = " insert into paciente (idpaciente, senha,cpf,datanascimento,nome,email,idtipousuario,idsexo)"
                    + " values "
                    + " (default,?,?,?,?,?,?,?) "
                    + "  on conflict do nothing ";
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setString(1, paciente.getSenha());
            stmt.setString(2, paciente.getCpf());
            stmt.setDate(3, new java.sql.Date(paciente.getDataNascimento().getTime()));
            stmt.setString(4, paciente.getNome());
            stmt.setString(5, paciente.getEmail());
            stmt.setInt(6, paciente.getEnum_usuario());
            stmt.setInt(7, paciente.getEnum_sexo());
            i = stmt.executeUpdate();
            this.conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    public int update(Paciente paciente) {
        int i = 0;        
        try {
            this.conexao = new ConnectionFactory().getConnection();
            String query = "update paciente set senha = ?, email = ? "
                    + " where cpf like  ?   ";
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setString(1, paciente.getSenha());
            stmt.setString(2, paciente.getEmail());
            stmt.setString(3, paciente.getCpf());
            stmt.executeUpdate();
            i = stmt.executeUpdate();
            this.conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }

    public Paciente getByLoginAndSenha(String _login, String _senha) {
        Paciente paciente = new Paciente();
        try {
            this.conexao = new ConnectionFactory().getConnection();
            String query = "select * from paciente where cpf = ? and senha =  ?";
            PreparedStatement stmt;
            stmt = this.conexao.prepareStatement(query);
            stmt.setString(1, _login);
            stmt.setString(2, _senha);
            ResultSet rs;
            rs = stmt.executeQuery();
            while (rs.next()) {
                paciente.setId(Integer.parseInt(rs.getString("idpaciente")));
                paciente.setNome(rs.getString("nome"));
                paciente.setCpf(rs.getString("cpf"));
                paciente.setEmail(rs.getString("email"));
                paciente.setSenha(rs.getString("senha"));
                paciente.setDataNascimento(rs.getDate("datanascimento"));
                paciente.setEnum_sexo(rs.getInt("idtiposexo"));
                paciente.setEnum_usuario(rs.getInt("idtipousuario"));
            }
            this.conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paciente;
    }

    public Paciente getByCPF(String _cpf) {
        Paciente paciente = new Paciente();
        try {
            this.conexao = new ConnectionFactory().getConnection();
            String query = "select * from paciente where cpf = ? ";
            PreparedStatement stmt;
            stmt = this.conexao.prepareStatement(query);
            stmt.setString(1, _cpf);
            ResultSet rs;
            rs = stmt.executeQuery();
            while (rs.next()) {
                paciente.setId(Integer.parseInt(rs.getString("idpaciente")));
                paciente.setNome(rs.getString("nome"));
                paciente.setCpf(rs.getString("cpf"));
                paciente.setEmail(rs.getString("email"));
                paciente.setSenha(rs.getString("senha"));
                paciente.setDataNascimento(rs.getDate("datanascimento"));
                paciente.setEnum_sexo(rs.getInt("idsexo"));
            }
            this.conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paciente;
    }
}
