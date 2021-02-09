package com.grofers.luckydraw.models;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "raffleTickets")
@NoArgsConstructor
@AllArgsConstructor
public class RaffleTicketEntity {

  @Id
  private String id;

  @NotNull
  private long mobileNum;

  @NotNull
  private String name;

  @NotNull
  private String dateTime;

  @NotNull
  private String raffleTicketCode;
}
