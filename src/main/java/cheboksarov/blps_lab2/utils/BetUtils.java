package cheboksarov.blps_lab2.utils;

import cheboksarov.blps_lab2.model.Bet;


public class BetUtils {
    public static Bet.BetEvent  validateEventString(String str) throws Exception {
        return switch (str) {
            case "hostsWin" -> Bet.BetEvent.HostsWins;
            case "guestsWin" -> Bet.BetEvent.GuestsWins;
            case "totalOne" -> Bet.BetEvent.TotalOne;
            case "totalTwo" -> Bet.BetEvent.TotalTwo;
            case "totalThree" -> Bet.BetEvent.TotalThree;
            default -> throw new Exception("No such event!");
        };
    }
}
