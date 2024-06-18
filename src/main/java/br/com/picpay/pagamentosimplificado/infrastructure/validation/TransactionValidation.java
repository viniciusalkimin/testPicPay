package br.com.picpay.pagamentosimplificado.infrastructure.validation;

import br.com.picpay.pagamentosimplificado.application.exception.NotAuthorizedTranscationException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
@AllArgsConstructor
public class TransactionValidation {

    private TransactionAutorizatorService transactionAutorizatorService;

    public void valid() {
        var transactionResponse = transactionAutorizatorService.validTransaction();
        try {
            transactionResponse.block();
        }catch (WebClientResponseException ex){
            throw new NotAuthorizedTranscationException("Transaction non authorized!");
        }
    }
}
