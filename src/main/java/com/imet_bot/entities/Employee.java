package com.imet_bot.entities;

import lombok.Getter;

public class Employee {
    @Getter
    private String address;
    @Getter
    private String contacts;
    @Getter
    private String email;
    @Getter
    private String fullName;
    @Getter
    private String position;

    public Employee() {}

    public Employee(String address, String contacts, String email, String fullName, String position) {
        this.address = address;
        this.contacts = contacts;
        this.email = email;
        this.fullName = fullName;
        this.position = position;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("Полное имя: ")
                .append(fullName)
                .append("\n")
                .append("Должность: ")
                .append(position)
                .append("\n")
                .append("Телефон: ")
                .append(contacts)
                .append("\n")
                .append("Электронная почта: ")
                .append(email)
                .append("\n");

        return stringBuilder.toString();
    }
}
