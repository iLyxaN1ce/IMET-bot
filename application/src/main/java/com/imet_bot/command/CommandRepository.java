package com.imet_bot.command;

import com.imet_bot.entities.Command;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CommandRepository extends MongoRepository<Command, String> {
    Optional<Command> getCommandByText(String text);
}
