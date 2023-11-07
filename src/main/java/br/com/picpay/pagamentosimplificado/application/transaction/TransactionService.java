package br.com.picpay.pagamentosimplificado.application.transaction;

import br.com.picpay.pagamentosimplificado.application.account.dto.TransactionDataDTO;
import br.com.picpay.pagamentosimplificado.application.transaction.dto.TransactionSendedRecord;

public interface TransactionService {

    TransactionSendedRecord sendTransaction(TransactionDataDTO transactionDataDTO);
}
