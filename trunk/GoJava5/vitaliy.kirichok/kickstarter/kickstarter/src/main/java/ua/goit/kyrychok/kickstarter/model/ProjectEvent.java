package ua.goit.kyrychok.kickstarter.model;

import java.util.Date;

public class ProjectEvent {
    private Date eventDate;
    private String message;

    public ProjectEvent(Date eventDate, String message) {
        this.eventDate = eventDate;
        this.message = message;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public String getMessage() {
        return message;
    }
}
