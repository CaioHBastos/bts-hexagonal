package com.bancobts.apphexagonal.core.domain.exception;

public class ClienteNaoEncontradoException extends RegistroNaoEncontradoException {

    private static final long serialVersionUID = 1L;

    public ClienteNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
