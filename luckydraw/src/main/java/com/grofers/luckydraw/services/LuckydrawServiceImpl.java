package com.grofers.luckydraw.services;

import com.grofers.luckydraw.dto.RaffleTicket;
import com.grofers.luckydraw.dto.Winner;
import com.grofers.luckydraw.exchanges.GetRaffleTicketRequest;
import com.grofers.luckydraw.exchanges.GetRaffleTicketResponse;
import com.grofers.luckydraw.exchanges.GetWinnersResponse;
import com.grofers.luckydraw.repositoryservices.LuckydrawRepositoryService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class LuckydrawServiceImpl implements LuckydrawService {

  @Autowired
  private LuckydrawRepositoryService luckydrawRepositoryService;

  @Override
  public GetWinnersResponse getAllWinners() {

    List<Winner> winners = luckydrawRepositoryService.getAllWinners();

    return new GetWinnersResponse(winners);
  }

  @Override
  public GetWinnersResponse getWinnersFromLastXDays(int rangeInDays) {

    List<Winner> winners = luckydrawRepositoryService.getAllWinners();

    Iterator itr = winners.iterator();

    while (itr.hasNext()) {
      Winner winner = (Winner) itr.next();
      LocalDateTime dateTime = LocalDateTime.parse(winner.getDateTime());
      LocalDateTime dateXDaysAgo = LocalDateTime.now().minusDays(rangeInDays);
      if (!dateTime.isAfter(dateXDaysAgo)) {
        itr.remove();
      }
    }

    return new GetWinnersResponse(winners);
  }

  @Override
  public GetRaffleTicketResponse getNewRaffleTicket(GetRaffleTicketRequest getRaffleTicketRequest) {
    
    RaffleTicket raffleTicket = new RaffleTicket(
        getRaffleTicketRequest.getMobileNum(),
        getRaffleTicketRequest.getName(),
        LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME),
        generateRandomString(10)
    );

    luckydrawRepositoryService.saveNewRaffleTicket(raffleTicket);
    
    return new GetRaffleTicketResponse(raffleTicket);
  }

  public static String generateRandomString(int len) {
    String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghi"
        + "jklmnopqrstuvwxyz!@#$%&";
    Random rnd = new Random();
    StringBuilder sb = new StringBuilder(len);
    for (int i = 0; i < len; i++) {
      sb.append(chars.charAt(rnd.nextInt(chars.length())));
    }
    return sb.toString();
  }


}
