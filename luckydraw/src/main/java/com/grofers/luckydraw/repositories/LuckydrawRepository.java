package com.grofers.luckydraw.repositories;

import com.grofers.luckydraw.models.WinnerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LuckydrawRepository extends MongoRepository<WinnerEntity, String> {

}
