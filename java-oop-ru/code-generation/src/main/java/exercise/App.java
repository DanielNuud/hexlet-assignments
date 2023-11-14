package exercise;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {
    public static void save(Path filePath, Car car) {
        try {
            String json = car.serialize();
            Files.writeString(filePath, json);
        } catch (IOException e) {
            throw new RuntimeException("Error saving the object to file", e);
        }
    }

    public static Car extract(Path filePath) {
        try {
            String json = Files.readString(filePath);
            return Car.unserialize(json);
        } catch (IOException e) {
            throw new RuntimeException("Error extracting the object from file", e);
        }
    }
}
// END
