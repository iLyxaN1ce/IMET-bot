package com.imet_bot.entities;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.util.StdConverter;
import lombok.SneakyThrows;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeListDeserialize extends StdDeserializer<List<Employee>> {
    public EmployeeListDeserialize() {
        this(null);
    }

    protected EmployeeListDeserialize(Class<?> vc) {
        super(vc);
    }

    @Override
    public List<Employee> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException{
        List<Employee> employeeList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        ObjectCodec codec = jsonParser.getCodec();
        Employee[] employees = new Employee[0];
        try {
            employees = codec.readValue(jsonParser, Employee[].class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return Arrays.asList(employees);
    }
}
