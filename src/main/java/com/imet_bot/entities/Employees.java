package com.imet_bot.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Employees {
    @JsonProperty("name")
    private String name;
    @JsonDeserialize(using = EmployeeListDeserialize.class)
    private List<Employee> employees;

    public Employees() {}

    public Employees(String name, List<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(name)
                .append("\n\n");
        for (Employee e: employees) {
            stringBuilder
                    .append(e)
                    .append("\n");
        }
        return stringBuilder.toString();
    }
}
