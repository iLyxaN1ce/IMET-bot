package com.imet_bot.bot;

import com.imet_bot.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Component
public class Bot extends TelegramLongPollingBot {

    //application.yml
    @Value("${bot.name}")
    private String botUsername;

    @Value("${bot.token}")
    private String botToken;

    private final ExecutableCommandExecutor executableCommandExecutor;
    private final QueryCommandExecutor queryCommandExecutor;

    @Autowired
    public Bot(ExecutableCommandExecutor executableCommandExecutor,
               QueryCommandExecutor queryCommandExecutor) {
        this.executableCommandExecutor = executableCommandExecutor;
        this.queryCommandExecutor = queryCommandExecutor;
    }

    private List<Update> replyAndFilterNonCommands(List<Update> updates) {
        List<Update> commandUpdates = new ArrayList<>();

        for (Update u: updates) {
            String messageText = u.getMessage().getText();
            boolean isCommand = ExecutableCommandExecutor.isExecutableCommand(messageText) ||
                    QueryCommandExecutor.isQueryCommand(messageText);

            if (!isCommand) {
                sendMsg(u.getMessage(), Collections.singletonList("Нет такой команды"));
            } else {
                commandUpdates.add(u);
            }
        }

        return commandUpdates;
    }

    private List<Update> replyAndFilterExecutableCommands(List<Update> updates) {
        return updates;
    }

    private void executeQueryCommands(List<Update> updates) {
        for (Update u: updates) {
            queryCommandExecutor.execute(this, u);
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {
        List<Update> commandUpdates = replyAndFilterNonCommands(updates);
        List<Update> queryUpdates = replyAndFilterExecutableCommands(commandUpdates);
        executeQueryCommands(queryUpdates);
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
