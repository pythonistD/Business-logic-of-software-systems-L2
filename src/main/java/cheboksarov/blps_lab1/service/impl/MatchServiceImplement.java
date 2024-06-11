package cheboksarov.blps_lab1.service.impl;

import cheboksarov.blps_lab1.exceptions.MatchNotFoundException;
import cheboksarov.blps_lab1.model.Coefficient;
import cheboksarov.blps_lab1.model.Match;
import cheboksarov.blps_lab1.repository.MatchRepository;
import cheboksarov.blps_lab1.service.CoefficientService;
import cheboksarov.blps_lab1.service.MatchService;
import cheboksarov.blps_lab1.service.StatisticsService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Primary
public class MatchServiceImplement implements MatchService {

    private final MatchRepository matchRepository;
    private final CoefficientService coefficientService;
    private final StatisticsService statisticsService;

    @Override
    public List<Match> findAllMatch() {
        return matchRepository.findAll();
    }

    @Override
    public Match saveMatch(Match match) {
        if (match.getCoefficient() == null){
            match.setCoefficient(coefficientService.createDefaultCoefficient());
        }
        if((match.getGuestsStat() == null) & (match.getHostsStat() == null)){
            match.setGuestsStat(statisticsService.createDefaultStatistics());
            match.setHostsStat(statisticsService.createDefaultStatistics());
        }
        return matchRepository.save(match);
    }

    @Override
    public Match findById(Long id) throws MatchNotFoundException{
        Optional<Match> matchOp = matchRepository.findById(id);
        if (matchOp.isPresent()){
            return matchOp.get();
        }
        throw new MatchNotFoundException(String.format("No Match with this id: %d", id));
    }

    @Override
    public Match updateMatch(Match match) {
        return matchRepository.save(match);
    }

    @Override
    public void deleteMatch(Long match_id) {
        matchRepository.deleteById(match_id);
    }

}
