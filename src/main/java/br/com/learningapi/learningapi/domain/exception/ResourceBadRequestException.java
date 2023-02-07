package br.com.learningapi.learningapi.domain.exception;

public class ResourceBadRequestException extends RuntimeException {
    
    public ResourceBadRequestException(String mensagem) {
        super(mensagem);
    }
}