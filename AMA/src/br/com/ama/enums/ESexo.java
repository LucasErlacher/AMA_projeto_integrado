package br.com.ama.enums;

public enum ESexo{
	MASCULINO(1,"Masculino"),
	FEMININO(2,"Feminino");
	
	private final int codigo;
	private final String descricao;
	
	ESexo(int _valorOpcao,String _descricao){
        this.codigo = _valorOpcao;
        this.descricao = _descricao; 
    }
    public int getCodigo(){
        return codigo;
    }
    
    public String getDescricao(){
        return descricao;
    }
}
