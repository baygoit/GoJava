package ua.dborisenko.kickstarter;

public class Error {
    private int code;
    private String name;
    private String description;

    public Error(int errorCode, String errorName, String errorDescription) {
        this.code = errorCode;
        this.name = errorName;
        this.description = errorDescription;
    }

    public int getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }
}
