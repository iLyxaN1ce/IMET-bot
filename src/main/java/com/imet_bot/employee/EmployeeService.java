package com.imet_bot.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployeesBachelor() {
        return employeeRepository.employeeByContingentBachelor();
    }

    public List<Employee> getEmployeesMaster() {
        return employeeRepository.employeeByContingentMaster();
    }
}
