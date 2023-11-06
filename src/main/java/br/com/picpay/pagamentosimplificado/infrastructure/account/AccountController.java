package br.com.picpay.pagamentosimplificado.infrastructure.account;

import br.com.picpay.pagamentosimplificado.application.account.dto.CreationAccountDataDTO;
import br.com.picpay.pagamentosimplificado.application.account.dto.TransactionDataDTO;
import br.com.picpay.pagamentosimplificado.application.account.service.AccountService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("${application.context-path}/account")
public class AccountController {

    private AccountService accountService;

    @PostMapping
    public ResponseEntity transaction(@RequestBody @Valid TransactionDataDTO transactionData){
        accountService.sendTransaction(transactionData);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/createAccount")
    public ResponseEntity depositExceptional(@RequestBody @Valid CreationAccountDataDTO creationAccountDataDTO){
        return ResponseEntity.ok(accountService.createAccount(creationAccountDataDTO));
    }
}
