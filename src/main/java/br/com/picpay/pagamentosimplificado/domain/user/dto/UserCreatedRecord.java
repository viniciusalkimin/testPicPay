package br.com.picpay.pagamentosimplificado.domain.user.dto;

import br.com.picpay.pagamentosimplificado.domain.user.User;
import br.com.picpay.pagamentosimplificado.domain.user.enums.UserType;

import java.util.UUID;

public record UserCreatedRecord(UUID id, String completeName, UserType userType, String document, String email) {

    public UserCreatedRecord(User user) {
        this(user.getId(), user.getCompleteName(), user.getUserType(), user.getDocument(), user.getEmail());
    }
}
