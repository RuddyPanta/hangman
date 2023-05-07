package com.ruddy.game;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class Dictionary {

    public Map<String, String> getDictionary() throws IOException {
        String pathFile = "src/main/resources/dk.json";
        return unSerialize(Files.readString(Paths.get(pathFile)));
    }

    private Map<String, String> unSerialize(String contentFilepath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(contentFilepath, new TypeReference<>() {
        });
    }
}
