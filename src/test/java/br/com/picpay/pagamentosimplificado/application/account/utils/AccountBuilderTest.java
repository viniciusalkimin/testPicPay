package br.com.picpay.pagamentosimplificado.application.account.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static br.com.picpay.pagamentosimplificado.application.utils.ObjectBuilder.createCreationAccountDTO;
import static br.com.picpay.pagamentosimplificado.application.utils.ObjectBuilder.createUser;

@ExtendWith(MockitoExtension.class)
class AccountBuilderTest {

    @InjectMocks
    AccountBuilder accountBuilder;

    @Test
    void shouldCreateAccountWithBalanceZero() {
        var user = createUser();
        var creationAccountDTO = createCreationAccountDTO(BigDecimal.ZERO);
        var account = accountBuilder.create(creationAccountDTO, user);
        Assertions.assertEquals(BigDecimal.ZERO, account.getBalance());
    }

    @Test
    void shouldCreateAccountWithBalanceInformed() {
        var user = createUser();
        var creationAccountDTO = createCreationAccountDTO(new BigDecimal("500"));
        var account = accountBuilder.create(creationAccountDTO, user);
        Assertions.assertEquals(BigDecimal.valueOf(500L), account.getBalance());
    }

}