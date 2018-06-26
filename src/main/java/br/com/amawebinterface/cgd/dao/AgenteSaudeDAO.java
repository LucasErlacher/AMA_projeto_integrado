package br.com.amawebinterface.cgd.dao;

import br.com.amawebinterface.cdp.AgenteSaude;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.postgresql.util.PSQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AgenteSaudeDAO extends DAOGeneric implements DAO<AgenteSaude> {

    private final PacienteDAO pacienteDAO = new PacienteDAO();
    private final Logger logger = Logger.getLogger(AgenteSaudeDAO.class.getName());
    
    @Override
    public List<AgenteSaude> findAll() {
        List<AgenteSaude> agentes = new ArrayList<>();
        try {
            this.openConnection();
            String query = "SELECT * FROM PACIENTE P "
                    + "     INNER JOIN AGENTESAUDE AG ON AG.IDAGENTESAUDE=P.IDPACIENTE ";
            PreparedStatement stmt;
            stmt = this.con.prepareStatement(query);
            ResultSet rs = this.executeQuery(stmt);
            agentes = retriveAgenteSaude(rs);
            rs.close();
            stmt.close();
            this.closeConnection();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
        return agentes;
    }

    @Override
    public AgenteSaude findbyID(Long id) {
        String query = "SELECT * FROM PACIENTE WHERE ID = ? ";
        PreparedStatement stmt;
        try {
            this.openConnection();
            stmt = this.con.prepareStatement(query);
            stmt.setLong(1, id);
            ResultSet rs = this.executeQuery(stmt);
            List<AgenteSaude> agentes = retriveAgenteSaude(rs);
            stmt.close();
            rs.close();
            this.closeConnection();
            if (agentes != null) {
                return agentes.get(0);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        } catch (NullPointerException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
        return null;
    }

    @Override
    public void delete(AgenteSaude agente) {
        String query = "DELETE IF EXISTS FROM PACIENTE WHERE ID = ?";
        PreparedStatement stmt;
        try {
            this.openConnection();
            stmt = this.con.prepareStatement(query);
            stmt.setInt(1, agente.getId());
            executeUpdate(stmt);
            this.closeConnection();
        } catch (PSQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
    }

    @Override
    public void insert(AgenteSaude agenteSaude) {
        String query
                = " insert into agentesaude (idagentesaude, inscricao,idestado,idtiporegistro)"
                + " values "
                + " (?,?,(Select idestado from estado where nome like ?),?) ";

        PreparedStatement stmt;
        try {
            this.pacienteDAO.insert(agenteSaude);
            if (agenteSaude.getId() != 0) {
                this.openConnection();
                stmt = this.con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
                stmt.setInt(1, agenteSaude.getId());
                stmt.setString(2, agenteSaude.getInscricao());
                stmt.setString(3, agenteSaude.getEstado());
                stmt.setInt(4, agenteSaude.getEnum_registro());
                executeUpdate(stmt);
                this.closeConnection();
            }
        } catch (PSQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }

    }

    @Override
    public void update(AgenteSaude agente) {

    }

    public AgenteSaude getByLoginAndSenha(String _login, String _senha) {
        AgenteSaude agente = null;
        String query = " Select * from Paciente P "
                + " inner join AgenteSaude AG on AG.IdAgenteSaude =  P.IdPaciente "
                + " WHERE CPF LIKE ? AND SENHA LIKE ?";
        PreparedStatement stmt;
        try {
            this.openConnection();
            stmt = this.con.prepareStatement(query);
            stmt.setString(1, _login);
            stmt.setString(2, _senha);
            ResultSet rs = this.executeQuery(stmt);
            List<AgenteSaude> agentes = retriveAgenteSaude(rs);
            rs.close();
            stmt.close();
            this.closeConnection();
            if (agentes != null) {
                return agentes.get(0);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }
        return agente;
    }

    public AgenteSaude getByCPF(String cpf) {
        String query = " Select *,E.Nome as \"Estado\" from Paciente P "
                    + " inner join AgenteSaude AG on AG.IdAgenteSaude =  P.IdPaciente "
                    + " inner join Estado E on E.IdEstado = AG.Idestado "
                    + " WHERE CPF LIKE ? ";
            PreparedStatement stmt;
        try {
            this.openConnection();
            stmt = this.con.prepareStatement(query);
            stmt.setString(1, cpf);
            ResultSet rs = this.executeQuery(stmt);
            List<AgenteSaude> agentes = retriveAgenteSaude(rs);
            rs.close();
            stmt.close();
            this.closeConnection();
            if (agentes != null) {
                return agentes.get(0);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, e.getMessage());
        } catch (NullPointerException e) {
            logger.log(Level.SEVERE, e.getMessage());
        }

        return null;
    }

    private List<AgenteSaude> retriveAgenteSaude(ResultSet rs) {
        try {
            List<AgenteSaude> agentes = new ArrayList<>();
            while (rs.next()) {
                AgenteSaude agente = new AgenteSaude();
                agente.setId(Integer.parseInt(rs.getString("idagentesaude")));
                agente.setNome(rs.getString("nome"));
                agente.setCpf(rs.getString("cpf"));
                agente.setEmail(rs.getString("email"));
                agente.setSenha(rs.getString("senha"));
                agente.setDataNascimento(rs.getDate("datanascimento"));
                agente.setEnum_sexo(rs.getInt("idsexo"));
                agente.setInscricao(rs.getString("inscricao"));
                agente.setEnum_registro(rs.getInt("idtiporegistro"));
                agente.setEstado(rs.getString("Estado"));
                agentes.add(agente);
            }
            return agentes;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
