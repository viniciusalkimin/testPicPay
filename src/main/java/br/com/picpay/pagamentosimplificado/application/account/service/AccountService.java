package br.com.picpay.pagamentosimplificado.application.account.service;

import br.com.picpay.pagamentosimplificado.application.account.dto.TransactionDataDTO;
import br.com.picpay.pagamentosimplificado.application.account.dto.CreationAccountDataDTO;

public interface AccountService {

    void sendTransaction(TransactionDataDTO transactionDataDTO);

    Object createAccount(CreationAccountDataDTO creationAccountDataDTO);
}
