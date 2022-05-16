package com.imet_bot.repos;

import com.imet_bot.entities.KeyboardButton;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface KeyboardButtonRepository extends MongoRepository<KeyboardButton, String> {
    Optional<KeyboardButton> getKeyboardButtonByName(String name);
}
