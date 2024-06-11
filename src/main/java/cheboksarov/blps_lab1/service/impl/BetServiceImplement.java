package cheboksarov.blps_lab1.service.impl;

import cheboksarov.blps_lab1.dto.DoBetDto;
import cheboksarov.blps_lab1.model.*;
import cheboksarov.blps_lab1.repository.BetRepository;
import cheboksarov.blps_lab1.repository.SiteUserRepository;
import cheboksarov.blps_lab1.service.*;
import cheboksarov.blps_lab1.utils.BetUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
@AllArgsConstructor
public class BetServiceImplement implements BetService {
    private BetRepository betRepository;
    private SiteUserService userService;
    private MatchService matchService;
    private CredentialService credentialService;
    @Override
    public List<Bet> findAllMyBets() throws Exception {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails;
        if (auth.isAuthenticated()){
            userDetails = (UserDetails) auth.getPrincipal();
            log.info("User details: " + userDetails);
        } else {
            throw new UsernameNotFoundException("Wrong userId provided!");
        }
        Credential credential = credentialService.findByUserName(userDetails.getUsername());
        SiteUser siteUser = userService.findByCredentialId(credential);
        //SiteUser user = userService.findUserById(userId);
        return betRepository.findAllBySiteUser(siteUser);
    }

    @Override
    public ResponseEntity<?> doBet(DoBetDto doBetDto) throws Exception {
        if((doBetDto.getMatchId() == null) | (doBetDto.getBet() == null)
            | (doBetDto.getEvent() == null)
                )
        {
            throw new Exception("Bad request data");
        }
        Match match = matchService.findById(doBetDto.getMatchId());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        Credential credential = credentialService.findByUserName(name);
        SiteUser user = userService.findByCredentialId(credential);
        if (user.getBalance() < doBetDto.getBet()){
            throw new Exception("Not enought money in your balance ((");
        }
        user.setBalance(user.getBalance()- doBetDto.getBet());
        Bet.BetEvent event = BetUtils.validateEventString(doBetDto.getEvent());
        Coefficient coefficient = match.getCoefficient();
        Bet bet = Bet.builder().siteUser(user).betEvent(event)
                .coefficient(coefficient).build();
        betRepository.save(bet);
        return new ResponseEntity<>("Your bet is accepted!", HttpStatus.OK);

    }
}
