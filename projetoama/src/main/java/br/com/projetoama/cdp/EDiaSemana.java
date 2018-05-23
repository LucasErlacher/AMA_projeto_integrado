package br.com.projetoama.cdp;

public enum EDiaSemana {
	DOMINGO(1,"Domingo"),
	SEGUNDA(2,"Segunda-feira"),
	TERCA(3,"Terça-feira"),
	QUARTA(4,"Quarta-feira"),
	QUINTA(5,"Quinta-feira"),
	SEXTA(6,"Setxa-feira"),
	SABADO(7,"Sábado");
	
	private final int codigo;
	private final String descricao;
	
	EDiaSemana(int _valorCodigo,String _descricao){
        this.codigo = _valorCodigo;
        this.descricao = _descricao; 
    }
    public int getCodigo(){
        return this.codigo;
    }
    
    public String getDescricao(){
        return descricao;
    }
}
