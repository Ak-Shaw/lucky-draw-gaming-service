package com.grofers.luckydraw.repositoryservices;

import com.grofers.luckydraw.dto.RaffleTicket;
import com.grofers.luckydraw.dto.Winner;
import com.grofers.luckydraw.exceptions.RaffleTicketForTheDayExistsException;
import com.grofers.luckydraw.models.RaffleTicketEntity;
import com.grofers.luckydraw.models.WinnerEntity;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.inject.Provider;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class LuckydrawRespositoryServiceImpl implements LuckydrawRepositoryService {

  @Autowired
  private MongoTemplate mongoTemplate;

  @Autowired
  private Provider<ModelMapper> modelMapperProvider;

  @Override
  public List<Winner> getAllWinners() {
    List<Winner> winners = new ArrayList<>();

    List<WinnerEntity> winnerEntities = mongoTemplate.findAll(WinnerEntity.class);

    ModelMapper modelMapper = new ModelMapper();

    for (WinnerEntity winnerEntity : winnerEntities) {

      Winner winner = modelMapper.map(winnerEntity, Winner.class);
      winners.add(winner);
    }

    return winners;
  }

  @Override
  public void saveNewRaffleTicket(RaffleTicket raffleTicket) {
    
    Query query = new Query();
    query.addCriteria(Criteria.where("name").regex(raffleTicket.getName()));
    List<RaffleTicketEntity> raffleTicketEntityQuery = 
        mongoTemplate.find(query, RaffleTicketEntity.class);
    
    if (raffleTicketEntityQuery.size() > 0) {
      for (RaffleTicketEntity raffleTicketEntity : raffleTicketEntityQuery) {
        LocalDateTime timeInRaffleTicket = LocalDateTime.parse(raffleTicketEntity.getDateTime());
        LocalDateTime currentTime = LocalDateTime.now();
        int timeInRaffleTicketDayOfYear = timeInRaffleTicket.getDayOfYear();
        int currentDateDayOfYear = currentTime.getDayOfYear();
        if (timeInRaffleTicketDayOfYear == currentDateDayOfYear) {
          throw new RaffleTicketForTheDayExistsException(
              raffleTicket.getMobileNum(), raffleTicket.getName());
        }
      }
    }

    RaffleTicketEntity raffleTicketEntity = new RaffleTicketEntity(
        Integer.toString(new Random().nextInt(999)),
        raffleTicket.getMobileNum(),
        raffleTicket.getName(),
        raffleTicket.getDateTime(),
        raffleTicket.getRaffleTicketCode()
    );
    mongoTemplate.save(raffleTicketEntity);
  }
    
}
