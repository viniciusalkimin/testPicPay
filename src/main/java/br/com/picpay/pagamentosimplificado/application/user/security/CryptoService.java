package br.com.picpay.pagamentosimplificado.application.user.security;

import lombok.AllArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CryptoService {
    private static final int CRYPTO_KEY = 10;

    public String encryptPassword(String password) {
        String salt = BCrypt.gensalt(CRYPTO_KEY );
        return BCrypt.hashpw(password, salt);
    }

    public boolean comparePassword(String password, String passwordEncrypted) {
       return BCrypt.checkpw(password, passwordEncrypted);
    }
}
