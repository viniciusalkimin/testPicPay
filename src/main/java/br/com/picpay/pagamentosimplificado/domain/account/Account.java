package br.com.picpay.pagamentosimplificado.domain.account;

import br.com.picpay.pagamentosimplificado.domain.account.enums.AccountType;
import br.com.picpay.pagamentosimplificado.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne
    private User holder;

    private BigDecimal balance;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

}
