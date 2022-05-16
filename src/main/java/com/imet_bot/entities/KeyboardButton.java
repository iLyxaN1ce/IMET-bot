package com.imet_bot.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@Document(collection = "buttons")
@JsonIgnoreProperties(ignoreUnknown = true)
public class KeyboardButton {
    private String name;
    private String label;
    private String data;
}
