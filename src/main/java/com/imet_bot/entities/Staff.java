package com.imet_bot.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@Document(collection = "staffs")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Staff {
    private List<Employee> employees;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        employees
                .stream()
                .forEach(e -> stringBuilder.append(e.toString() + '\n'));

        return stringBuilder.toString();
    }
}
