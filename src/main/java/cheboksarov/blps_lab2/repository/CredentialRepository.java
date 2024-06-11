package cheboksarov.blps_lab2.repository;

import cheboksarov.blps_lab2.model.Credential;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CredentialRepository extends JpaRepository<Credential, Long> {
    Optional<Credential> findByUserName(String userName);
}
