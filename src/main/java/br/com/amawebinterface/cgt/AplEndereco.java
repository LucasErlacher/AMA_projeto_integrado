package br.com.amawebinterface.cgt;


import br.com.amawebinterface.cdp.Endereco;
import br.com.amawebinterface.cgd.dao.EnderecoDAO;
import br.com.amawebinterface.util.excecoes.DadoInvalidoException;
import java.sql.SQLException;



public class AplEndereco{
	
	private EnderecoDAO enderecoDAO = new EnderecoDAO();
	
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

	
	@SuppressWarnings("finally")
	public boolean cadastrarEndereco(Endereco endereco){
		boolean result=false;
		try{
                    this.validaEndereco(endereco);
                    enderecoDAO.insert(endereco);
                    result = true;
		}catch (Exception e){
		}finally {
                    return result;
		}
	}

	public void alterarDadosEndereco(Endereco endereco, String numero, String complemento) throws SQLException{
            endereco.setNumero(numero);
            endereco.setComplemento(complemento);
            enderecoDAO.update(endereco);
	}
	
	public Endereco consultaEndereco(Long idendereco) throws SQLException {
		return enderecoDAO.findbyID(idendereco);
	}
	
	
	public void exibirDados(Endereco endereco) {
		System.out.println("Rua: "+endereco.getLogradouro());
		System.out.println("Numero: "+endereco.getNumero());
		System.out.println("Complemento: "+endereco.getComplemento());
		System.out.println("Cidade: "+endereco.getCidade());
	}
	
	public void excluirEndereco(Endereco endereco) throws SQLException {
		enderecoDAO.delete(endereco);
	}
}