package br.com.picpay.pagamentosimplificado.infrastructure.transaction.service.impl;

import br.com.picpay.pagamentosimplificado.application.account.dto.TransactionDataDTO;
import br.com.picpay.pagamentosimplificado.application.account.validation.AccountValidation;
import br.com.picpay.pagamentosimplificado.application.transaction.TransactionService;
import br.com.picpay.pagamentosimplificado.application.transaction.dto.TransactionSendedRecord;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private RabbitTemplate rabbitTemplate;

    private AccountValidation accountValidation;
    private static final String QUEUE_NAME = "transaction";
    @Override
    public TransactionSendedRecord sendTransaction(TransactionDataDTO transactionDataDTO) {
        log.info("Status = início, TransactionService.sendTransaction().");
        accountValidation.valid(transactionDataDTO);
        rabbitTemplate.convertAndSend(QUEUE_NAME, transactionDataDTO);
        log.info("Status = fim, TransactionService.sendTransaction().");
        return new TransactionSendedRecord(transactionDataDTO.idAccountReceiver(), transactionDataDTO.value(), LocalDateTime.now());

    }
}
