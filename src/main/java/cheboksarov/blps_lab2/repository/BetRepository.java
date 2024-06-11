package cheboksarov.blps_lab2.repository;

import cheboksarov.blps_lab2.model.Bet;
import cheboksarov.blps_lab2.model.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BetRepository extends JpaRepository<Bet, Long> {
    List<Bet> findAllBySiteUser(SiteUser siteUser);
}
