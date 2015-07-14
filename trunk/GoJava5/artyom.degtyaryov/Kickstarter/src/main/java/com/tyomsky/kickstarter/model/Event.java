package com.tyomsky.kickstarter.model;

import java.util.Date;

public class Event {

    Date date;

    String description;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
