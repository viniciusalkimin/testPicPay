package br.com.picpay.pagamentosimplificado.domain.account;

import br.com.picpay.pagamentosimplificado.domain.user.User;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "accounts")
public abstract class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne
    private User holder;

    private BigDecimal balance;

    public abstract BigDecimal receivePayment(Account payerAccount, BigDecimal value);
}
