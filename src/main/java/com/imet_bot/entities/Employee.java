package com.imet_bot.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {
    private String address;
    private String contacts;
    private String email;
    private String fullName;
    private String position;

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
