package com.imet_bot.bot;

import com.imet_bot.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component
public class ExecutableCommandExecutor {
    private final static Map<String, Method> executableCommandsMap = new HashMap<>();
    private final EmployeeService employeeService;

    @Autowired
    public ExecutableCommandExecutor(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public static boolean isExecutableCommand(String command) {
        return executableCommandsMap.containsKey(command);
    }
}
