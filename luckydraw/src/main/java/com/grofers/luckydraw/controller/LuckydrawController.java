package com.grofers.luckydraw.controller;

import com.grofers.luckydraw.exchanges.GetRaffleTicketRequest;
import com.grofers.luckydraw.exchanges.GetRaffleTicketResponse;
import com.grofers.luckydraw.exchanges.GetWinnersResponse;
import com.grofers.luckydraw.services.LuckydrawService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
public class LuckydrawController {
 
  public static final String LUCKYDRAW_API_ENDPOINT = "/luckydraw";
  public static final String WINNERS_API = "/winners";
  public static final String RAFFLE_TICKET_API = "/newRaffleTicket";

  @Autowired
  private LuckydrawService luckydrawService;



  @GetMapping(LUCKYDRAW_API_ENDPOINT + WINNERS_API)
  public ResponseEntity<GetWinnersResponse> getWinners(
      @RequestParam(required = false) String rangeInDays) {

    GetWinnersResponse getWinnersResponse;

    if (rangeInDays != null) {

      log.info("getWinners called with 'rangeInDays' param");

      getWinnersResponse = 
          luckydrawService.getWinnersFromLastXDays(Integer.parseInt(rangeInDays));

      log.info("getWinners returned {}", getWinnersResponse);

      return ResponseEntity.ok().body(getWinnersResponse);  
    }

    log.info("getWinners called");

    getWinnersResponse = luckydrawService.getAllWinners();

    log.info("getWinners returned {}", getWinnersResponse);

    return ResponseEntity.ok().body(getWinnersResponse);
  }

  @PostMapping(LUCKYDRAW_API_ENDPOINT + RAFFLE_TICKET_API)
  public ResponseEntity<GetRaffleTicketResponse> getNewRaffleTicket(
      @RequestBody GetRaffleTicketRequest getRaffleTicketRequest) {

    log.info("getNewRaffleTicket called");

    GetRaffleTicketResponse getRaffleTicketResponse = 
        luckydrawService.getNewRaffleTicket(getRaffleTicketRequest);
    
    log.info("getNewRaffleTIcket returned {}", getRaffleTicketResponse);

    return ResponseEntity.ok().body(getRaffleTicketResponse);

  }

}
