package br.com.picpay.pagamentosimplificado.application.user.service;

import br.com.picpay.pagamentosimplificado.domain.user.dto.UserCreatedRecord;
import br.com.picpay.pagamentosimplificado.domain.user.dto.UserRecord;

public interface UserService {

    public UserCreatedRecord createUser(UserRecord userRecord);
}
