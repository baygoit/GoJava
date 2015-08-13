package tyomsky.kickstarter.view;

import tyomsky.kickstarter.model.Category;
import tyomsky.kickstarter.model.Project;
import tyomsky.kickstarter.ui.IO;
import tyomsky.kickstarter.ui.Output;

public class TextView {

    Output output;

    public TextView(Output output) {
        this.output = output;
    }

    public void showMenuElementWithID(Project project, String id) {
        showDelimiter();
        String elementPresentation = String.format("%s: %s \n" +
                        "%s \n" +
                        "Need to collect - %d$. Collected - %d$. Days left - %d",
                id, project.getName(), project.getDescription(), project.getMoneyNeeded(),
                project.getMoneyCollected(), project.getDaysLeft());
        output.println(elementPresentation);
    }

    private void showDelimiter() {
        output.println("------------------------------------------------------");
    }

    public void showMenuElementWithID(Category category, String id) {
        String elementPresentation = String.format("%s: %s", id, category.getName());
        output.println(elementPresentation);
    }

    public void showMenuElementWithID(String elementPresentation, String id) {
        output.println(String.format("%s: %s", id, elementPresentation));
    }

    public void showFullDescription(Project project) {
        String message = project.getDescription();
        output.println(message);
        output.println("Money to collect: " + project.getMoneyNeeded());
        output.println("Collected money: " + project.getMoneyCollected());
        output.println("Days left: " + project.getDaysLeft());
        output.println("Demo video: " + project.getDemoVideoLink());
        String history = project.getHistory();
        if (!(history == null)) {
            output.println("History: " + project.getHistory());
        }
        String qAndA = project.getQuestionsAndAnswers();
        if (!(qAndA == null)) {
            output.println("FAQ: " + project.getQuestionsAndAnswers());
        }
    }

    public void printMessage(String message) {
        output.println(message);
    }

    public void showInputPrompt() {
        output.println("Select item (0 for exit)");
    }

    public void showSelected(String selected) {
        output.println(String.format("You have selected - %s", selected));
    }

}
