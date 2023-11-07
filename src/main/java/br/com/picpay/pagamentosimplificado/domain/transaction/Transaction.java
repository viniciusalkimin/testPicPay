package br.com.picpay.pagamentosimplificado.domain.transaction;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String payerAccountId;

    private String receiverAccountId;

    private BigDecimal transactionValue;

    private LocalDateTime moment;
}
