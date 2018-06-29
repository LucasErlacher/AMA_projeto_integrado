package br.com.amawebinterface.cgd.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.amawebinterface.cdp.*;

public class EnderecoDAO extends DAOGeneric implements DAO<Endereco>{
    
    public int getIDCidade(Endereco endereco) throws SQLException {
        int id = 0;
        try {
            this.openConnection();
            String query = "select c.idcidade from cidade c inner join estado e on e.idestado=c.idestado and e.sigla like '%" + endereco.getEstado() + "%' where c.nome like '%" + endereco.getCidade() + "%'";
            PreparedStatement stmt = this.con.prepareStatement(query);
            ResultSet rs = this.executeQuery(stmt);
            
            while (rs.next()) {
                id = Integer.parseInt(rs.getString("idcidade"));
            }
            rs.close();
            stmt.close();
            this.closeConnection();
        } catch (SQLException e) {
        }
        return id;
    }
    
    public List<Endereco> getEnderecosAgente(AgenteSaude agente) throws SQLException{

        List<Endereco> enderecos = new ArrayList<>();
        try{
            this.openConnection();
            String query = "select endereco.idendereco from "+
                "agentesaude inner join agente_centro on (? = agente_centro.idagente) "+
                "inner join centro on (agente_centro.idcentro = centro.idcentro) "+
                "inner join centro_endereco on (centro.idcentro = centro_endereco.idcentro) "+
                "inner join endereco on (centro_endereco.idendereco = endereco.idendereco)";
            
            PreparedStatement stmt = this.con.prepareStatement(query);
            stmt.setInt(1,agente.getId());
            ResultSet rs = this.executeQuery(stmt);
            
            while(rs.next()){
                enderecos.add(findbyID(Long.parseLong(rs.getString("idendereco"))));
            }
            rs.close();
            stmt.close();
            this.closeConnection();
            
        }catch (SQLException e) {
        }
        return enderecos;
    }
    
    @Override
    public void insert(Endereco endereco) {
        try {
            this.openConnection();
            String query = "insert into endereco (idendereco, cep, logradouro, bairro, idcidade, complemento, numero)"
                + " values "
                + "(default,?,?,?,?,?,?)";
            PreparedStatement stmt = this.con.prepareStatement(query);
            stmt.setString(1, endereco.getCep());
            stmt.setString(2, endereco.getLogradouro());
            stmt.setString(3, endereco.getBairro());
            stmt.setInt(4, this.getIDCidade(endereco));
            stmt.setString(5, endereco.getComplemento());
            stmt.setString(6, endereco.getNumero());
            int i = executeUpdate(stmt);
            //endereco.setIdendereco(i);
            stmt.close();
            this.closeConnection();
        } catch (SQLException e) {
        }
    }
    
    @Override
    public void update(Endereco endereco) {
        try {
            this.openConnection();
            String query = "update endereco set numero = ?,  complemento= ? "
                + "where idendereco=" + endereco.getIdendereco();
            PreparedStatement stmt = this.con.prepareStatement(query);
            stmt.setString(1, endereco.getNumero());
            stmt.setString(2, endereco.getComplemento());
            int i = executeUpdate(stmt);
            //endereco.setIdendereco(i);
            stmt.close();
            this.closeConnection();
        } catch (SQLException e) {
        }
    }

    @Override
    public void delete(Endereco endereco) {
        try {
            this.openConnection();
            String query = "delete if exists from endereco where idendereco = ?";
            PreparedStatement stmt = this.con.prepareStatement(query);
            stmt.setInt(1, endereco.getIdendereco());
            stmt.executeUpdate();
            stmt.close();
            this.closeConnection();
        } catch (SQLException e) {
        }
    }

    @Override
    public Endereco findbyID(Long idendereco) {
        Endereco endereco = new Endereco();
        try {
            this.openConnection();
            String query = "select e.idendereco, e.cep, e.logradouro, e.bairro, c.nome as \"cidade\", es.sigla as \"estado\", e.complemento, e.numero "
                + "from endereco e inner join cidade c on c.idcidade=e.idcidade "
                + "inner join estado es on es.idestado = c.idestado where e.idendereco = ? ";
            PreparedStatement stmt = this.con.prepareStatement(query);
            stmt.setLong(1, idendereco);
            ResultSet rs = this.executeQuery(stmt);
            while (rs.next()) {
                endereco.setIdendereco(Integer.parseInt(rs.getString("idendereco")));
                endereco.setCep(rs.getString("cep"));
                endereco.setLogradouro(rs.getString("logradouro"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(rs.getString("estado"));
                endereco.setComplemento(rs.getString("complemento"));
                endereco.setNumero(rs.getString("numero"));
            }
            
            
            rs.close();
            stmt.close();
            this.closeConnection();
            return endereco;
        } catch (SQLException e) {
        }
        return null;
        
    }

    @Override
    public List<Endereco> findAll() {
        List<Endereco> enderecos = new ArrayList<>();
        try {
            this.openConnection();
            String query = "select e.idendereco, e.cep, e.logradouro, e.bairro, c.nome as \"cidade\", es.sigla as \"estado\", e.complemento, e.numero "
                + "from endereco e inner join cidade c on c.idcidade=e.idcidade "
                + "inner join estado es on es.idestado = c.idestado";
            PreparedStatement stmt = this.con.prepareStatement(query);
            ResultSet rs = this.executeQuery(stmt);
            enderecos = retriveEnderecos(rs);
            rs.close();
            stmt.close();
            this.closeConnection();
            
        } catch (SQLException e) {
        }
        return enderecos;
    }
    
    private List<Endereco> retriveEnderecos(ResultSet rs) {
        try {
            List<Endereco> enderecos = new ArrayList<>();
            while (rs.next()) {
                Endereco endereco = new Endereco();
                endereco.setIdendereco(Integer.parseInt(rs.getString("idendereco")));
                endereco.setCep(rs.getString("cep"));
                endereco.setLogradouro(rs.getString("logradouro"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(rs.getString("estado"));
                endereco.setComplemento(rs.getString("complemento"));
                endereco.setNumero(rs.getString("numero"));
                enderecos.add(endereco);
            }
            return enderecos;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
