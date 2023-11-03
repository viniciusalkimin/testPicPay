package br.com.picpay.pagamentosimplificado.application.user.security;

import lombok.AllArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CryptoService {
    private static final int cryptoKey = 10;

    public String encryptPassword(String password) {
        String salt = BCrypt.gensalt(cryptoKey);
        return BCrypt.hashpw(password, salt);
    }

    public boolean comparePassword(String password, String passwordEncrypted) {
       return BCrypt.checkpw(password, passwordEncrypted);
    }
}
