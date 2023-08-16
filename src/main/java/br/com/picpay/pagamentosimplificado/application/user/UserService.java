package br.com.picpay.pagamentosimplificado.application.user;

import br.com.picpay.pagamentosimplificado.application.user.security.CryptoService;
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

    private CryptoService cryptoService;
    
    public static final ModelMapper modelMapper = new ModelMapper();

    public Object createUser(UserRecord userRecord) {
        User user = new User(userRecord);
        var passwordCrypto = cryptoService.encryptPassword(userRecord.password());
        user.setPassword(passwordCrypto);
        userRepository.save(user);
        return new UserCreatedRecord(user);
    }
}
