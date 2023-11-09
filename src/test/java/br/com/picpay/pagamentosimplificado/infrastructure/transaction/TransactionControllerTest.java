package br.com.picpay.pagamentosimplificado.infrastructure.transaction;

import br.com.picpay.pagamentosimplificado.application.transaction.TransactionService;
import br.com.picpay.pagamentosimplificado.application.transaction.dto.TransactionSendedRecord;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TransactionControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    TransactionService transactionService;

    @Mock
    TransactionSendedRecord transactionSendedRecord;

    String path = "/pagamento-simplificado/api/transacations";

    @Test
    void shouldReturnStatus200SendTransaction() throws Exception {
        String requestBody = """
                {
                    "idAccountPayer": "7d7dcc41-986a-49a8-8daf-6c6421083ebb",
                    "idAccountReceiver": "1014e554-77a9-49e6-9ef0-845306a87b37",
                    "value": "15"
                }
                """;
        Mockito.when(transactionService.sendTransaction(any())).thenReturn(transactionSendedRecord);
        mockMvc.perform(post(path).contentType(MediaType.APPLICATION_JSON).content(requestBody)).andExpect(status().isOk());
    }

    @Test
    void shouldReturnStatus400SendTransaction() throws Exception {
        String requestBody = """
                {
                    "idAccountPayer": "",
                    "idAccountReceiver": "1014e554-77a9-49e6-9ef0-845306a87b37",
                    "value": "15"
                }
                """;
        Mockito.when(transactionService.sendTransaction(any())).thenReturn(transactionSendedRecord);
        mockMvc.perform(post(path).contentType(MediaType.APPLICATION_JSON).content(requestBody)).andExpect(status().isBadRequest());
    }


}