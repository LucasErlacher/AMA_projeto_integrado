package br.com.amawebinterface.cgd.DAO;

import br.com.amawebinterface.cdp.AgenteSaude;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.postgresql.util.PSQLException;
import java.util.List;

public class AgenteSaudeDAO extends DAOGeneric implements DAO<AgenteSaude> {

    private final PacienteDAO pacienteDAO = new PacienteDAO();

    public AgenteSaudeDAO() {
    }

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
            e.printStackTrace();
        }
        return agentes;
    }

    @Override
    public AgenteSaude findbyID(Long id) {
        try {
            this.openConnection();
            String query = "SELECT * FROM PACIENTE WHERE ID = ? ";
            PreparedStatement stmt = this.con.prepareStatement(query);;
            stmt.setLong(0, id);
            ResultSet rs = this.executeQuery(stmt);
            List<AgenteSaude> pacientes = retriveAgenteSaude(rs);
            rs.close();
            stmt.close();
            this.closeConnection();
            return pacientes.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(AgenteSaude paciente) {
        try {
            this.openConnection();
            String query = "DELETE IF EXISTS FROM PACIENTE WHERE ID = ?";
            PreparedStatement stmt = this.con.prepareStatement(query);
            stmt.setInt(1, paciente.getId());
            executeUpdate(stmt);
            this.closeConnection();
        }catch (PSQLException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(AgenteSaude agenteSaude) {
        try {
            this.pacienteDAO.insert(agenteSaude);
            if (agenteSaude.getId() != 0) {
                this.openConnection();
                String query
                        = " insert into agentesaude (idagentesaude, inscricao,idestado,idtiporegistro)"
                        + " values "
                        + " (?,?,(Select idestado from estado where nome like ?),?) ";

                PreparedStatement stmt = this.con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
                stmt.setInt(1, agenteSaude.getId());
                stmt.setString(2, agenteSaude.getInscricao());
                stmt.setString(3, agenteSaude.getEstado());
                stmt.setInt(4, agenteSaude.getEnum_registro());
                executeUpdate(stmt);
                this.closeConnection();
            }
        }catch (PSQLException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(AgenteSaude agente) {
        
    }

    public AgenteSaude getByLoginAndSenha(String _login, String _senha) {
        AgenteSaude agente = null;
        try {
            this.openConnection();
            String query =  " Select * from Paciente P "
                            + " inner join AgenteSaude AG on AG.IdAgenteSaude =  P.IdPaciente "                            
                            + " WHERE CPF LIKE ? AND SENHA LIKE ?";
            PreparedStatement stmt;
            stmt = this.con.prepareStatement(query);
            stmt.setString(1, _login);
            stmt.setString(2, _senha);
            ResultSet rs = this.executeQuery(stmt);
            List<AgenteSaude> agentes = retriveAgenteSaude(rs);
            rs.close();
            stmt.close();
            this.closeConnection();
            return agentes.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return agente;
    }

    public AgenteSaude getByCPF(String cpf) {
        try {
            this.openConnection();
            String query =  " Select *,E.Nome as \"Estado\" from Paciente P "
                            + " inner join AgenteSaude AG on AG.IdAgenteSaude =  P.IdPaciente "                            
                            + " inner join Estado E on E.IdEstado = AG.Idestado "       
                            + " WHERE CPF LIKE ? ";
            PreparedStatement stmt = this.con.prepareStatement(query);
            stmt.setString(1, cpf);
            ResultSet rs = this.executeQuery(stmt);
            List<AgenteSaude> agentes = retriveAgenteSaude(rs);
            rs.close();
            stmt.close();
            this.closeConnection();
            return agentes.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
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
