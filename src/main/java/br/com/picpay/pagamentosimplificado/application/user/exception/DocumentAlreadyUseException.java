package br.com.picpay.pagamentosimplificado.application.user.exception;

public class DocumentAlreadyUseException extends RuntimeException{

    public DocumentAlreadyUseException(String msg) {
        super(msg);
    }
}
