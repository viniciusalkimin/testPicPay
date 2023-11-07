package br.com.picpay.pagamentosimplificado.application.account.service;

import br.com.picpay.pagamentosimplificado.application.account.dto.CreationAccountDataDTO;
import br.com.picpay.pagamentosimplificado.application.account.dto.AccountCreatedRecord;

public interface AccountService {
    AccountCreatedRecord createAccount(CreationAccountDataDTO creationAccountDataDTO);
}
