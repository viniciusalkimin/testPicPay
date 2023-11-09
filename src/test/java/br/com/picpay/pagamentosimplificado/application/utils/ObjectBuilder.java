package br.com.picpay.pagamentosimplificado.application.utils;

import br.com.picpay.pagamentosimplificado.application.account.dto.CreationAccountDataDTO;
import br.com.picpay.pagamentosimplificado.domain.account.Account;
import br.com.picpay.pagamentosimplificado.domain.account.enums.AccountType;
import br.com.picpay.pagamentosimplificado.domain.user.User;
import br.com.picpay.pagamentosimplificado.domain.user.dto.UserRecord;
import br.com.picpay.pagamentosimplificado.domain.user.enums.UserType;

import java.math.BigDecimal;
import java.util.UUID;

public class ObjectBuilder {

    public static UserRecord createUserRecord(){
        return new UserRecord(UUID.randomUUID(), "Vinicius Alkimin", UserType.INDIVIDUAL_USER, "12345", "vini@email.com", "12345");
    }

    public static User createUser(){
        return new User(UUID.fromString("550e8400-e29b-41d4-a716-446655440000"), "Vinicius Alkimin", UserType.INDIVIDUAL_USER, "12345", "vini@email.com", "12345");
    }

    public static Account createAccount(User user, BigDecimal initialValue) {
        return new Account(UUID.fromString("550e8400-e29b-41d4-a716-556655440000"), user, initialValue, AccountType.INDIVIDUAL);
    }
    public static CreationAccountDataDTO createCreationAccountDTO(BigDecimal initialValue) {
        return new CreationAccountDataDTO("550e8400-e29b-41d4-a716-446655440000", AccountType.INDIVIDUAL, initialValue.compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : initialValue);
    }
}
