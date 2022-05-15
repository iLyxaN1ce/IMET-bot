package com.imet_bot.entities;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.Optional;

public class BotButton {
    private String buttonLabel;
    private Optional<BotKeyboard> nextKeyboard;
    private Optional<SendMessage> responseMessage;
}
