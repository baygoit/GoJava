package org.kudryavtsev.kickstarter;

import java.util.List;

public class View {
    private String greeting;
    private Out out;

    public View(Out output) {
        greeting = "Лучший способ предвидеть будущее - это самим создать его.";
        out = output;
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
        // List<Object> list = categoryList;
        // showList(list);
    }

    public void showProject(Project project) {
        out.output(project.toStringFull());
    }

    public void showProjectMenu() {
        out.output("Select option: (not implemented, just '0' to exit)");
    }

    public void showList(List<Object> list) {
        int counter = 1;
        for (Object element : list) {
            out.output("(" + counter + ") " + element);
            counter++;
        }
    }
}
