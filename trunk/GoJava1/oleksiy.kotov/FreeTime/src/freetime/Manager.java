package freetime;

import java.util.HashSet;
import java.util.Set;

public class Manager {
    
    private int id;
    private String name;
    private Set<Project> projects;
    
    public Manager() {
        this.name = "N/A";
        this.projects = new HashSet<Project>();
    }
    
    public void addProject(Project project) {
        this.projects.add(project);
    }

    public void removeProject(Project project) {
        this.projects.remove(project);
    }
    
    
}
