package ua.samoplavskaya.HW_JSON;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JSONtoObject {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            User user = objectMapper.readValue(new File("src/main/java/ua/samoplavskaya/HW_JSON/input.json"), User.class);
            System.out.println("Read from JSON file: " + user);

            User newUser = new User("Oleg", 23, "oleg@gmail.com");
            String jsonString = objectMapper.writeValueAsString(newUser);
            System.out.println(jsonString);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
