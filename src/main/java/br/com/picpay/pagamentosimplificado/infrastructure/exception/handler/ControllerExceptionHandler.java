package br.com.picpay.pagamentosimplificado.infrastructure.exception.handler;

import br.com.picpay.pagamentosimplificado.application.exception.AccountNotFoundException;
import br.com.picpay.pagamentosimplificado.application.exception.AccountTypeNotPermitTransactionException;
import br.com.picpay.pagamentosimplificado.application.exception.InsuficientBalanceException;
import br.com.picpay.pagamentosimplificado.application.exception.NotAuthorizedTranscationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class ControllerExceptionHandler {

    @ExceptionHandler(AccountNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<String> accountNotFoundException(){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account informed do not exists!.");
    }

    @ExceptionHandler(AccountTypeNotPermitTransactionException.class)
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public ResponseEntity<String> accountTypeNotPermitTransactionException(){
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Account type of payer dont permit send transaction.");
    }
    @ExceptionHandler(InsuficientBalanceException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> insuficientBalanceException(){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Balance is insuficient to realize this transaction!");
    }
    @ExceptionHandler(NotAuthorizedTranscationException.class)
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public ResponseEntity<String> notAuthorizedTranscationException(){
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Transaction non authorized!");
    }
}
