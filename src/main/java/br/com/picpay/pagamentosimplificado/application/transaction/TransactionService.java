package br.com.picpay.pagamentosimplificado.application.transaction;

import br.com.picpay.pagamentosimplificado.application.account.dto.TransactionDataDTO;

public interface TransactionService {

    void sendTransaction(TransactionDataDTO transactionDataDTO);
}
