package br.com.ama.modelo;

import java.util.Calendar;

import br.com.ama.enums.ESexo;
import br.com.ama.enums.EUsuario;

public class Paciente {
	private int id;
	private String login;
	private String senha;
	private String cpf;
	private Calendar dataNascimento;
	private String nome;
	private String email;
	private EUsuario tipoUsuario;
	private ESexo tipoSexo;
	
	public Paciente(int _id, String _login, String _senha, String _cpf, Calendar _dataNascimento, String _nome,String _email,
					EUsuario _tipousuario, ESexo _tipoSexo) {
		this.id=_id;
		this.login=_login;
		this.senha=_senha;
		this.cpf=_cpf;
		this.dataNascimento=_dataNascimento;
		this.nome=_nome;
		this.email=_email;
		this.tipoUsuario=_tipousuario;
		this.tipoSexo=_tipoSexo;		
	}
	
	public Paciente() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int _id) {
		this.id = _id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String _login) {
		this.login = _login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String _senha) {
		this.senha = _senha;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String _cpf) {
		this.cpf = _cpf;
	}
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar _dataNascimento) {
		this.dataNascimento = _dataNascimento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String _nome) {
		this.nome = _nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String _email) {
		this.email = _email;
	}
	public EUsuario getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(EUsuario _tipoUsuario) {
		this.tipoUsuario = _tipoUsuario;
	}
	public ESexo getTipoSexo() {
		return tipoSexo;
	}
	public void setTipoSexo(ESexo _tipoSexo) {
		this.tipoSexo = _tipoSexo;
	}	
}
