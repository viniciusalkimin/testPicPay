package br.com.picpay.pagamentosimplificado.infrastructure.user.service.impl;

import br.com.picpay.pagamentosimplificado.application.user.security.CryptoService;
import br.com.picpay.pagamentosimplificado.application.user.validation.UserCreateValidator;
import br.com.picpay.pagamentosimplificado.domain.user.User;
import br.com.picpay.pagamentosimplificado.domain.user.dto.UserCreatedRecord;
import br.com.picpay.pagamentosimplificado.infrastructure.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static br.com.picpay.pagamentosimplificado.application.utils.ObjectBuilder.createUserRecord;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.then;


@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {


    @InjectMocks
    UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserCreateValidator userCreateValidator;

    @Mock
    private CryptoService cryptoService;

    @Mock
    UserCreatedRecord userCreatedRecord;

    @Captor
    ArgumentCaptor<User> userCaptor;

    @Test
    void shouldCreateUserSuccess() {
        var userCreated = userService.createUser(createUserRecord());
        then(userRepository).should().save(userCaptor.capture());
        var userCaptured = userCaptor.getValue();
        assertEquals(userCreated.completeName(), userCaptured.getCompleteName());
        assertEquals(userCreated.email(), userCaptured.getEmail());
    }

}