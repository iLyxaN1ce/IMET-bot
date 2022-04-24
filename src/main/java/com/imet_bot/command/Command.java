package com.imet_bot.command;

import lombok.Getter;
import org.springframework.data.annotation.Id;

import java.util.List;

public class Command {
    @Id
    @Getter
    private String id;
    @Getter
    private String text;
    @Getter
    private String response;
    @Getter
    private List<String> nextCommands;

    public Command() {}

    public Command(String id, String response, List<String> nextCommands) {
        this.id = id;
        this.response = response;
        this.nextCommands = nextCommands;
    }

}
