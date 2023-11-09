package br.com.picpay.pagamentosimplificado.infrastructure.account;

import br.com.picpay.pagamentosimplificado.application.account.dto.AccountCreatedRecord;
import br.com.picpay.pagamentosimplificado.application.account.service.AccountService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class AccountControllerTest {


    @Autowired
    MockMvc mockMvc;

    @MockBean
    AccountService accountService;

    @Mock
    AccountCreatedRecord accountCreatedRecord;

    public static final String path = "/pagamento-simplificado/api/accounts";

    @Test
    void deveRetornar200CriarAccount() throws Exception {
        String requestBody = """
                {
                    "userId": "8331daf7-75c1-49d1-8807-e12842022916",
                    "accountType": "INDIVIDUAL",
                    "initialValue": "560"
                }
                """;
        Mockito.when(accountService.createAccount(any())).thenReturn(accountCreatedRecord);
        mockMvc.perform(post(path).contentType(MediaType.APPLICATION_JSON).content(requestBody)).andExpect(status().isOk());
    }

    @Test
    void deveRetornar400CriarAccount() throws Exception {
        String requestBody = """
                {
                    "userId": "",
                    "accountType": "INDIVIDUAL",
                    "initialValue": "560"
                }
                """;
        Mockito.when(accountService.createAccount(any())).thenReturn(accountCreatedRecord);
        mockMvc.perform(post(path).contentType(MediaType.APPLICATION_JSON).content(requestBody)).andExpect(status().isBadRequest());
    }

}