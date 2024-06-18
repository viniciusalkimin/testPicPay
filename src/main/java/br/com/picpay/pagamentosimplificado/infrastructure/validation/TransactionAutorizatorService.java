package br.com.picpay.pagamentosimplificado.infrastructure.validation;

import br.com.picpay.pagamentosimplificado.infrastructure.validation.dto.ValidationTransactionRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class TransactionAutorizatorService {

    private final WebClient webClient;

    @Autowired
    public TransactionAutorizatorService(WebClient.Builder webclientBuilder) {
        this.webClient = webclientBuilder.baseUrl("https://util.devi.tools/api").build();
    }

    public Mono<ResponseEntity<ValidationTransactionRequest>> validTransaction() {
        return webClient.get().uri("/v2/authorize")
                .retrieve()
                .toEntity(ValidationTransactionRequest.class);
    }
}
