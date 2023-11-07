package br.com.picpay.pagamentosimplificado.infrastructure.user.repository;

import br.com.picpay.pagamentosimplificado.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    public boolean existsByDocument(String document);


    public boolean existsByEmail(String email);
}
