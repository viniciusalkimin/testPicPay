package br.com.picpay.pagamentosimplificado.application.account.dto;

import br.com.picpay.pagamentosimplificado.domain.account.enums.AccountType;

import java.math.BigDecimal;

public record CreationAccountDataDTO(String userId, AccountType accountType, BigDecimal initialValue) {
}
