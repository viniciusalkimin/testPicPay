package br.com.picpay.pagamentosimplificado.application.account.exception;

public class AccountTypeNotPermitTransactionException extends RuntimeException {
public AccountTypeNotPermitTransactionException(String msg) {
    super(msg);
}

}
