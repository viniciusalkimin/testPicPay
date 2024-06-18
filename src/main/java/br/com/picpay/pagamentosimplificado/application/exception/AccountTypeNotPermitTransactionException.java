package br.com.picpay.pagamentosimplificado.application.exception;

public class AccountTypeNotPermitTransactionException extends RuntimeException {
public AccountTypeNotPermitTransactionException(String msg) {
    super(msg);
}

}
