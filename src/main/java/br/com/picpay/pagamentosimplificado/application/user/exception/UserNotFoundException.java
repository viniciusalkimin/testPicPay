package br.com.picpay.pagamentosimplificado.application.user.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String msg) {
        super(msg);
    }

}
