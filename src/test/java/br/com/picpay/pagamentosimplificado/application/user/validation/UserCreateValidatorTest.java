package br.com.picpay.pagamentosimplificado.application.user.validation;

import br.com.picpay.pagamentosimplificado.application.user.exception.DocumentAlreadyUseException;
import br.com.picpay.pagamentosimplificado.application.user.exception.EmailAlreadyUseException;
import br.com.picpay.pagamentosimplificado.domain.user.User;
import br.com.picpay.pagamentosimplificado.infrastructure.user.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class UserCreateValidatorTest {


    @InjectMocks
    UserCreateValidator validator;

    @Mock
    UserRepository userRepository;

    @Mock
    User user;

    @Test
    void shouldThrowEmailAlreadyUseExceptionWhenTryCreateUser(){
        Mockito.when(userRepository.existsByDocument(any())).thenReturn(true);
        Assertions.assertThrows(DocumentAlreadyUseException.class, () -> validator.validation(user));
    }

    @Test
    void shouldThrowDocumentAlreadyUseExceptionWhenTryCreateUser(){
        Mockito.when(userRepository.existsByEmail(any())).thenReturn(true);
        Assertions.assertThrows(EmailAlreadyUseException.class, () -> validator.validation(user));
    }

}