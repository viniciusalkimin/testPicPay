package br.com.picpay.pagamentosimplificado.application.exception;

public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException(String msg) {
        super(msg);
    }
}
