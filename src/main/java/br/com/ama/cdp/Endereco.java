package br.com.ama.cdp;

public class Endereco {

    private int id;
    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String estado;
    private String complemento;
    private String numero;

    //Construtor
    public Endereco(int _id, String _cep, String _logradouro, String _bairro, String _cidade, String _estado){
        this.id=_id;
        this.cep=_cep;
        this.logradouro=_logradouro;
        this.bairro=_bairro;
        this.cidade=_cidade;
        this.estado=_estado;
    }
    //Métodos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

}
