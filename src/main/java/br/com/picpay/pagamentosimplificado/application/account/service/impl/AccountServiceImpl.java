package br.com.picpay.pagamentosimplificado.application.account.service.impl;

import br.com.picpay.pagamentosimplificado.application.account.dto.CreationAccountDataDTO;
import br.com.picpay.pagamentosimplificado.application.account.service.AccountService;
import br.com.picpay.pagamentosimplificado.application.account.utils.AccountBuilder;
import br.com.picpay.pagamentosimplificado.domain.account.dto.AccountCreatedRecord;
import br.com.picpay.pagamentosimplificado.domain.account.dto.AccountHolderRecord;
import br.com.picpay.pagamentosimplificado.infrastructure.account.AccountRepository;
import br.com.picpay.pagamentosimplificado.infrastructure.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    private UserRepository userRepository;

    private AccountBuilder accountBuilder;



    @Override
    public AccountCreatedRecord createAccount(CreationAccountDataDTO creationAccountDataDTO) {
        var user = userRepository.findById(UUID.fromString(creationAccountDataDTO.userId())).orElseThrow(() ->
                new RuntimeException("Usuario não existe!"));
        var account = accountBuilder.create(creationAccountDataDTO, user);
        accountRepository.save(account);
        var accountHolder = new AccountHolderRecord(account.getHolder());
        return new AccountCreatedRecord(account, accountHolder);
    }
}
