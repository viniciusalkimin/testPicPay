package br.com.picpay.pagamentosimplificado.domain.account;

import java.math.BigDecimal;

public class CompanyAccount extends Account{
    @Override
    public BigDecimal receivePayment(Account payerAccount, BigDecimal value) {
        return null;
    }
}
