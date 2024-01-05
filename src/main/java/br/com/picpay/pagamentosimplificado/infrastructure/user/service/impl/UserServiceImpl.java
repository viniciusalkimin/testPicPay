package br.com.picpay.pagamentosimplificado.infrastructure.user.service.impl;

import br.com.picpay.pagamentosimplificado.application.user.security.CryptoService;
import br.com.picpay.pagamentosimplificado.application.user.service.UserService;
import br.com.picpay.pagamentosimplificado.application.user.validation.UserCreateValidator;
import br.com.picpay.pagamentosimplificado.domain.user.User;
import br.com.picpay.pagamentosimplificado.domain.user.dto.UserCreatedRecord;
import br.com.picpay.pagamentosimplificado.domain.user.dto.UserRecord;
import br.com.picpay.pagamentosimplificado.domain.user.enums.UserType;
import br.com.picpay.pagamentosimplificado.infrastructure.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private UserCreateValidator userCreateValidator;

    private CryptoService cryptoService;

    public UserCreatedRecord createUser(UserRecord userRecord) {
        log.info("Status = início, UserService.createUser().");
        User user = new User(userRecord);
        userCreateValidator.validation(user);
        var passwordCrypto = cryptoService.encryptPassword(userRecord.password());
        user.setPassword(passwordCrypto);
        userRepository.save(user);
        log.info("Status = fim, UserService.createUser().");
        return new UserCreatedRecord(user);
    }

}
