package com.imet_bot.bot;

import com.imet_bot.TriConsumer;
import com.imet_bot.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

@Component
public class QueryCommandExecutor {
    private final static Map<String, TriConsumer<QueryCommandExecutor, Bot, Update>> queryCommandsMap = new HashMap<>(){{
        put("/b", QueryCommandExecutor::getBachelor);
        put("/m", QueryCommandExecutor::getMaster);
    }};
    private final EmployeeService employeeService;

    @Autowired
    public QueryCommandExecutor(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void execute(Bot bot, Update u) {
        String commandText = u.getMessage().getText();
        queryCommandsMap.get(commandText).accept(this, bot, u);
    }

    public void getBachelor(Bot bot, Update update) {
        Message message = update.getMessage();
        bot.sendMsg(message, employeeService.getEmployeesBachelor());
        System.out.println(message.getText());
    }

    public void getMaster(Bot bot, Update update) {
        Message message = update.getMessage();
        bot.sendMsg(message, employeeService.getEmployeesMaster());
        System.out.println(message.getText());
    }

    public static boolean isQueryCommand(String command) {
        return queryCommandsMap.containsKey(command);
    }
}
