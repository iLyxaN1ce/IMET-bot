package com.imet_bot.bot;

import com.imet_bot.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;


@Component
public class Bot extends TelegramLongPollingBot {

    //application.yaml
    @Value("${bot.name}")
    private String botUsername;

    @Value("${bot.token}")
    private String botToken;

    private final EmployeeService employeeService;

    public Bot(TelegramBotsApi telegramBotsApi, EmployeeService employeeService) throws TelegramApiException {
        this.employeeService = employeeService;
        telegramBotsApi.registerBot(this);
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        sendMsg(message, Collections.singletonList("/b to bachelor, /m to master"));
        if (message != null && message.hasText()) {
            switch (message.getText()) {
                case "/b":
                    sendMsg(message, employeeService.getEmployeesBachelor());
                    System.out.println(message.getText());
                    break;
                case "/m":
                    sendMsg(message, employeeService.getEmployeesMaster());
                    System.out.println(message.getText());
                    break;
                default:
                    sendMsg(message, Collections.singletonList("Нет такой команды"));
                    System.out.println(message.getText());
                    break;
            }
        }
    }
    private void sendMsg(Message message, List<?> text) {
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
