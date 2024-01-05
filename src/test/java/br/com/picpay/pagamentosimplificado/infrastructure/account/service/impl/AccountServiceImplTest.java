package br.com.picpay.pagamentosimplificado.infrastructure.account.service.impl;

import br.com.picpay.pagamentosimplificado.application.account.utils.AccountBuilder;
import br.com.picpay.pagamentosimplificado.application.user.exception.UserNotFoundException;
import br.com.picpay.pagamentosimplificado.application.utils.ObjectBuilder;
import br.com.picpay.pagamentosimplificado.domain.account.Account;
import br.com.picpay.pagamentosimplificado.domain.account.enums.AccountType;
import br.com.picpay.pagamentosimplificado.infrastructure.account.repository.AccountRepository;
import br.com.picpay.pagamentosimplificado.infrastructure.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

import static br.com.picpay.pagamentosimplificado.application.utils.ObjectBuilder.createCreationAccountDTO;
import static br.com.picpay.pagamentosimplificado.application.utils.ObjectBuilder.createUser;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AccountServiceImplTest {

    @InjectMocks
    AccountServiceImpl accountService;

    @Mock
    UserRepository userRepository;

    @Mock
    AccountRepository accountRepository;

    @Mock
    AccountBuilder accountBuilder;

    @Test
    void shouldSaveAccountSuccess() {
        var user = createUser();
        var creationDTO = createCreationAccountDTO(new BigDecimal("50"));
        when(userRepository.findById(any())).thenReturn(Optional.of(user));
        when(accountBuilder.create(creationDTO, user)).thenReturn(ObjectBuilder.createAccount(user, AccountType.INDIVIDUAL, new BigDecimal("50")));
        var accountCreated = accountService.createAccount(creationDTO);
        assertEquals(creationDTO.initialValue(), accountCreated.balance());
        assertEquals(creationDTO.accountType(), accountCreated.accountType());
    }

    @Test
    void shouldThrowExceptionWhenTryCreateAccount() {
        var user = createUser();
        var creationDTO = createCreationAccountDTO(new BigDecimal("50"));
        when(userRepository.findById(any())).thenReturn(Optional.empty());
        assertThrows(UserNotFoundException.class, () -> accountService.createAccount(creationDTO));
    }


    private Account criaAccount() {
       return new Account(UUID.randomUUID(), createUser(), BigDecimal.ZERO, AccountType.INDIVIDUAL);
    }
}