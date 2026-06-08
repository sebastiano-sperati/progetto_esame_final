package it.unicam.cs.mpgc.rpg129546.Persistence;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class SaveManager {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static void save(SaveData data) throws IOException {
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File("save.json"), data);
    }

    public static SaveData load() throws IOException {
        return mapper.readValue(new File("save.json"), SaveData.class);
    }
}