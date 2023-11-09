package br.com.picpay.pagamentosimplificado.application.utils;

import br.com.picpay.pagamentosimplificado.domain.user.dto.UserRecord;
import br.com.picpay.pagamentosimplificado.domain.user.enums.UserType;

import java.util.UUID;

public class ObjectBuilder {

    public static UserRecord createUserRecord(){
        return new UserRecord(UUID.randomUUID(), "Vinicius Alkimin", UserType.INDIVIDUAL_USER, "12345", "vini@email.com", "12345");
    }
}
