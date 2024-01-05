package br.com.picpay.pagamentosimplificado.infrastructure.user;

import br.com.picpay.pagamentosimplificado.application.user.service.UserService;
import br.com.picpay.pagamentosimplificado.application.utils.ObjectBuilder;
import br.com.picpay.pagamentosimplificado.domain.user.dto.UserCreatedRecord;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    public UserService userService;

    @Mock
    public UserCreatedRecord userCreatedRecord;
    public static final String path = "/pagamento-simplificado/api/users";

    @Test
    void deveRetornar200CriarUsuario() throws Exception{
        String requestBody = "{\"completeName\":\"ViniAlkimin\",\"userType\":\"INDIVIDUAL_USER\",\"document\":\"12345684\",\"email\":\"v@email.com\",\"password\":\"12345\"}";
        var userDTO = ObjectBuilder.createUserRecord();
        when(userService.createUser(userDTO)).thenReturn(userCreatedRecord);
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
        var userDTO = ObjectBuilder.createUserRecord();
        mockMvc.perform(post(path).contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)).andExpect(status().isBadRequest());
    }

}