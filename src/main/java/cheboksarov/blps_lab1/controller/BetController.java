package cheboksarov.blps_lab1.controller;


import cheboksarov.blps_lab1.dto.DoBetDto;
import cheboksarov.blps_lab1.model.Bet;
import cheboksarov.blps_lab1.service.BetService;
import cheboksarov.blps_lab1.service.SiteUserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/bet")
@AllArgsConstructor
@Slf4j
public class BetController {
    private BetService betService;

    @GetMapping("getMyAllBets")
    public ResponseEntity<?> findAllMyBets(){
        try{
            return new ResponseEntity<>(betService.findAllMyBets(), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("doBet")
    public ResponseEntity<?> doBet(@RequestBody DoBetDto doBetDto){
        try {
            return betService.doBet(doBetDto);
        } catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

}
