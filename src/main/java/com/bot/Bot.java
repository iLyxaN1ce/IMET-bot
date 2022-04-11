package com.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "imet_spbstu_bot";
    } //must be refactored

    @Override
    public String getBotToken() {
        return "5103976032:AAGYp-oLmW96829PHXf55UpbzUIYP5CaoyM";
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        if (message != null && message.hasText()) {
            switch (message.getText()) {
                case "/contacts":
                    sendMsg(message, "Абоба");
                    System.out.println(message.getText());
                    break;
                default:
                    sendMsg(message, "Нет такой команды");
                    System.out.println(message.getText());
                    break;
            }
        }
    }
    private void sendMsg(Message message, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(message.getChatId().toString());
        sendMessage.setText(text);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
