package br.com.picpay.pagamentosimplificado.application.account.validation;

import br.com.picpay.pagamentosimplificado.application.account.exception.AccountNotFoundException;
import br.com.picpay.pagamentosimplificado.application.account.exception.AccountTypeNotPermitTransactionException;
import br.com.picpay.pagamentosimplificado.application.account.exception.InsuficientBalanceException;
import br.com.picpay.pagamentosimplificado.domain.account.enums.AccountType;
import br.com.picpay.pagamentosimplificado.infrastructure.account.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import static br.com.picpay.pagamentosimplificado.application.utils.ObjectBuilder.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountValidationTest {

    @InjectMocks
    AccountValidation accountValidation;

    @Mock
    AccountRepository accountRepository;


    @Test
    void shouldThrowAccountNotFoundException(){
        var transactionDTO = createTransactionData();
        when(accountRepository.findById(any())).thenReturn(Optional.empty());
        assertThrows(AccountNotFoundException.class, () -> accountValidation.valid(transactionDTO));
    }

    @Test
    void shouldThrowAccountTypeNotPermitTransactionException(){
        var user = createUser();
        var transactionDTO = createTransactionData();
        when(accountRepository.findById(UUID.fromString(transactionDTO.idAccountReceiver()))).thenReturn(Optional.of(createAccount(user, AccountType.INDIVIDUAL, BigDecimal.valueOf(500L))));
        when(accountRepository.findById(UUID.fromString(transactionDTO.idAccountPayer()))).thenReturn(Optional.of(createAccount(user, AccountType.COMPANY, BigDecimal.valueOf(500L))));
        assertThrows(AccountTypeNotPermitTransactionException.class, () -> accountValidation.valid(transactionDTO));
    }

    @Test
    void shouldThrowInsuficientBalanceExceptionException(){
        var user = createUser();
        var transactionDTO = createTransactionData();
        when(accountRepository.findById(UUID.fromString(transactionDTO.idAccountReceiver()))).thenReturn(Optional.of(createAccount(user, AccountType.INDIVIDUAL, BigDecimal.valueOf(500L))));
        when(accountRepository.findById(UUID.fromString(transactionDTO.idAccountPayer()))).thenReturn(Optional.of(createAccount(user, AccountType.INDIVIDUAL, BigDecimal.valueOf(50L))));
        assertThrows(InsuficientBalanceException.class, () -> accountValidation.valid(transactionDTO));
    }

    @Test
    void shouldValidTransactionWithSuccess(){
        var user = createUser();
        var transactionDTO = createTransactionData();
        when(accountRepository.findById(UUID.fromString(transactionDTO.idAccountReceiver()))).thenReturn(Optional.of(createAccount(user, AccountType.INDIVIDUAL, BigDecimal.valueOf(500L))));
        when(accountRepository.findById(UUID.fromString(transactionDTO.idAccountPayer()))).thenReturn(Optional.of(createAccount(user, AccountType.INDIVIDUAL, BigDecimal.valueOf(500L))));
        accountValidation.valid(transactionDTO);
    }

}