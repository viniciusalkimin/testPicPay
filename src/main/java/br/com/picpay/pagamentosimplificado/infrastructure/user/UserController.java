package br.com.picpay.pagamentosimplificado.infrastructure.user;

import br.com.picpay.pagamentosimplificado.application.user.UserService;
import br.com.picpay.pagamentosimplificado.domain.user.dto.UserCreatedRecord;
import br.com.picpay.pagamentosimplificado.domain.user.dto.UserRecord;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("${application.context-path}/users")
public class UserController {

    private UserService userService;

    @GetMapping
    public String helloWorld() {
        return "Hello World!";
    }

    @PostMapping
    public ResponseEntity<UserCreatedRecord> createUser(@RequestBody @Valid UserRecord userRecord) {
        return ResponseEntity.ok().body(userService.createUser(userRecord));
    }
}
