package org.kudryavtsev.kickstarter.out;

import java.util.Iterator;
import java.util.List;

import org.kudryavtsev.kickstarter.data.Category;
import org.kudryavtsev.kickstarter.data.Project;

public class View {
    private String greeting;
    private Out out;

    public View(Out output) {
        greeting = "Лучший способ предвидеть будущее - это самим создать его.";
        out = output;
    }

    public void showGreeting() {
        show(greeting);
    }

    public void showProjects(Iterator<Project> projects) {
        showElements(projects);
    }
    
    public void showElements(Iterator objects) {
        int counter = 1;
        while (objects.hasNext()) {
            Object o = objects.next();
            show(menuIndex(counter) + o.toString());
            counter++;
        }
        showChoice();
    }

    private String menuIndex(int counter) {
        return "(" + counter + ") ";
    }

    public void showCategories(List<Category> list, int i) {
        show("You entered: " + list.get(i - 1));
    }

    public void showCategories(Iterator<Category> categories) {
        showElements(categories);   
    }

    public void showProject(Project project) {
        show(project.toStringFull());
//        out.output(String.format("%s; %s; %s", 
//                project.getName(), 
//                project.getDescription(), 
//                project.getStatus()));
        showProjectMenu();
        showChoice();
    }

    public void showProjectMenu() {
        show("Select option: \n"
                + "(1) - to invest\n"
                + "(2) - to add question\n"
                + "(0) to exit)");
    }

    public void showChoice(){
        show("You choice (0 - exit):");
    }
    
    public void show(String string){
        out.output(string);
    }
}
