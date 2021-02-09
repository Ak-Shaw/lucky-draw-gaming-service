package com.grofers.luckydraw.services;

import com.grofers.luckydraw.exchanges.GetRaffleTicketRequest;
import com.grofers.luckydraw.exchanges.GetRaffleTicketResponse;
import com.grofers.luckydraw.exchanges.GetWinnersResponse;

public interface LuckydrawService {

  GetWinnersResponse getAllWinners();

  GetWinnersResponse getWinnersFromLastXDays(int rangeInDays);

  GetRaffleTicketResponse getNewRaffleTicket(GetRaffleTicketRequest getRaffleTicketRequest);
}
