package com.imet_bot.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

@Data
@Document(collection = "stages")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Stage {
    private String command;
    private String stageName;
    private String text;
    private Map<String, String> commandStageMap;

    public Stage() {}
}
