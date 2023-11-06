package br.com.picpay.pagamentosimplificado.application.account.service.impl;

import br.com.picpay.pagamentosimplificado.application.account.dto.TransactionDataDTO;
import br.com.picpay.pagamentosimplificado.application.account.service.AccountService;
import br.com.picpay.pagamentosimplificado.application.account.utils.AccountBuilder;
import br.com.picpay.pagamentosimplificado.application.account.validation.AccountValidation;
import br.com.picpay.pagamentosimplificado.domain.account.Account;
import br.com.picpay.pagamentosimplificado.infrastructure.account.AccountRepository;
import br.com.picpay.pagamentosimplificado.application.account.dto.CreationAccountDataDTO;
import br.com.picpay.pagamentosimplificado.infrastructure.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private RabbitTemplate rabbitTemplate;

    private AccountValidation accountValidation;

    private AccountRepository accountRepository;

    private UserRepository userRepository;

    private AccountBuilder accountBuilder;

    private final String FILA_TRANSACAO = "transacao";
    @Override
    public void sendTransaction(TransactionDataDTO transactionDataDTO) {
     accountValidation.valid(transactionDataDTO);
     rabbitTemplate.convertAndSend(FILA_TRANSACAO, transactionDataDTO);
    }

    @Override
    public Account createAccount(CreationAccountDataDTO creationAccountDataDTO) {
        var user = userRepository.findById(UUID.fromString(creationAccountDataDTO.userId())).orElseThrow(() ->
                new RuntimeException("Usuario não existe!"));
        var account = accountBuilder.create(creationAccountDataDTO, user);
        return accountRepository.save(account);
    }
}
