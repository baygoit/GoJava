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
        categoriesMenu().run();
    }



    private Menu categoriesMenu() {
        return new Menu(io) {

            @Override
            public Menu nextMenu(Object selected) {
                List<Project> foundProjects = getProjetsByCategory((Category) selected);
                return projectsMenu(foundProjects);
            }

            @Override
            public Object select(int chosenMenuIndex) {
                return chooseCategory(chosenMenuIndex);
            }

            @Override
            public void ask() {
                askCategories();
            }
        };
    }

    private void askCategories() {
        showCategories();
        io.println("Select item ("+EXIT_CODE +" for exit)");
    }

    private Menu projectsMenu(final List<Project> foundProjects) {
        return new Menu(io) {

            @Override
            public Menu nextMenu(Object selected) {
                return projectMenu((Project) selected);
            }

            @Override
            public Object select(int chosenMenuIndex) {
                return chooseProject(foundProjects, chosenMenuIndex);
            }

            @Override
            public void ask() {
                askProjects(foundProjects);
            }
        };
    }

    private void askProjects(List<Project> foundProjects) {
        showProjects(foundProjects);
        io.println("Select item ("+ EXIT_CODE +" for exit)");

    }

    private Menu projectMenu(final Project chosenProject) {
        return new Menu(io) {

            @Override
            public Menu nextMenu(Object selected) {
                int chosenMenuIndex = (int) selected;
                if (chosenMenuIndex == 1){
                    io.println("Thanks for helping our project");
                    io.println("Enter your name");
                    String name = io.read();
                    io.println("Enter the number of your card");
                    int cardNumber = Integer.parseInt(io.read());
                    io.println("Enter the amount of money");
                    int amount = Integer.parseInt(io.read());
                    chosenProject.setMoneyCollected(chosenProject.getMoneyCollected() + amount);
                    io.println("Thank you! You can go!");
                }
                if (chosenMenuIndex == 2){
                    io.println("Enter your name");
                    String name = io.read();
                    io.println("Enter your question");
                    String question = io.read();
                    io.println("Thank you " + name + " for your question");
                    io.println("---------------------------------------");

                    chosenProject.setQuestionsAndAnswers((question));
                }
                return null; /// payment menu
            }

            @Override
            public Object select(int chosenMenuIndex) {
                return chosenMenuIndex;
            }

            @Override
            public void ask() {
                printProjectDetails(chosenProject);
                askProject(chosenProject);
            }
        };

    }

    private void askProject(Project chosenProject) {
        io.println("Select action ("+EXIT_CODE +" for exit): \n" +
                "1: Invest in project");
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
        String history = project.getHistory();
        if (!(history == null)) {
            io.println("History: " + project.getHistory());
        }
        String qAndA = project.getQuestionsAndAnswers();
        if (!(qAndA == null)) {
            io.println("FAQ: " + project.getQuestionsAndAnswers());
        }
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
        if (foundProjects.size() == 0) {
            io.println("nothing to do here.");
        }
        for (int i = 0; i < foundProjects.size(); i++) {
            int menuIndex = i + 1;
            Project project = foundProjects.get(i);
            io.println(menuIndex + ": " + project.getShortPresentation());
            io.println("------------------------------------------------------");
        }
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
