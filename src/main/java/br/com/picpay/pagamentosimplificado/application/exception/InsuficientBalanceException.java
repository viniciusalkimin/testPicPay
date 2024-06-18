package br.com.picpay.pagamentosimplificado.application.exception;

public class InsuficientBalanceException extends RuntimeException{
    public InsuficientBalanceException(String msg) {
        super(msg);
    }

}
