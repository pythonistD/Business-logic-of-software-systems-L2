package cheboksarov.blps_lab1.repository;

import cheboksarov.blps_lab1.model.Coefficient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CoefficientRepository extends JpaRepository<Coefficient, Long> {
}
