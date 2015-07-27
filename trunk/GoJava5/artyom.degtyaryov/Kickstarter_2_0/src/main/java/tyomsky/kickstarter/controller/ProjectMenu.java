package tyomsky.kickstarter.controller;

import tyomsky.kickstarter.dao.ProjectsDAO;
import tyomsky.kickstarter.model.Project;
import tyomsky.kickstarter.ui.IO;

public class ProjectMenu extends Menu<Integer> {

    ProjectsDAO projectsDAO;
    private Project project;

    public ProjectMenu(ProjectsDAO projectsDAO, IO io) {
        super(io);
        this.projectsDAO = projectsDAO;
    }

    @Override
    public Menu nextMenu(Integer selected) {
        int chosenMenuIndex = selected;
        if (chosenMenuIndex == 1){
            PaymentMenu paymentMenu = (PaymentMenu) childMenu;
            paymentMenu.setProject(project);
            return paymentMenu;
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
    public Integer select(int chosenMenuIndex) {
        return chosenMenuIndex;
    }

    @Override
    public void ask() {
        printProjectDetails(project);
        askProject(project);
    }

    private void askProject(Project chosenProject) {
        io.println("Select action (0 for exit): \n" +
                "1: Invest in project \n" +
                "2: Ask a question");
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

    public void setProject(Project project) {
        this.project = project;
    }
}