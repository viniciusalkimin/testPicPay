package br.com.picpay.pagamentosimplificado.infrastructure.account.service.impl;

import br.com.picpay.pagamentosimplificado.application.account.dto.CreationAccountDataDTO;
import br.com.picpay.pagamentosimplificado.application.account.service.AccountService;
import br.com.picpay.pagamentosimplificado.application.account.utils.AccountBuilder;
import br.com.picpay.pagamentosimplificado.application.account.dto.AccountCreatedRecord;
import br.com.picpay.pagamentosimplificado.application.account.dto.AccountHolderRecord;
import br.com.picpay.pagamentosimplificado.application.user.exception.UserNotFoundException;
import br.com.picpay.pagamentosimplificado.infrastructure.account.repository.AccountRepository;
import br.com.picpay.pagamentosimplificado.infrastructure.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    private UserRepository userRepository;

    private AccountBuilder accountBuilder;

    @Override
    public AccountCreatedRecord createAccount(CreationAccountDataDTO creationAccountDataDTO) {
        log.info("Status = início, AccountService.createAccount().");
        var user = userRepository.findById(UUID.fromString(creationAccountDataDTO.userId())).orElseThrow(() ->
                new UserNotFoundException("User informed do not exists!"));
        var account = accountBuilder.create(creationAccountDataDTO, user);
        accountRepository.save(account);
        var accountHolder = new AccountHolderRecord(account.getHolder());
        log.info("Status = fim, AccountService.createAccount().");
        return new AccountCreatedRecord(account, accountHolder);
    }
}
