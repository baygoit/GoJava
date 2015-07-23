package ua.goit.kyrychok.kickstarter.model;

import java.util.Date;

public class ProjectEvent {
    private Date eventDate;
    private String message;
    private int id;

    public ProjectEvent(Date eventDate, String message) {
        this.eventDate = eventDate;
        this.message = message;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public String getMessage() {
        return message;
    }
}
