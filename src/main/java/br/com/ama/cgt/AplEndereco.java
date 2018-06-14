package br.com.ama.cgt;


import br.com.ama.cdp.Endereco;
import br.com.ama.cgd.DAO.EnderecoDAO;
import br.com.ama.util.Excecoes.DadoInvalidoException;
import java.sql.SQLException;



public class AplEndereco{
	
	private EnderecoDAO enderecoDAO = new EnderecoDAO();
	private Endereco _endereco;

	public void validaEndereco(Endereco endereco){
		if (endereco.getCep()==null){
			throw new DadoInvalidoException("O campo cep está inválido.");
		}
		if (endereco.getLogradouro()==null){
			throw new DadoInvalidoException("O campo Logradouro está inválido.");
		}
		if (endereco.getBairro()==null){
			throw new DadoInvalidoException("O campo Bairro está inválido.");
		}
		if (endereco.getCidade()==null){
			throw new DadoInvalidoException("O campo Cidade está inválido.");
		}
		if (endereco.getEstado()==null){
			throw new DadoInvalidoException("O campo Estado está inválido.");
		}
		if (endereco.getComplemento()==null){
			throw new DadoInvalidoException("O campo Complemento está inválido.");
		}
		if (endereco.getNumero()==null){
			throw new DadoInvalidoException("O campo Numero está inválido.");
		}
	}

	
	public boolean cadastrarEndereco(Endereco endereco){
		boolean result=false;
		try{
			this.validaEndereco(endereco);
			enderecoDAO.insert(endereco);
			result = true;
		}catch (Exception e){
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










