package com.grofers.luckydraw.exchanges;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.grofers.luckydraw.dto.Winner;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetWinnersResponse {
  private List<Winner> winners = new ArrayList<>();
}
