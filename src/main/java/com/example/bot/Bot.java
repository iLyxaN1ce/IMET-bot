package com.example.bot;

import com.example.employee.Employee;
import com.example.employee.EmployeeController;
import com.example.employee.EmployeeRepository;
import com.example.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
public class Bot extends TelegramLongPollingBot {

    @Autowired
    private EmployeeController employeeController;

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        sendMsg(message, "/b to bachelor, /m to master");
        if (message != null && message.hasText()) {
            switch (message.getText()) {
                case "/b":
                      List<Employee> employeesList = employeeController.getEmployees();
                      for (Employee i : employeesList) {
                          if (i.getContingent().equals("бакалавриат")) {
                              sendMsg(message, i.toString());
                          }
                      }
                    System.out.println(message.getText());
                    break;
                case "/m":
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
    @Override
    public String getBotUsername() {
        return "imet_spbstu_bot";
    } //must be refactored

    @Override
    public String getBotToken() {
        return "5103976032:AAGYp-oLmW96829PHXf55UpbzUIYP5CaoyM";
    }
}
