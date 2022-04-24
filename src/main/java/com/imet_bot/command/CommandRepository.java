package com.imet_bot.command;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CommandRepository extends MongoRepository<Command, String> {
    Optional<Command> getCommandByText(String text);
}
