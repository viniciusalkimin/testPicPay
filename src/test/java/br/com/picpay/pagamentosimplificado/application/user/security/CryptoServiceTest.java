package br.com.picpay.pagamentosimplificado.application.user.security;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CryptoServiceTest {


    @InjectMocks
    CryptoService cryptoService;

    private final String password = "12345678";

    @Test
    void shouldCryptoAndCompareValuesWhitSuccess() {
    var passwordHashed = cryptoService.encryptPassword(password);
        Assertions.assertTrue(cryptoService.comparePassword(password, passwordHashed));
    }
}