package com.imet_bot.repos;

import com.imet_bot.entities.BotUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BotUserRepository extends MongoRepository<BotUser, String> {
    public BotUser findBotUserByChatId(String chatId);
}
