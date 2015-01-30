package org.kudryavtsev.kickstarter;

import java.util.List;

public class View implements Out {
    private String greeting;
    private Out out;

    public View() {
        greeting = "Лучший способ предвидеть будущее - это самим создать его.";
        out = new OutArrayList();
    }

    public void showGreeting() {
        out.output(greeting);
    }

    public void showProjects(List<Project> projectslist) {
        int counter = 1;
        for (Object project : projectslist) {
            out.output("(" + counter + ") " + project);
            counter++;
        }
    }

    public void showCategories(List<Category> list, int i) {
        out.output("You entered: " + list.get(i - 1));
    }

    public void showCategories(List<Category> categoryList) {
        int counter = 1;
        for (Object category : categoryList) {
            out.output("(" + counter + ") " + category);
            counter++;
        }
    }

    public void showProject(Project project) {
        out.output(project.toStringFull());
    }

    public void showProjectMenu() {
        out.output("Select option: (not implemented, just '0' to exit)");
    }

    @Override
    public void output(String output) {
    }

}
