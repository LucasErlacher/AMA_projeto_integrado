package br.com.amawebinterface.util.excecoes;

public class DadoInvalidoException extends RuntimeException {  
    public DadoInvalidoException(String message) {
        super(message);
    }
}