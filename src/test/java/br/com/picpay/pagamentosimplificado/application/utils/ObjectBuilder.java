package br.com.picpay.pagamentosimplificado.application.utils;

import br.com.picpay.pagamentosimplificado.application.account.dto.CreationAccountDataDTO;
import br.com.picpay.pagamentosimplificado.application.account.dto.TransactionDataDTO;
import br.com.picpay.pagamentosimplificado.domain.account.Account;
import br.com.picpay.pagamentosimplificado.domain.account.enums.AccountType;
import br.com.picpay.pagamentosimplificado.domain.transaction.Transaction;
import br.com.picpay.pagamentosimplificado.domain.user.User;
import br.com.picpay.pagamentosimplificado.domain.user.dto.UserRecord;
import br.com.picpay.pagamentosimplificado.domain.user.enums.UserType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class ObjectBuilder {

    public static UserRecord createUserRecord(){
        return new UserRecord(UUID.randomUUID(), "Vinicius Alkimin", UserType.INDIVIDUAL_USER, "12345", "vini@email.com", "12345");
    }

    public static User createUser(){
        return new User(UUID.fromString("550e8400-e29b-41d4-a716-446655440000"), "Vinicius Alkimin", UserType.INDIVIDUAL_USER, "12345", "vini@email.com", "12345");
    }

    public static Account createAccount(User user, AccountType accountType, BigDecimal initialValue) {
        return new Account(UUID.fromString("550e8400-e29b-41d4-a716-556655440000"), user, initialValue, accountType);
    }
    public static CreationAccountDataDTO createCreationAccountDTO(BigDecimal initialValue) {
        return new CreationAccountDataDTO("550e8400-e29b-41d4-a716-446655440000", AccountType.INDIVIDUAL, initialValue.compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : initialValue);
    }

    public static TransactionDataDTO createTransactionData() {
        return new TransactionDataDTO("43e2d264-7f4c-11ee-b962-0242ac120002", "4cd3e1d8-7f4c-11ee-b962-0242ac120002", new BigDecimal("250"));
    }

    public static Transaction createTransaction() {
        return new Transaction(UUID.randomUUID(), "43e2d264-7f4c-11ee-b962-0242ac120002", "4cd3e1d8-7f4c-11ee-b962-0242ac120002", BigDecimal.valueOf(500L), LocalDateTime.now());
    }
}

