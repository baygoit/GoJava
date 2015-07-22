package tyomsky.kickstarter.controller;

import tyomsky.kickstarter.dao.CategoriesDAO;
import tyomsky.kickstarter.dao.Projects;
import tyomsky.kickstarter.model.Category;
import tyomsky.kickstarter.model.Project;
import tyomsky.kickstarter.model.QuoteGenerator;
import tyomsky.kickstarter.ui.IO;

import java.util.ArrayList;
import java.util.List;

public class Kickstarter {

    private IO io;
    private CategoriesDAO categories;
    private Projects projects;
    private QuoteGenerator quoteGenerator;

    public Kickstarter(CategoriesDAO categories, Projects projects, IO io, QuoteGenerator quoteGenerator) {
        this.categories = categories;
        this.projects = projects;
        this.io = io;
        this.quoteGenerator = quoteGenerator;
    }

    public void run() {
        String quote = quoteGenerator.getQuote();
        io.println(quote);
        new CategoriesMenu().run();
    }

    private void askCategories() {
        showCategories();
        io.println("Select item (0 for exit)");
    }

    private void askProjects(List<Project> foundProjects) {
        showProjects(foundProjects);
        io.println("Select item (0 for exit)");

    }

    private void askProject(Project chosenProject) {
        io.println("Select action (0 for exit): \n" +
                "1: Invest in project \n" +
                "2: Ask a question");
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
        return chosenMenuIndex <= 0 || chosenMenuIndex > categories.size();
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
        return chosenMenuIndex <= 0 || chosenMenuIndex > projectsList.size();
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
        for (int i = 0; i < projects.size(); i++) {
            if (projects.get(i).getCategory().equals(category)) {
                result.add(projects.get(i));
            }
        }
        return result;
    }

    private class CategoriesMenu extends Menu {

        public CategoriesMenu() {
            super(Kickstarter.this.io);
        }

        @Override
        public Menu nextMenu(Object selected) {
            List<Project> foundProjects = getProjetsByCategory((Category) selected);
            return new ProjectsMenu(foundProjects);
        }

        @Override
        public Object select(int chosenMenuIndex) {
            return chooseCategory(chosenMenuIndex);
        }

        @Override
        public void ask() {
            askCategories();
        }
    }

    private class ProjectsMenu extends Menu {

        private final List<Project> foundProjects;

        public ProjectsMenu(List<Project> foundProjects) {
            super(Kickstarter.this.io);
            this.foundProjects = foundProjects;
        }

        @Override
        public Menu nextMenu(Object selected) {
            return new ProjectMenu((Project) selected);
        }

        @Override
        public Object select(int chosenMenuIndex) {
            return chooseProject(foundProjects, chosenMenuIndex);
        }

        @Override
        public void ask() {
            askProjects(foundProjects);
        }
    }

    private class ProjectMenu extends Menu {

        private final Project project;

        public ProjectMenu(Project project) {
            super(Kickstarter.this.io);
            this.project = project;
        }

        @Override
        public Menu nextMenu(Object selected) {
            int chosenMenuIndex = (int) selected;
            if (chosenMenuIndex == 1){
                return new PaymentMenu(project);
            }
            if (chosenMenuIndex == 2){
                io.println("Enter your question");
                String question = io.read();
                io.println("Thank for your question");
                project.setQuestionsAndAnswers(project.getQuestionsAndAnswers()+"\n Q: "+question);
            }
            return null;
        }

        @Override
        public Object select(int chosenMenuIndex) {
            return chosenMenuIndex;
        }

        @Override
        public void ask() {
            printProjectDetails(project);
            askProject(project);
        }
    }

    private class PaymentMenu extends Menu {

        Project project;

        public PaymentMenu( Project project) {
            super(Kickstarter.this.io);
            this.project = project;
        }

        @Override
        public Menu nextMenu(Object selected) {
            int chosenMenuIndex = (int) selected;
            int amount;
            switch (chosenMenuIndex) {
                case 1: {
                    amount = 1;
                    break;
                }
                case 2: {
                    amount = 5;
                    break;
                }
                case 3: {
                    amount = 20;
                    break;
                }
                case 9: {
                    io.println("Enter the amount of money");
                    amount = Integer.parseInt(io.read());
                    break;
                }
                default:
                    amount = 0; //:(
            }
            io.println("Enter your name");
            String name = io.read();
            io.println("Enter the number of your card");
            int cardNumber = Integer.parseInt(io.read());
            project.setMoneyCollected(project.getMoneyCollected() + amount);
            io.println("Thank you, "+ name +"! You can go now! ");
            return null;

        }

        @Override
        public Object select(int chosenMenuIndex) {
            return chosenMenuIndex;
        }

        @Override
        public void ask() {
            //TODO to realise payment variants in project field
            io.println("Thanks for helping our project");
            io.println("You can choose variant or enter your sum:");
            io.println("1 - 1$");
            io.println("2 - 5$");
            io.println("3 - 20$");
            io.println("9 - Your sum");
            io.println("0 - Back");
        }
    }

}
