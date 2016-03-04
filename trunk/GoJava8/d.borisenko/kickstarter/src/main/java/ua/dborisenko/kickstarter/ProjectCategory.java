package ua.dborisenko.kickstarter;

public class ProjectCategory {
    private int id;
    private String name;

    public ProjectCategory() {
        this.name = "";
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
