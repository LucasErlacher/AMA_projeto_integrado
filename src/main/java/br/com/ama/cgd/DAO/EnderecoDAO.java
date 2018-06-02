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

    public EnderecoDAO() {

    }

    public List<Paciente> getAll() {

        List<Paciente> pacientes = new ArrayList<>();
        this.conexao = new ConnectionFactory().getConnection();
        try {
            String query = "select * from paciente";
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

    public void delete(Endereco endereco) {
        this.conexao = new ConnectionFactory().getConnection();
        try {
            String query = "delete from endereco where id = ?";
            PreparedStatement stmt = this.conexao.prepareStatement(query);
            stmt.setInt(1,endereco.getId());
            stmt.executeUpdate();
            this.conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void insert(Endereco endereco) {
        
    }

    public void update(Paciente paciente) {
    }

    public Endereco getById(int _id) {
        Endereco endereco = null;
        this.conexao = new ConnectionFactory().getConnection();
        try {
            String query = "Select en.ID as IdEndereco,"
                    + "		en.CEP as CEP,"
                    + "		en.Logradouro as Logradouro,"
                    + "		b.id as IdBairro,"
                    + "		b.nome as Bairro,"
                    + "		c.id as IdCidade,"
                    + "		c.Nome as Cidade,"
                    + "		e.id as IdEstado,"
                    + "		e.Nome as Estado"
                    + "		from endereco en"
                    + "  inner join bairro b on b.id=en.idbairro"
                    + "  inner join cidade c on c.id=b.idcidade"
                    + "  inner join estado e on e.id=c.idestado"
                    + "  where en.id = ? ";
            PreparedStatement stmt;
            stmt = this.conexao.prepareStatement(query);
            stmt.setInt(1, _id);
            ResultSet rs;
            rs = stmt.executeQuery();
            rs.next();
            int idEndereco = rs.getInt("IdEndereco");
            String logradouro = rs.getString("Logradouro");
            String cep = rs.getString("CEP");
            String bairro = rs.getString("Bairro");
            String cidade = rs.getString("Cidade");
            String estado = rs.getString("Estado");
            
            endereco = new Endereco(idEndereco, cep, logradouro, bairro, cidade, estado);
            this.conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return endereco;
    }
}
