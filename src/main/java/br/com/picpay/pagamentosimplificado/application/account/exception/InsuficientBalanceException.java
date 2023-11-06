package br.com.picpay.pagamentosimplificado.application.account.exception;

public class InsuficientBalanceException extends RuntimeException{
    public InsuficientBalanceException(String msg) {
        super(msg);
    }

}
