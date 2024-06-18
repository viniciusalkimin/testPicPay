package br.com.picpay.pagamentosimplificado.application.exception;

public class NotAuthorizedTranscationException extends RuntimeException{

    public NotAuthorizedTranscationException(String msg) {
        super(msg);
    }
}
