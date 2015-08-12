package ua.com.goit.kyrychok.model;

import java.util.Map;

public class MainModel {
    public String welcomeMessage;
    public Map<Integer, String> categories;

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public Map<Integer, String> getCategories() {
        return categories;
    }
}
