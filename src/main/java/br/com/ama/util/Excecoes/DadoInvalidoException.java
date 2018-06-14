package br.com.ama.util.Excecoes;

public class DadoInvalidoException extends RuntimeException {  
    public DadoInvalidoException(String message) {
        super(message);
    }
}