package com.imet_bot.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.util.JSON;
import lombok.Getter;
import org.bson.json.JsonObject;
import org.bson.json.JsonReader;
import org.json.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.StringReader;
import java.util.List;

@Document(collection = "commands")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Command {
    @Getter
    private String text;
    @Getter
    private String responseType;
    @Getter
    private String responseBody;
    @Getter
    private List<String> nextCommands;

    public Command() {}

    public Command(String text, String responseType, String responseBody, List<String> nextCommands) {
        this.text = text;
        this.responseType = responseType;
        this.responseBody = responseBody;
        this.nextCommands = nextCommands;
    }

    public String unmarshallResponse() throws JsonProcessingException, ClassNotFoundException {
        ObjectMapper mapper = new ObjectMapper();
        Class<?> responseClass = Class.forName(responseType);

        System.out.println(responseBody);
        Object unmarshalledObject = mapper.readValue(responseBody, responseClass);
        return unmarshalledObject.toString();
    }

}
