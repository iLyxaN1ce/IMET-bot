package com.imet_bot.repos;

import com.imet_bot.entities.KeyboardMarkup;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface KeyboardMarkupRepository extends MongoRepository<KeyboardMarkup, String> {
    Optional<KeyboardMarkup> getKeyboardMarkupByName(String name);
}
