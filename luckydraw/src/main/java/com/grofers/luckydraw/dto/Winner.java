package com.grofers.luckydraw.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Winner {

  private long mobileNum;

  private String name;

  private String dateTime;

  private String raffleTicketCode;

  private String prize;
}
