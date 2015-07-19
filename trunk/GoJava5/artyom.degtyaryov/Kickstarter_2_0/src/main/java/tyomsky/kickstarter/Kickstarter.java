package tyomsky.kickstarter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kickstarter {

    private static final int EXIT_CODE = 0;
    List<Category> categories;
    List<Project> projects;

    public Kickstarter(List<Category> categories, List<Project> projects) {
        this.categories = categories;
        this.projects = projects;
    }

    public void run() {
        System.out.println(new QuoteGenerator().getQuote());
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
            System.out.println("You have chosen wrong menu index " + chosenMenuIndex);
            return null; // or nil
        }
        Project project = foundProjects.get(chosenMenuIndex - 1);
        System.out.println("You have chosen: " + project.getName());
        return project;
    }

    private boolean categoryIndexIsInvalid(int chosenMenuIndex) {
        if (chosenMenuIndex <= 0 || chosenMenuIndex > categories.size()) {
            return true;
        }
        return false;
    }

    private void printProjectDetails(Project project) {
        System.out.println(project.getDescription());
        System.out.println("Money to collect: " + project.getMoneyNeeded());
        System.out.println("Collected money: " + project.getMoneyCollected());
        System.out.println("Days left: " + project.getDaysLeft());
        System.out.println("Demo video: " + project.getDemoVideoLink());
        System.out.println("History: " + project.getHistory());
        System.out.println("FAQ: " + project.getQuestionsAndAnswers());
    }

    private boolean projectIndexIsInvalid(int chosenMenuIndex, List<Project> projectsList) {
        if (chosenMenuIndex <= 0 || chosenMenuIndex > projectsList.size()) {
            return true;
        }
        return false;
    }

    private Category chooseCategory(int chosenMenuIndex) {
        if (categoryIndexIsInvalid(chosenMenuIndex)) {
            System.out.println("You have chosen wrong menu index " + chosenMenuIndex);
            return null;
        }
        Category chosenCategory = categories.get(chosenMenuIndex - 1);
        System.out.println("You have chosen: " + chosenCategory.getName());
        System.out.println("------------------------------------------------------");
        return chosenCategory;
    }

    private void showProjects(List<Project> foundProjects) {
        for (int i = 0; i < foundProjects.size(); i++) {
            int menuIndex = i + 1;
            Project project = foundProjects.get(i);
            System.out.println(menuIndex + ": " + project.getShortPresentation());
            System.out.println("------------------------------------------------------");
        }
    }

    private int getChosenMenuIndex() {
        System.out.println("Make a choice (" + EXIT_CODE + " for exit): ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private void showCategories() {
        for (int i = 0; i < categories.size(); i++) {
            int menuIndex = i + 1;
            System.out.println(menuIndex + ": " + categories.get(i).getName());
        }
        System.out.println("------------------------------------------------------");
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
