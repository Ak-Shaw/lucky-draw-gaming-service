package com.grofers.luckydraw.models;

import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "winners")
@NoArgsConstructor
public class WinnerEntity {
    
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

  @NotNull
  private String prize;
}
