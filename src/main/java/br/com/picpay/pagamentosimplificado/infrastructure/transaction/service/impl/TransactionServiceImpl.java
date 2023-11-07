package br.com.picpay.pagamentosimplificado.infrastructure.transaction.service.impl;

import br.com.picpay.pagamentosimplificado.application.account.dto.TransactionDataDTO;
import br.com.picpay.pagamentosimplificado.application.account.validation.AccountValidation;
import br.com.picpay.pagamentosimplificado.application.transaction.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private RabbitTemplate rabbitTemplate;

    private AccountValidation accountValidation;
    private final String QUEUE_NAME = "transaction";
    @Override
    public void sendTransaction(TransactionDataDTO transactionDataDTO) {
        accountValidation.valid(transactionDataDTO);
        rabbitTemplate.convertAndSend(QUEUE_NAME, transactionDataDTO);
    }
}
