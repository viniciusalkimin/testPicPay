package br.com.picpay.pagamentosimplificado.infrastructure.account.repository;

import br.com.picpay.pagamentosimplificado.domain.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {
}
