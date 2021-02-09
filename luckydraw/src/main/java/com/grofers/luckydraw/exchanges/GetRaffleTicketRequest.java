package com.grofers.luckydraw.exchanges;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetRaffleTicketRequest {

  private long mobileNum;

  private String name;
}
