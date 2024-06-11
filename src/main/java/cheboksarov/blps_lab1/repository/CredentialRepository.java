package cheboksarov.blps_lab1.repository;

import cheboksarov.blps_lab1.model.Credential;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CredentialRepository extends JpaRepository<Credential, Long> {
    Optional<Credential> findByUserName(String userName);
}
