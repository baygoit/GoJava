package org.kudryavtsev.kickstarter.data;

public class Project {
    private String name;
    private String description;
    private int funded;
    private int pledged;
    private int daysToGo;
    private String longDescription;
    private String history;
    private String linkToVideo;
    private String faq;

    public Project(String name, String description, int funded, int pledged,
            int daysToGo) {
        this();
        this.name = name;
        this.description = description;
        this.funded = funded;
        this.pledged = pledged;
        this.daysToGo = daysToGo;
    }

    public Project() {
        longDescription = "Just long description";
        history = "History of the project";
        linkToVideo = "Link to video with demo";
        faq = "Frequently Asked Questions";
    }

    @Override
    public String toString() {
        return name + "; " + description + "; funded: " + funded + "; pledged: " + pledged
                + "; days to go: " + daysToGo;
    }

    public String toStringFull() {
        return toString() + "\nFull description: " + longDescription + "\nHistory: " + history
                + "\nVideo: " + linkToVideo + "\nFAQ: " + faq;
    }
}
