package com.imet_bot.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BotUser {
    private Long chatId;
    private String currentStageName;

    public BotUser(Long chatId, String currentStageName) {
        this.chatId = chatId;
        this.currentStageName = currentStageName;
    }
}
