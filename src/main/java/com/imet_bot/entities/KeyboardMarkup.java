package com.imet_bot.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@Document(collection = "markups")
@JsonIgnoreProperties(ignoreUnknown = true)
public class KeyboardMarkup {
    private String name;
    private String text;
    private List<String> buttons;
}
