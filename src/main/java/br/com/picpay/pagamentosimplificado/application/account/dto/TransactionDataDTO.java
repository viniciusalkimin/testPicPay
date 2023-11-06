package br.com.picpay.pagamentosimplificado.application.account.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record TransactionDataDTO(
        @NotBlank(message = "Field idAccountPayer not be null or blank!")
        String idAccountPayer,
        @NotBlank(message = "Field idAccountReceiver not be null or blank!")
        String idAccountReceiver,
        @NotNull(message = "Field value not be null!")
        BigDecimal value) {
}
