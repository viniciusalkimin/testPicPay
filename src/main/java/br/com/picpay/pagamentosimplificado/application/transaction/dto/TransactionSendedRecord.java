package br.com.picpay.pagamentosimplificado.application.transaction.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransactionSendedRecord(String receiverAccountId, BigDecimal value, LocalDateTime moment) {
}
