package tyomsky.kickstarter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Kickstarter {

    private IO io;
    private static final int EXIT_CODE = 0;
    private List<Category> categories;
    private List<Project> projects;
    private QuoteGenerator quoteGenerator;

    public Kickstarter(List<Category> categories, List<Project> projects, IO io, QuoteGenerator quoteGenerator) {
        this.categories = categories;
        this.projects = projects;
        this.io = io;
        this.quoteGenerator = quoteGenerator;
    }

    public void run() {
        String quote = quoteGenerator.getQuote();
        io.println(quote);
        processCategoriesMenu();

    }

    private void processCategoriesMenu() {
        while (true) {
            showCategories();
            int chosenMenuIndex = getChosenMenuIndex();
            if (isExitRequest(chosenMenuIndex)) {
                break;
            }
            Category chosenCategory = chooseCategory(chosenMenuIndex);
            if (chosenCategory == null) {
                continue;
            }
            List<Project> foundProjects = getProjetsByCategory(chosenCategory);
            processProjectsMenu(foundProjects);
        }
    }

    private void processProjectsMenu(List<Project> foundProjects) {
        while (true) {
            showProjects(foundProjects);
            int chosenMenuIndex = getChosenMenuIndex();
            if (isExitRequest(chosenMenuIndex)) {
                break;
            }
            Project chosenProject = chooseProject(foundProjects, chosenMenuIndex);
            if (chosenProject == null) {
                continue;
            }
            while (true) {
                printProjectDetails(chosenProject);
                if (isExitRequest(getChosenMenuIndex())) {
                    break;
                }
            }
        }
    }

    private boolean isExitRequest(int chosenMenuIndex) {
        return chosenMenuIndex == EXIT_CODE;
    }

    private Project chooseProject(List<Project> foundProjects, int chosenMenuIndex) {
        if (projectIndexIsInvalid(chosenMenuIndex, foundProjects)) {
            io.println("You have chosen wrong menu index " + chosenMenuIndex);
            return null; // or nil
        }
        Project project = foundProjects.get(chosenMenuIndex - 1);
        io.println("You have chosen: " + project.getName());
        return project;
    }

    private boolean categoryIndexIsInvalid(int chosenMenuIndex) {
        if (chosenMenuIndex <= 0 || chosenMenuIndex > categories.size()) {
            return true;
        }
        return false;
    }

    private void printProjectDetails(Project project) {
        String message = project.getDescription();
        io.println(message);
        io.println("Money to collect: " + project.getMoneyNeeded());
        io.println("Collected money: " + project.getMoneyCollected());
        io.println("Days left: " + project.getDaysLeft());
        io.println("Demo video: " + project.getDemoVideoLink());
        io.println("History: " + project.getHistory());
        io.println("FAQ: " + project.getQuestionsAndAnswers());
    }

    private boolean projectIndexIsInvalid(int chosenMenuIndex, List<Project> projectsList) {
        if (chosenMenuIndex <= 0 || chosenMenuIndex > projectsList.size()) {
            return true;
        }
        return false;
    }

    private Category chooseCategory(int chosenMenuIndex) {
        if (categoryIndexIsInvalid(chosenMenuIndex)) {
            io.println("You have chosen wrong menu index " + chosenMenuIndex);
            return null;
        }
        Category chosenCategory = categories.get(chosenMenuIndex - 1);
        io.println("You have chosen: " + chosenCategory.getName());
        io.println("------------------------------------------------------");
        return chosenCategory;
    }

    private void showProjects(List<Project> foundProjects) {
        for (int i = 0; i < foundProjects.size(); i++) {
            int menuIndex = i + 1;
            Project project = foundProjects.get(i);
            io.println(menuIndex + ": " + project.getShortPresentation());
            io.println("------------------------------------------------------");
        }
    }

    private int getChosenMenuIndex() {
        io.println("Make a choice (" + EXIT_CODE + " for exit): ");
        return io.read();
    }

    private void showCategories() {
        for (int i = 0; i < categories.size(); i++) {
            int menuIndex = i + 1;
            io.println(menuIndex + ": " + categories.get(i).getName());
        }
    }

    private List<Project> getProjetsByCategory(Category category) {
        List<Project> result = new ArrayList<>();
        for (Project project : projects) {
            if (project.getCategory().equals(category)) {
                result.add(project);
            }
        }
        return result;
    }

}
