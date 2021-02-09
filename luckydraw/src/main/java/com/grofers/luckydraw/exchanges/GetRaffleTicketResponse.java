package com.grofers.luckydraw.exchanges;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.grofers.luckydraw.dto.RaffleTicket;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetRaffleTicketResponse {
  private RaffleTicket raffleTicket;
}
