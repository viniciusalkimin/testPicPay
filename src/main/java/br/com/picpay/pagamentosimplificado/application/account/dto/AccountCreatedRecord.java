package br.com.picpay.pagamentosimplificado.application.account.dto;

import br.com.picpay.pagamentosimplificado.domain.account.Account;
import br.com.picpay.pagamentosimplificado.domain.account.enums.AccountType;

import java.math.BigDecimal;
import java.util.UUID;

public record AccountCreatedRecord(UUID id, AccountHolderRecord accountHolderRecord, BigDecimal balance, AccountType accountType) {

    public AccountCreatedRecord(Account account, AccountHolderRecord accountHolderRecord) {
        this(account.getId(), accountHolderRecord, account.getBalance(), account.getAccountType());
    }
}
