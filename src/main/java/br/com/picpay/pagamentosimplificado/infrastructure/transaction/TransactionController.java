package br.com.picpay.pagamentosimplificado.infrastructure.transaction;

import br.com.picpay.pagamentosimplificado.application.account.dto.TransactionDataDTO;
import br.com.picpay.pagamentosimplificado.application.transaction.TransactionService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("${application.context-path}/transacations")
public class TransactionController {

    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity transaction(@RequestBody @Valid TransactionDataDTO transactionData){
        transactionService.sendTransaction(transactionData);
        return ResponseEntity.ok().build();
    }

}
