package br.com.ama.util.Excecoes;

public class DadoInvalidoException extends RuntimeException {  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DadoInvalidoException(String message) {
        super(message);
    }
}