package br.com.ama.modelo.enums;

public enum TipoUsuario {
	AGENTESAUDE(1),PACIENTE(2);
	
	private final int valor;
	
	TipoUsuario(int valorOpcao){
        valor = valorOpcao;
    }
    public int getValor(){
        return valor;
    }
}
