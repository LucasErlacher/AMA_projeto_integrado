package br.com.amawebinterface.cdp;

import br.com.amawebinterface.util.excecoes.DadoInvalidoException;

public class Endereco {

    private int idendereco;
    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String estado;
    private String complemento;
    private String numero;

    //Construtor
    public Endereco() {
    }

    public Endereco(String cep, String logradouro, String bairro, String cidade, String estado, String complemento, String numero) {
        super();
        this.cep = cep;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.complemento = complemento;
        this.numero = numero;
        this.estado = estado;
    }

    //Métodos
    public int getIdendereco() {
        return idendereco;
    }

    public void setIdendereco(int idendereco) {
        this.idendereco = idendereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void validaEndereco() {
        if (this.getCep() == null) {
            throw new DadoInvalidoException("O campo cep está inválido.");
        }
        if (this.getLogradouro() == null) {
            throw new DadoInvalidoException("O campo Logradouro está inválido.");
        }
        if (this.getBairro() == null) {
            throw new DadoInvalidoException("O campo Bairro está inválido.");
        }
        if (this.getCidade() == null) {
            throw new DadoInvalidoException("O campo Cidade está inválido.");
        }
        if (this.getEstado() == null) {
            throw new DadoInvalidoException("O campo Estado está inválido.");
        }
        if (this.getComplemento() == null) {
            throw new DadoInvalidoException("O campo Complemento está inválido.");
        }
        if (this.getNumero() == null) {
            throw new DadoInvalidoException("O campo Numero está inválido.");
        }
    }

}
