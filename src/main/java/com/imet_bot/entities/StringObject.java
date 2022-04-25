package com.imet_bot.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StringObject {
    @Getter
    private String value;

    public StringObject() {}

    @Override
    public String toString() {
        return value;
    }
}
