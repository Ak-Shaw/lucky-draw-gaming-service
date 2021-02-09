package com.grofers.luckydraw.repositoryservices;

import com.grofers.luckydraw.dto.RaffleTicket;
import com.grofers.luckydraw.dto.Winner;
import java.util.List;

public interface LuckydrawRepositoryService {

  List<Winner> getAllWinners();
  
  void saveNewRaffleTicket(RaffleTicket raffleTicket);
}
