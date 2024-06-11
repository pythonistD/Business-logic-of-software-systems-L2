package cheboksarov.blps_lab2.service;

import cheboksarov.blps_lab2.dto.DoBetDto;
import cheboksarov.blps_lab2.model.Bet;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BetService {
    List<Bet> findAllMyBets() throws Exception;

    ResponseEntity<?> doBet(DoBetDto doBetDto) throws Exception;
}
