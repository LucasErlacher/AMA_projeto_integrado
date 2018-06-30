package br.com.amawebinterface.cdp;

import br.com.amawebinterface.util.excecoes.DadoInvalidoException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;

public class Paciente {

    private int id;

    //Acesso
    private String cpf;
    private String senha;

    //Dados Pessoais
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataNascimento;

    private String nome;
    private String email;
    private int enum_sexo;

    private List<Consulta> consultas;

    //???????
    private int enum_usuario;

    //Construtor
    public Paciente(int _id, String _cpf, String _senha, Date _dataNascimento,
            String _nome, String _email, int _enum_usuario, int _enum_sexo) {

        this.id = _id;
        this.senha = _senha;
        this.cpf = _cpf;
        this.dataNascimento = _dataNascimento;
        this.nome = _nome;
        this.email = _email;
        this.enum_usuario = _enum_usuario;
        this.enum_sexo = _enum_sexo;
        this.consultas = new ArrayList<>();

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
        return cpf != null ? cpf : "null";
    }

    public void setCpf(String _cpf) {
        this.cpf = _cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date _dataNascimento) {
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

    public int getEnum_sexo() {
        return enum_sexo;
    }

    public void setEnum_sexo(int _enum_sexo) {
        this.enum_sexo = _enum_sexo;
    }

    public int getEnum_usuario() {
        return enum_usuario;
    }

    public void setEnum_usuario(int _enum_usuario) {
        this.enum_usuario = _enum_usuario;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void adicionarConsulta(Consulta consulta) {
        this.consultas.add(consulta);
    }

    public boolean validaPaciente() {
        if (this.cpf == null) {
            throw new DadoInvalidoException("O campo Cpf está inválido.");
        }
        if (this.dataNascimento == null) {
            throw new DadoInvalidoException("O campo Data Nascimento está inválido.");
        }
        if (this.nome == null) {
            throw new DadoInvalidoException("O campo Nome está inválido.");
        }
        if (this.email == null) {
            throw new DadoInvalidoException("O campo Email está inválido.");
        }
        if (this.senha == null) {
            throw new DadoInvalidoException("O campo Senha está inválido.");
        }
        ArrayList<ESexo> sexos = new ArrayList<>();
        sexos.addAll(Arrays.asList(ESexo.values()));
        if (!sexos.contains(ESexo.getByCodigo(this.enum_sexo))) {
            throw new DadoInvalidoException("O campo Sexo está inválido.");
        }

        return true;
    }

}
