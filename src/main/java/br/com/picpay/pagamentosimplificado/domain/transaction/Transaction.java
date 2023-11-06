package br.com.picpay.pagamentosimplificado.domain.transaction;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    private UUID transactionId;

    private String payerAccountId;

    private String receiverAccountId;

    private BigDecimal value;

    private LocalDateTime timestamp;

}
