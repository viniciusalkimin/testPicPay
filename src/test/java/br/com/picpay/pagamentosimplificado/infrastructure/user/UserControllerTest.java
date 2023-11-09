package br.com.picpay.pagamentosimplificado.infrastructure.user;

import br.com.picpay.pagamentosimplificado.domain.user.dto.UserCreatedRecord;
import br.com.picpay.pagamentosimplificado.infrastructure.user.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    public UserServiceImpl userService;

    @MockBean
    public UserCreatedRecord userCreatedRecord;
    public static final String path = "/pagamento-simplificado/api/users";

    @Test
    void deveRetornar200CriarUsuario() throws Exception{
        String requestBody = "{\"completeName\":\"ViniAlkimin\",\"userType\":\"INDIVIDUAL_USER\",\"document\":\"12345684\",\"email\":\"v@email.com\",\"password\":\"12345\"}";
        when(userService.createUser(any())).thenReturn(userCreatedRecord);
        mockMvc.perform(post(path).contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)).andExpect(status().isOk());
    }

    @Test
    void deveRetornar400CriarUsuario() throws Exception{
        String requestBody = """
                {
                    "completeName": "",
                    "userType": "INDIVIDUAL_USER",
                    "document": "12345684",
                    "email" : "v@email.com",
                    "password": "12345"
                }
                """;
        when(userService.createUser(any())).thenReturn(userCreatedRecord);
        mockMvc.perform(post(path).contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)).andExpect(status().isBadRequest());
    }

}