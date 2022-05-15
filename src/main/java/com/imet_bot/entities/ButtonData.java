package com.imet_bot.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "datas")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ButtonData {
    private String name;
    private String responseType;
    private String responseBody;
}
