package cheboksarov.blps_lab1.service;

import cheboksarov.blps_lab1.dto.DoBetDto;
import cheboksarov.blps_lab1.model.Bet;
import cheboksarov.blps_lab1.model.SiteUser;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BetService {
    List<Bet> findAllMyBets() throws Exception;

    ResponseEntity<?> doBet(DoBetDto doBetDto) throws Exception;
}
