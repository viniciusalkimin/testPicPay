package br.com.picpay.pagamentosimplificado.application.user.validation;

import br.com.picpay.pagamentosimplificado.application.user.exception.DocumentAlreadyUseException;
import br.com.picpay.pagamentosimplificado.application.user.exception.EmailAlreadyUseException;
import br.com.picpay.pagamentosimplificado.domain.user.User;
import br.com.picpay.pagamentosimplificado.infrastructure.user.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class UserCreateValidator {

    private UserRepository userRepository;

    public void validation(User user) {

        boolean existsByEmail = userRepository.existsByEmail(user.getEmail());
        boolean existsByDocument = userRepository.existsByDocument(user.getDocument());
        if (!existsByDocument) {
            log.error("Error to create user, document {}, alerady in use.", user.getDocument());
            throw new DocumentAlreadyUseException("Unable to create this user, document is already in use.");
        }
        if (!existsByEmail) {
            log.error("Error to create user, email {}, alerady in use.", user.getEmail());
            throw new EmailAlreadyUseException("Unable to create this user, email is already in use.");
        }

    }
}
