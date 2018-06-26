package br.com.amawebinterface.cgd.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.amawebinterface.cdp.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.postgresql.util.PSQLException;

public class PacienteDAO extends DAOGeneric implements DAO<Paciente> {
    
    private static final Logger logger = Logger.getLogger(PacienteDAO.class.getName());
    public PacienteDAO() {
    }

    @Override
    public List<Paciente> findAll() {
        List<Paciente> pacientes = new ArrayList<>();
        try {
            this.openConnection();
            String query = "SELECT * FROM PACIENTE";
            PreparedStatement stmt;
            stmt = this.con.prepareStatement(query);
            ResultSet rs = this.executeQuery(stmt);
            pacientes = retrivePacientes(rs);
            rs.close();
            stmt.close();
            this.closeConnection();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
        return pacientes;
    }

    @Override
    public Paciente findbyID(Long id) {
        try {
            this.openConnection();
            String query = "SELECT * FROM PACIENTE WHERE ID = ? ";
            PreparedStatement stmt = this.con.prepareStatement(query);
            stmt.setLong(1, id);
            ResultSet rs = this.executeQuery(stmt);
            List<Paciente> pacientes = retrivePacientes(rs);
            rs.close();
            stmt.close();
            this.closeConnection();
            return pacientes.get(0);
        } catch (PSQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
        return null;
    }

    @Override
    public void delete(Paciente paciente) {
        try {
            this.openConnection();
            String query = "DELETE IF EXISTS FROM PACIENTE WHERE ID = ?";
            PreparedStatement stmt = this.con.prepareStatement(query);
            stmt.setInt(1, paciente.getId());
            executeUpdate(stmt);
            this.closeConnection();
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    @Override
    public void insert(Paciente paciente) {
        try {
            this.openConnection();
            String query
                    = " insert into paciente (idpaciente, senha,cpf,datanascimento,nome,email,idtipousuario,idsexo)"
                    + " values "
                    + " (default,?,?,?,?,?,?,?) ";
            PreparedStatement stmt = this.con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, paciente.getSenha());
            stmt.setString(2, paciente.getCpf());
            stmt.setDate(3, new java.sql.Date(paciente.getDataNascimento().getTime()));
            stmt.setString(4, paciente.getNome());
            stmt.setString(5, paciente.getEmail());
            stmt.setInt(6, paciente.getEnum_usuario());
            stmt.setInt(7, paciente.getEnum_sexo());
            int i = executeUpdate(stmt);
            paciente.setId(i);            
            this.closeConnection();
        } catch (PSQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }

    }

    @Override
    public void update(Paciente paciente) {
        try {
            this.openConnection();
            String query = "UPDATE PACIENTE SET SENHA = ?, email = ? "
                    + " WHERE CPF LIKE ? ";
            PreparedStatement stmt = this.con.prepareStatement(query);
            stmt.setString(1, paciente.getSenha());
            stmt.setString(2, paciente.getEmail());
            stmt.setString(3, paciente.getCpf());
            int i = executeUpdate(stmt);
            paciente.setId(i);
            this.closeConnection();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    public Paciente getByLoginAndSenha(String _login, String _senha) {
        Paciente paciente = null;
        try {
            this.openConnection();
            String query = "select * from paciente where cpf = ? and senha =  ?";
            PreparedStatement stmt;
            stmt = this.con.prepareStatement(query);
            stmt.setString(1, _login);
            stmt.setString(2, _senha);
            ResultSet rs = this.executeQuery(stmt);
            List<Paciente> pacientes = retrivePacientes(rs);
            rs.close();
            stmt.close();
            this.closeConnection();
            if (paciente != null) {
                return pacientes.get(0);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
        return paciente;
    }

    public Paciente getByCPF(String cpf) {
        Paciente paciente = null;
        try {
            this.openConnection();
            String query = "SELECT * FROM PACIENTE WHERE CPF = ? ";
            PreparedStatement stmt = this.con.prepareStatement(query);
            stmt.setString(1, cpf);
            ResultSet rs = this.executeQuery(stmt);
            List<Paciente> pacientes = retrivePacientes(rs);
            rs.close();
            stmt.close();
            this.closeConnection();
            if (pacientes != null) {
                return pacientes.get(0);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
        return null;
    }

    private List<Paciente> retrivePacientes(ResultSet rs) {
        try {
            List<Paciente> pacientes = new ArrayList<>();
            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setId(Integer.parseInt(rs.getString("idpaciente")));
                paciente.setNome(rs.getString("nome"));
                paciente.setCpf(rs.getString("cpf"));
                paciente.setEmail(rs.getString("email"));
                paciente.setSenha(rs.getString("senha"));
                paciente.setDataNascimento(rs.getDate("datanascimento"));
                paciente.setEnum_sexo(rs.getInt("idsexo"));
                pacientes.add(paciente);
            }
            return pacientes;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
