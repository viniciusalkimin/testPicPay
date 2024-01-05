package br.com.picpay.pagamentosimplificado.domain.user;

import br.com.picpay.pagamentosimplificado.domain.user.dto.UserRecord;
import br.com.picpay.pagamentosimplificado.domain.user.enums.UserType;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@ToString
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String completeName;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    private String document;

    private String email;

    @Setter
    private String password;

    public User(UserRecord userRecord) {
        this.completeName = userRecord.completeName();
        this.userType = userRecord.userType();
        this.document = userRecord.document();
        this.email = userRecord.email();
        this.password = userRecord.password();
    }
}
