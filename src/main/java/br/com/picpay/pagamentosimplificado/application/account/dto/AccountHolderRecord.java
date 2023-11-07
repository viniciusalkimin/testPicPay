package br.com.picpay.pagamentosimplificado.application.account.dto;

import br.com.picpay.pagamentosimplificado.domain.user.User;
import br.com.picpay.pagamentosimplificado.domain.user.UserType;

public record AccountHolderRecord(String completeName, UserType userType, String document, String email) {

    public AccountHolderRecord(User user) {
        this(user.getCompleteName(), user.getUserType(), user.getDocument(), user.getEmail());
    }
}
