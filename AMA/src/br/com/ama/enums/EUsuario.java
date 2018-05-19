package br.com.ama.enums;

public enum EUsuario {
	AGENTESAUDE(1,"Agente de Saúde"),
	PACIENTE(2,"Paciente");
	
	private final int codigo;
	private final String descricao;
	
	EUsuario(int _valorOpcao,String _descricao){
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
