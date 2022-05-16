package com.imet_bot.repos;

import com.imet_bot.entities.ButtonData;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ButtonDataRepository extends MongoRepository<ButtonData, String> {
    Optional<ButtonData> findButtonDataByName(String name);
}
