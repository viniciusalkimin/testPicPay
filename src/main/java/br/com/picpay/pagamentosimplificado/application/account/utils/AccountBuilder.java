package br.com.picpay.pagamentosimplificado.application.account.utils;

import br.com.picpay.pagamentosimplificado.application.account.dto.CreationAccountDataDTO;
import br.com.picpay.pagamentosimplificado.domain.account.Account;
import br.com.picpay.pagamentosimplificado.domain.user.User;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component
public final class AccountBuilder {

    public Account create(CreationAccountDataDTO creationAccountDataDTO, User user){
        var initialValue = BigDecimal.ZERO;
        if(initialValue.compareTo(creationAccountDataDTO.initialValue()) < 0) {
            initialValue = creationAccountDataDTO.initialValue();
        }
        return new Account(null, user, initialValue, creationAccountDataDTO.accountType());
    }
}
