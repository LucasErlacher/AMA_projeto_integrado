package br.com.ama.cdp;

public class Estado {

    private int id;
    private String nome;

    //Construtor
    public Estado(int _id, String _nome) {
        this.id = _id;
        this.nome = _nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
