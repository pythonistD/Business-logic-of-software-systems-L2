package cheboksarov.blps_lab1.service;

import cheboksarov.blps_lab1.model.Match;

import java.util.List;

public interface MatchService {
    List<Match> findAllMatch();
    Match saveMatch(Match match);
    Match findById(Long id);
    Match updateMatch(Match match);
    void deleteMatch(Long match_id);
}
