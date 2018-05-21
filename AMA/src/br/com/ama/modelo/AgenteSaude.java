package br.com.ama.modelo;

import java.util.Calendar;

import br.com.ama.enums.ESexo;
import br.com.ama.enums.EUsuario;

public class AgenteSaude extends Paciente{
	private String inscricao;
	//private Estado estadoInsricao;
	
	public String getInscricao() {
		return inscricao;
	}
	public void setInscricao(String inscricao) {
		this.inscricao = inscricao;
	}
	
	public AgenteSaude(int _id, String _login, String _senha, String _cpf, Calendar _dataNascimento, String _nome,String _email,
			EUsuario _tipousuario, ESexo _tipoSexo,String _inscricao) {
		super( _id,  _login,  _senha,  _cpf,  _dataNascimento,  _nome, _email,_tipousuario,  _tipoSexo);
		this.inscricao=_inscricao;		
	}
//	public Estado getEstadoInsricao() {
//		return estadoInsricao;
//	}
//	public void setEstadoInsricao(Estado estadoInsricao) {
//		this.estadoInsricao = estadoInsricao;
//	}
	
}
