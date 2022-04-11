package com.example.employee;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    public List<Employee> getEmployees() {
        return List.of(
                new Employee(
                        "Bachelaury" ,
                        "Director",
                        "Alex Ivanov",
                        "Polytech",
                        "89223335222",
                        "temp@edu.spbstu.ru")
        );
    }
}
