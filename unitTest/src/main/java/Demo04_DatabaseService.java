package Junit;

import java.util.HashMap;
import java.util.Map;

public class Demo04_DatabaseService {

    private Map<String, String> database;

    // Connect to database
    public void connect() {
        database = new HashMap<>();
        System.out.println("Database Connected");
    }

    // Disconnect from database
    public void disconnect() {
        database.clear();
        System.out.println("Database Disconnected");
    }

    // Insert data
    public void insert(String key, String value) {
        database.put(key, value);
    }

    // Fetch data
    public String fetch(String key) {
        return database.get(key);
    }
}