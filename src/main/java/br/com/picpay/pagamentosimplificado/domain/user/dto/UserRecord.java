package br.com.picpay.pagamentosimplificado.domain.user.dto;

import br.com.picpay.pagamentosimplificado.domain.user.UserType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record UserRecord(UUID id, @NotBlank String completeName, @NotNull UserType userType, @NotBlank String document, @NotBlank String email, @NotBlank String password) {
}
