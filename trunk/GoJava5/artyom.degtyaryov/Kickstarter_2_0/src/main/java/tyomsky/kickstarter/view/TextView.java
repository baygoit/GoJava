package tyomsky.kickstarter.view;

import tyomsky.kickstarter.model.Category;
import tyomsky.kickstarter.model.Project;
import tyomsky.kickstarter.ui.IO;

import java.util.List;

public class TextView {

    IO io;

    public TextView(IO io) {
        this.io = io;
    }

    public void showMenuElement(Project project, String id) {
        showDelimiter();
        String elementPresentation = String.format("%s: %s \n" +
                "%s \n" +
                "Need to collect - %d$. Collected - %d$. Days left - %d",
                id, project.getName(),project.getDescription(), project.getMoneyNeeded(),
                project.getMoneyCollected(), project.getDaysLeft());
        io.println(elementPresentation);
    }

    private void showDelimiter() {
        io.println("------------------------------------------------------");
    }

    public void showMenuElement(Category category, String id) {
        String elementPresentation = String.format("%s: %s", id, category.getName());
        io.println(elementPresentation);
    }

    public void printFullDescription(Project project) {

    }

    public void printMessage(String message) {

    }

    public void showInputPrompt() {
        io.println("Select item (0 for exit)");
    }

    public void showSelected(String selected) {
       io.println(String.format("You have selected - %s", selected));
    }
//    public void printIn

}
