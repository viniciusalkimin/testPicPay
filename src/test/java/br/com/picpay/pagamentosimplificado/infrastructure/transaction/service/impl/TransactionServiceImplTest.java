package br.com.picpay.pagamentosimplificado.infrastructure.transaction.service.impl;

import br.com.picpay.pagamentosimplificado.infrastructure.validation.AccountValidation;
import br.com.picpay.pagamentosimplificado.application.utils.ObjectBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class TransactionServiceImplTest {

    @InjectMocks
    TransactionServiceImpl transactionService;

    @Mock
    RabbitTemplate rabbitTemplate;

    @Mock
    AccountValidation accountValidation;

    @Test
    void shouldSendTransactionWithSuccess() {
        var transactionDTO = ObjectBuilder.createTransactionData();
        var transactionSended = transactionService.sendTransaction(transactionDTO);
        assertEquals(transactionDTO.value(), transactionSended.value());
        assertEquals(transactionDTO.idAccountReceiver(), transactionSended.receiverAccountId());
    }
}