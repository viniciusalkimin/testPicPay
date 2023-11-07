package br.com.picpay.pagamentosimplificado.infrastructure.account;

import br.com.picpay.pagamentosimplificado.application.account.dto.CreationAccountDataDTO;
import br.com.picpay.pagamentosimplificado.application.account.service.AccountService;
import br.com.picpay.pagamentosimplificado.application.account.dto.AccountCreatedRecord;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("${application.context-path}/accounts")
public class AccountController {

    private AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountCreatedRecord> depositExceptional(@RequestBody @Valid CreationAccountDataDTO creationAccountDataDTO){
        return ResponseEntity.ok(accountService.createAccount(creationAccountDataDTO));
    }
}
