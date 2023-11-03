package br.com.picpay.pagamentosimplificado.application.user;

import br.com.picpay.pagamentosimplificado.application.user.security.CryptoService;
import br.com.picpay.pagamentosimplificado.application.user.validation.UserCreateValidator;
import br.com.picpay.pagamentosimplificado.domain.user.User;
import br.com.picpay.pagamentosimplificado.domain.user.dto.UserCreatedRecord;
import br.com.picpay.pagamentosimplificado.domain.user.dto.UserRecord;
import br.com.picpay.pagamentosimplificado.infrastructure.user.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    private UserCreateValidator userCreateValidator;

    private CryptoService cryptoService;
    
    public static final ModelMapper modelMapper = new ModelMapper();

    public UserCreatedRecord createUser(UserRecord userRecord) {
        User user = new User(userRecord);
        userCreateValidator.validation(user);
        var passwordCrypto = cryptoService.encryptPassword(userRecord.password());
        user.setPassword(passwordCrypto);
        userRepository.save(user);
        return new UserCreatedRecord(user);
    }
}
