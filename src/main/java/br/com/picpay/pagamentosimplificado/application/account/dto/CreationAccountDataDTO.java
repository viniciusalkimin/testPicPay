package br.com.picpay.pagamentosimplificado.application.account.dto;

import br.com.picpay.pagamentosimplificado.domain.account.enums.AccountType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CreationAccountDataDTO(@NotBlank String userId, @NotNull AccountType accountType,@NotNull BigDecimal initialValue) {
}
