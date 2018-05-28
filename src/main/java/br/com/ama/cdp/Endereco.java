package br.com.ama.cdp;

public class Endereco {

    private int id;
    private String cep;
    private String logradouro;
    private Bairro bairro;
    private Cidade cidade;
    private Estado estado;
    private String complemento;
    private String numero;

    //Construtor
    public Endereco(int _id, String _cep, String _logradouro, Bairro _bairro, Cidade _cidade, Estado _estado){
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

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

}
