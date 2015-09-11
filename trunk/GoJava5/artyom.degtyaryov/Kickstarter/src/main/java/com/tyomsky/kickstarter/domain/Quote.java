package com.tyomsky.kickstarter.domain;

import javax.persistence.*;

@Entity
@Table(name = "quotes")
public class Quote {

    @Id
    @GeneratedValue
    private int id;

    private String presentation;

    public Quote() {
    }

    public Quote(int id, String presentation) {
        this.id = id;
        this.presentation = presentation;

    }

    public Quote(String presentation) {
        this.id = id;
        this.presentation = presentation;

    }

    public int getId() {
        return id;
    }

    public String getPresentation() {
        return presentation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Quote quote = (Quote) o;

        return !(presentation != null ? !presentation.equals(quote.presentation) : quote.presentation != null);
    }

    @Override
    public int hashCode() {
        return presentation != null ? presentation.hashCode() : 0;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

}
