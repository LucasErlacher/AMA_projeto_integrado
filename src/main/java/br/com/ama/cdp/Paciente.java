package br.com.ama.cdp;

import java.util.Calendar;

public class Paciente {

    private int id;

    //Acesso
    private String cpf;
    private String senha;

    //Dados Pessoais
    private Calendar dataNascimento;
    private String nome;
    private String email;
    private ESexo tipoSexo;

    //???????
    private EUsuario tipoUsuario;

    //Construtor
    public Paciente(int _id, String _cpf, String _senha, Calendar _dataNascimento,
            String _nome, String _email, EUsuario _tipousuario, ESexo _tipoSexo) {

        this.id = _id;
        this.senha = _senha;
        this.cpf = _cpf;
        this.dataNascimento = _dataNascimento;
        this.nome = _nome;
        this.email = _email;
        this.tipoUsuario = _tipousuario;
        this.tipoSexo = _tipoSexo;

    }

    public Paciente() {

    }

    //Métodos
    public int getId() {
        return id;
    }

    public void setId(int _id) {
        this.id = _id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String _senha) {
        this.senha = _senha;
    }

    public String getCpf() {
        return cpf!=null? cpf : "null";
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
