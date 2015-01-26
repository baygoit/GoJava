package org.kudryavtsev.kickstarter;

public class Project {
    private String category;
    private String name;
    private String description;
    private int funded;
    private int pledged;
    private int daysToGo;

    public Project(String category, String name, String description,
            int funded, int pledged, int daysToGo) {
        this.category = category;
        this.name = name;
        this.description = description;
        this.funded = funded;
        this.pledged = pledged;
        this.daysToGo = daysToGo;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return name + "; " + description + "; funded: " + funded
                + "; pledged: " + pledged + "; days to go: " + daysToGo;
    }
}
