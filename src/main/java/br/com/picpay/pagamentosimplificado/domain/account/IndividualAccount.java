package br.com.picpay.pagamentosimplificado.domain.account;

import java.math.BigDecimal;
import java.util.UUID;

public class IndividualAccount extends Account{

    private UUID id;

    private BigDecimal balance;

    @Override
    public BigDecimal receivePayment(Account payerAccount, BigDecimal value) {
        return null;
    }
}
