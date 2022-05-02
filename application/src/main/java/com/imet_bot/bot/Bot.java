package com.imet_bot.bot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.imet_bot.command.CommandRepository;
import com.imet_bot.entities.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class Bot extends TelegramLongPollingBot {

    //application.yml
    @Value("${bot.name}")
    private String botUsername;

    @Value("${bot.token}")
    private String botToken;

    private final CommandRepository commandRepository;

    @Autowired
    public Bot(CommandRepository commandRepository) {
        this.commandRepository = commandRepository;
    }

    @Override
    public void onUpdateReceived(Update update) {
    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {
        for (Update u: updates) {
            Message message = u.getMessage();
            Optional<Command> command = commandRepository.getCommandByText(message.getText());
            if (command.isEmpty()) {
                sendMsg(message, Collections.singletonList("Нет такой команды"));
            } else {
                String response = null;
                try {
                    response = command.get().unmarshallResponse();
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                sendMsg(message, Collections.singletonList(response));
            }
        }
    }

    public void sendMsg(Message message, List<?> text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId().toString());
        try {
            for (Object i : text) {
                sendMessage.setText(String.valueOf(i));
                execute(sendMessage);
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return botUsername; 
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

}
