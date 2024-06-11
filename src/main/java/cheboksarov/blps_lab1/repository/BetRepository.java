package cheboksarov.blps_lab1.repository;

import cheboksarov.blps_lab1.model.Bet;
import cheboksarov.blps_lab1.model.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BetRepository extends JpaRepository<Bet, Long> {
    List<Bet> findAllBySiteUser(SiteUser siteUser);
}
