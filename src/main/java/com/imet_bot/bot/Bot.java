package com.imet_bot.bot;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.imet_bot.entities.ButtonData;
import com.imet_bot.entities.KeyboardButton;
import com.imet_bot.entities.KeyboardMarkup;
import com.imet_bot.entities.Staff;
import com.imet_bot.repos.ButtonDataRepository;
import com.imet_bot.repos.KeyboardButtonRepository;
import com.imet_bot.repos.KeyboardMarkupRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

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

    private final KeyboardMarkupRepository keyboardMarkupRepository;
    private final KeyboardButtonRepository keyboardButtonRepository;
    private final ButtonDataRepository buttonDataRepository;

    @Autowired
    public Bot(KeyboardMarkupRepository keyboardMarkupRepository, KeyboardButtonRepository keyboardButtonRepository, ButtonDataRepository buttonDataRepository) {
        this.keyboardMarkupRepository = keyboardMarkupRepository;
        this.keyboardButtonRepository = keyboardButtonRepository;
        this.buttonDataRepository = buttonDataRepository;
    }

    @Override
    public void onUpdateReceived(Update update) {
    }

    @SneakyThrows
    @Override
    public void onUpdatesReceived(List<Update> updates) {
        for (Update u: updates) {

            if (u.getMessage() != null) {
                processMessage(u.getMessage());
            }

            if (u.getCallbackQuery() != null) {
                CallbackQuery query = u.getCallbackQuery();
                processCallbackQuery(query);
            }

        }
    }

    private InlineKeyboardMarkup buildKeyboard(KeyboardMarkup dbKeyboardMarkup) {
        InlineKeyboardMarkup keyboard = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
        for (String keyboardButton : dbKeyboardMarkup.getButtons()) {
            KeyboardButton dbButton = keyboardButtonRepository.getKeyboardButtonByName(keyboardButton).get();
            InlineKeyboardButton button = new InlineKeyboardButton(dbButton.getLabel());
            button.setCallbackData(dbButton.getData());
            buttons.add(Collections.singletonList(button));
        }
        keyboard.setKeyboard(buttons);

        return keyboard;
    }

    private void processMessage(Message message) {
        SendMessage reply = new SendMessage();

        if (message.getText().equals("/start")) {
            reply = buildKeyboardRequest(message,"startKeyboard");
        }

        try {
            execute(reply);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private SendMessage buildKeyboardRequest(Message message, String keyboardName) {
        KeyboardMarkup dbKeyboardMarkup = keyboardMarkupRepository.getKeyboardMarkupByName(keyboardName).get();
        InlineKeyboardMarkup keyboard = buildKeyboard(dbKeyboardMarkup);

        SendMessage reply = new SendMessage();
        reply.setChatId(String.valueOf(message.getChatId()));
        reply.setText(dbKeyboardMarkup.getText());
        reply.setReplyMarkup(keyboard);

        return reply;
    }

    private void processCallbackQuery(CallbackQuery query) throws JsonProcessingException {
        AnswerCallbackQuery answer = new AnswerCallbackQuery();
        answer.setCallbackQueryId(query.getId());
        SendMessage reply = new SendMessage();
        reply.setChatId(String.valueOf(query.getMessage().getChatId()));

        String buttonDataName = query.getData();
        ButtonData buttonData = buttonDataRepository.findButtonDataByName(buttonDataName).get();
        if (buttonData.getResponseType().equals("Keyboard")) {
            String keyboardName = buttonData.getResponseBody();
            KeyboardMarkup dbKeyboardMarkup = keyboardMarkupRepository.getKeyboardMarkupByName(keyboardName).get();
            InlineKeyboardMarkup keyboard = buildKeyboard(dbKeyboardMarkup);
            reply.setText(dbKeyboardMarkup.getText());
            reply.setReplyMarkup(keyboard);
        } else if (buttonData.getResponseType().equals("Staff")) {
            ObjectMapper objectMapper = new ObjectMapper();
            Staff staff = objectMapper.readValue(buttonData.getResponseBody(), Staff.class);
            reply.setText(staff.toString());
        } else if (buttonData.getResponseType().equals("String")) {
            reply.setText(buttonData.getResponseBody());
        }

        try {
            execute(answer);
            execute(reply);
        } catch (TelegramApiException e) {
            e.printStackTrace();
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
