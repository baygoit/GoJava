package ua.com.goit.gojava7.salivon.stores;

import java.util.ArrayList;
import java.util.List;
import ua.com.goit.gojava7.salivon.beans.Project;

public class StoreProjects {

    private static List<Project> projects = new ArrayList<>();

    static {
        projects.add(new Project("Circle", 10, 1, 1));
        projects.add(new Project("Elips", 17, 1, 2));
        projects.add(new Project("Line", 4, 1, 3));
        projects.add(new Project("The Man with Ten Thousand Eyes", 241, 2, 4));
        projects.add(new Project("SkyHeart Book I: The Star Seed", 258, 2, 5));
        projects.add(new Project("Deeds Not Words", 541, 2, 6));
        projects.add(new Project("Failsafe", 1025, 3, 7));
        projects.add(new Project("Centauri Saga", 3527, 3, 8));

    }

    public static List<Project> getProjects() {
        return projects;
    }

}
