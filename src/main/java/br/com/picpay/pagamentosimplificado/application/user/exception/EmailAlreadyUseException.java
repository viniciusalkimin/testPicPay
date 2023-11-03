package br.com.picpay.pagamentosimplificado.application.user.exception;

public class EmailAlreadyUseException extends RuntimeException{

    public EmailAlreadyUseException(String msg) {
        super(msg);
    }
}
