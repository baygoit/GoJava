package org.kudryavtsev.kickstarter;

import java.util.ArrayList;
import java.util.List;

public class View {
    private String greeting;

    public View() {
        greeting = "Лучший способ предвидеть будущее - это самим создать его.";
    }

    public void showGreeting() {
        System.out.println(greeting);
    }

    public void showProjects(List<Project> projectslist) {
        int counter = 1;
        for (Project project : projectslist) {
            System.out.println("(" + counter + ") " + project);
            counter++;
        }
    }

    public void showCategories(List<Category> list, int i) {
        System.out.println("You entered: " + list.get(i - 1));
    }

    public void showCategories(List<Category> categoryList) {
        int counter = 1;
        for (Category category : categoryList) {
            System.out.println("(" + counter + ") " + category);
            counter++;
        }
    }

    public void showProject(Project project) {
        System.out.println(project.toStringFull());
    }
}
