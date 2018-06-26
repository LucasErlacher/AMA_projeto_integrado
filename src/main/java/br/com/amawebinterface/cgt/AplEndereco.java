package br.com.amawebinterface.cgt;


import br.com.amawebinterface.cdp.Endereco;
import br.com.amawebinterface.cgd.dao.EnderecoDAO;
import java.sql.SQLException;



public class AplEndereco{
	
	private EnderecoDAO enderecoDAO = new EnderecoDAO();
	
	public boolean cadastrarEndereco(Endereco endereco){
		boolean result=false;
		try{
                        endereco.validaEndereco();
			enderecoDAO.insert(endereco);
			result = true;
		}catch (SQLException e){
			e.printStackTrace();
			result = false;
		}finally {
			return result;
		}
	}

	public int alterarDadosEndereco(Endereco endereco, String numero, String complemento) throws SQLException{
		return enderecoDAO.update(endereco.getIdendereco(), numero,complemento);
	}
	
	public Endereco consultaEndereco(int idendereco) throws SQLException {
		return enderecoDAO.getById(idendereco);
	}
	
	
	public void exibirDados(Endereco endereco) {
		System.out.println("Rua: "+endereco.getLogradouro());
		System.out.println("Numero: "+endereco.getNumero());
		System.out.println("Complemento: "+endereco.getComplemento());
		System.out.println("Cidade: "+endereco.getCidade());
	}
	
	public int excluirEndereco(Endereco endereco) throws SQLException {
		return enderecoDAO.delete(endereco);
	}
}










