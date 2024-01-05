package br.com.picpay.pagamentosimplificado.infrastructure.validation;

import br.com.picpay.pagamentosimplificado.application.account.dto.TransactionDataDTO;
import br.com.picpay.pagamentosimplificado.application.account.exception.AccountNotFoundException;
import br.com.picpay.pagamentosimplificado.application.account.exception.AccountTypeNotPermitTransactionException;
import br.com.picpay.pagamentosimplificado.application.account.exception.InsuficientBalanceException;
import br.com.picpay.pagamentosimplificado.domain.account.enums.AccountType;
import br.com.picpay.pagamentosimplificado.infrastructure.account.repository.AccountRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
@AllArgsConstructor
public class AccountValidation {

    private AccountRepository accountRepository;

    public void valid(TransactionDataDTO transactionDataDTO){
        log.info("Status = início, AccountValidation.valid().");
        if(accountRepository.findById(UUID.fromString(transactionDataDTO.idAccountReceiver())).isEmpty()) {
            log.error("Status = error, AccountValidation.valid() / AccountNotFoundException.");
            throw new AccountNotFoundException("Account of receiver informed do not exists!");
        }
        var accountPayer = accountRepository.findById(UUID.fromString(transactionDataDTO.idAccountPayer())).orElseThrow(() -> new AccountNotFoundException("Account of payer informed do not exists!"));
        if(accountPayer.getAccountType().equals(AccountType.COMPANY)) {
            log.error("Status = error, AccountValidation.valid() / AccountTypeNotPermitTransactionException.");
            throw new AccountTypeNotPermitTransactionException("Account type of payer dont permit send transaction!");
        }
        if(transactionDataDTO.value().compareTo(accountPayer.getBalance()) > 0 ) {
            log.error("Status = error, AccountValidation.valid() / InsuficientBalanceException.");
            throw new InsuficientBalanceException("Balance is insuficient to realize this transation!");
        }
        log.info("Status = fim, AccountValidation.valid().");
    }
}
