package exercise;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        KeyValueStorage storage = new InMemoryKV(Map.of("key", "10"));
        storage.get("key", "default");
        storage.get("unknown", "default");

        storage.set("key2", "15");
        storage.get("key2", "default");
        System.out.println(storage.toMap());
    }
}
