package br.com.ama.cgd.DAO;



import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.ArrayList;

import java.util.Calendar;

import java.util.Date;

import java.util.List;

import br.com.ama.cdp.*;



public class EnderecoDAO {



    private Connection conexao;



    public EnderecoDAO() {}



    public List<Endereco> getAll() {



        List<Endereco> enderecos = new ArrayList<>();

        this.conexao = new ConnectionFactory().getConnection();

        try {

            String query = "select e.idendereco, e.cep, e.logradouro, e.bairro, c.nome as \"cidade\", es.nome as \"estado\", e.complemento, e.numero "

            			   +"from endereco e inner join cidade c on c.idcidade=e.idcidade "

            			   +"inner join estado es on es.idestado = c.idestado";

            PreparedStatement stmt;

            stmt = this.conexao.prepareStatement(query);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Endereco endereco = new Endereco();

                endereco.setId(Integer.parseInt(rs.getString("idendereco")));

                endereco.setCep(rs.getString("cep"));

                endereco.setLogradouro(rs.getString("logradouro"));

                endereco.setBairro(rs.getString("bairro"));

                endereco.setCidade(rs.getString("cidade"));

                endereco.setEstado(rs.getString("estado"));

                endereco.setComplemento(rs.getString("complemento"));

                endereco.setNumero(rs.getString("numero"));

                

                enderecos.add(endereco);

            }

            this.conexao.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return enderecos;

    }



    public int delete(Endereco endereco) {

    	int i=0;

        this.conexao = new ConnectionFactory().getConnection();

        try {

            String query = "delete from endereco where idendereco = ?";

            PreparedStatement stmt = this.conexao.prepareStatement(query);

            stmt.setInt(1,endereco.getId());

            i = stmt.executeUpdate();

            this.conexao.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return i;



    }



    public int insert(Endereco endereco) {

    	int i=0;

    	this.conexao = new ConnectionFactory().getConnection();

    	try {

    		String idCidade = "select c.idcidade from cidade c inner join estado e on e.idestado=c.idestado and e.sigla like '%\"+endereco.estado+\"%' where c.nome like '%\"+endereco.cidade+\"%'";

			String query = "insert into endereco (idendereco, cep, logradouro, bairro, cidade, complemento, numero)"

					+" values "

					+"(default,?,?,?,"+idCidade+",?,?)";

			PreparedStatement stmt = this.conexao.prepareStatement(query);

			stmt.setString(1, endereco.getCep());

			stmt.setString(2, endereco.getLogradouro());

			stmt.setString(3, endereco.getBairro());

			stmt.setString(4, endereco.getCidade());

			stmt.setString(5, endereco.getNumero());

			stmt.setString(6, endereco.getComplemento());

			i = stmt.executeUpdate();

            this.conexao.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

    	return i;

    }



    public int update(int idendereco,int numero, String complemento) {

    	int i=0;

    	this.conexao = new ConnectionFactory().getConnection();

        try {

            String query = "update endereco set numero = ?,  complemento=? "

                    + " where id="+idendereco;

            PreparedStatement stmt = this.conexao.prepareStatement(query);

            stmt.setInt(1, numero);

            stmt.setString(2, complemento);

            

            i = stmt.executeUpdate();

            this.conexao.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return i;

    }



    public Endereco getById(int idendereco) {

        this.conexao = new ConnectionFactory().getConnection();
        Endereco endereco = new Endereco();

        try {

            String query = "select e.idendereco, e.cep, e.logradouro, e.bairro, c.nome as \"cidade\", es.nome as \"estado\", e.complemento, e.numero "

     			   +"from endereco e inner join cidade c on c.idcidade=e.idcidade "

     			   +"inner join estado es on es.idestado = c.idestado where e.idendereco = ? ";

            PreparedStatement stmt = this.conexao.prepareStatement(query);

            stmt.setInt(1, idendereco);

            ResultSet rs = stmt.executeQuery();

            rs.next();

            

            

            endereco.setId(Integer.parseInt(rs.getString("idendereco")));

            endereco.setCep(rs.getString("cep"));

            endereco.setLogradouro(rs.getString("logradouro"));

            endereco.setBairro(rs.getString("bairro"));

            endereco.setCidade(rs.getString("cidade"));

            endereco.setEstado(rs.getString("estado"));

            endereco.setComplemento(rs.getString("complemento"));

            endereco.setNumero(rs.getString("numero"));

            

            this.conexao.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }

        return endereco;

    }

}