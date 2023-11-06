package br.com.picpay.pagamentosimplificado.application.account.validation;

import br.com.picpay.pagamentosimplificado.application.account.dto.TransactionDataDTO;
import br.com.picpay.pagamentosimplificado.application.account.exception.AccountNotFoundException;
import br.com.picpay.pagamentosimplificado.application.account.exception.InsuficientBalanceException;
import br.com.picpay.pagamentosimplificado.infrastructure.account.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor
public class AccountValidation {

    private AccountRepository accountRepository;

    public void valid(TransactionDataDTO transactionDataDTO){
        var accountReceiver = accountRepository.findById(UUID.fromString(transactionDataDTO.idAccountReceiver())).orElseThrow(() -> new AccountNotFoundException("Account of receiver informed do not exists!"));
        var accountPayer = accountRepository.findById(UUID.fromString(transactionDataDTO.idAccountPayer())).orElseThrow(() -> new AccountNotFoundException("Account of payer informed do not exists!"));
        if(transactionDataDTO.value().compareTo(accountPayer.getBalance()) > 0 ) {
            throw new InsuficientBalanceException("Balance is insuficient to realize this transation!");
        }
    }
}
