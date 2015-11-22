package ua.com.goit.gojava7.kickstarter.dao;

public enum DataType {

    MEMORY("m"), FILE("f"), POSTGRE("p");

    private final String startupKey;

    DataType(String startupKey) {
        this.startupKey = startupKey;
    }

    public String getStartupKey() {
        return startupKey;
    }
    
    public static DataType getByStartupKey(String startupKey) {
        for (DataType element : DataType.values()) {
            if (element.getStartupKey().equals(startupKey)) {
                return element;
            }
        }
        return MEMORY;
    }
}
