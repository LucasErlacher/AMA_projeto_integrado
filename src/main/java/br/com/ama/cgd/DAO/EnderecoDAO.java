package br.com.ama.cgd.DAO;
import br.com.ama.cdp.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EnderecoDAO {
	//Atributos
    private Connection conexao;


    
    public EnderecoDAO() {
    }
    
    public int getIDCidade(Endereco endereco) throws SQLException {
    	this.conexao = new ConnectionFactory().getConnection();
    	String sql = "select c.idcidade from cidade c inner join estado e on e.idestado=c.idestado and e.sigla like '%"+endereco.getEstado()+"%' where c.nome like '%"+endereco.getCidade()+"%'";
    	int id=0;
    	
    	try {
    		PreparedStatement stmt = this.conexao.prepareStatement(sql);
    		ResultSet rs = stmt.executeQuery();
    		rs.next();
    		id = Integer.parseInt(rs.getString("idcidade"));
    		rs.close();
    		stmt.close();
    	}catch (SQLException e) {
    		e.printStackTrace();
    	}finally {this.conexao.close();}
    	
    	return id;
    }
    
    public List<Endereco> getAll() throws SQLException {
    	
    	this.conexao = new ConnectionFactory().getConnection();
        List<Endereco> enderecos = new ArrayList<>();
        
        String sql = "select e.idendereco, e.cep, e.logradouro, e.bairro, c.nome as \"cidade\", es.sigla as \"estado\", e.complemento, e.numero "
 			   +"from endereco e inner join cidade c on c.idcidade=e.idcidade "
 			   +"inner join estado es on es.idestado = c.idestado";
        
        try {

            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

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
            rs.close();
            stmt.close();

        } catch (SQLException e) {

            e.printStackTrace();

        } finally {this.conexao.close();}

        return enderecos;
    }

    public int delete(Endereco endereco) throws SQLException {
    	
    	this.conexao = new ConnectionFactory().getConnection();
    	int i=0;
    	
    	String sql = "delete from endereco where idendereco = ?";
    	
        try {

            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.setInt(1,endereco.getIdendereco());
            i = stmt.executeUpdate();
            
            stmt.close();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {this.conexao.close();}

        return i;
    }

    public int insert(Endereco endereco) throws SQLException {
    	
    	this.conexao = new ConnectionFactory().getConnection();
    	int i=0;
    	String sql = "insert into endereco (idendereco, cep, logradouro, bairro, idcidade, complemento, numero)"
				+" values "
				+"(default,?,?,?,?,?,?)";
    	
    	try {

			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			stmt.setString(1, endereco.getCep());
			stmt.setString(2, endereco.getLogradouro());
			stmt.setString(3, endereco.getBairro());
			stmt.setInt(4, this.getIDCidade(endereco));
			stmt.setString(5, endereco.getComplemento());
			stmt.setString(6, endereco.getNumero());
			i = stmt.executeUpdate();
 	
            stmt.close();
		} catch (Exception e) {

			e.printStackTrace();

		} finally {this.conexao.close();}

    	return i;
    }

    public int update(int idendereco,String numero, String complemento) throws SQLException {
    	
    	this.conexao = new ConnectionFactory().getConnection();
    	int i=0;
    	
    	String sql = "update endereco set numero = ?,  complemento=? "
                + " where idendereco="+idendereco;
    	
        try {

            

            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.setString(1, numero);
            stmt.setString(2, complemento);
            i = stmt.executeUpdate();
            stmt.close();

        } catch (SQLException e) {
        	
            e.printStackTrace();
            
        } finally {this.conexao.close();}

        return i;
    }

    public Endereco getById(int idendereco) throws SQLException {
    	
    	this.conexao = new ConnectionFactory().getConnection();
        Endereco endereco = new Endereco();
        
        String sql = "select e.idendereco, e.cep, e.logradouro, e.bairro, c.nome as \"cidade\", es.sigla as \"estado\", e.complemento, e.numero "
  			   +"from endereco e inner join cidade c on c.idcidade=e.idcidade "
  			   +"inner join estado es on es.idestado = c.idestado where e.idendereco = ? ";
        
        try {

            PreparedStatement stmt = this.conexao.prepareStatement(sql);

            stmt.setInt(1, idendereco);
            ResultSet rs = stmt.executeQuery();
            rs.next();

            endereco.setIdendereco(Integer.parseInt(rs.getString("idendereco")));
            endereco.setCep(rs.getString("cep"));
            endereco.setLogradouro(rs.getString("logradouro"));
            endereco.setBairro(rs.getString("bairro"));
            endereco.setCidade(rs.getString("cidade"));
            endereco.setEstado(rs.getString("estado"));
            endereco.setComplemento(rs.getString("complemento"));
            endereco.setNumero(rs.getString("numero"));
            
            rs.close();
            stmt.close();
            
        } catch (SQLException e) {

            e.printStackTrace();

        } finally {this.conexao.close();}

        return endereco;
    }
}