package tyomsky.kickstarter.controller;

import tyomsky.kickstarter.dao.ProjectsDAO;
import tyomsky.kickstarter.model.Project;
import tyomsky.kickstarter.ui.Input;
import tyomsky.kickstarter.view.TextView;

public class ProjectMenu extends Menu<Integer> {

    private ProjectsDAO projectsDAO;
    private Project model;
    private TextView view;


    public ProjectMenu(ProjectsDAO projectsDAO, Input input, TextView view) {
        super(input);
        this.projectsDAO = projectsDAO;
        this.view = view;
    }

    @Override
    public Menu nextMenu(Integer selected) {
        int chosenMenuIndex = selected;
        if (chosenMenuIndex == 1){
            PaymentMenu paymentMenu = (PaymentMenu) childMenu;
            paymentMenu.setProject(model);
            return paymentMenu;
        }
        if (chosenMenuIndex == 2){
            view.printMessage("Enter your question");
            String question = input.read();
            view.printMessage("Thanks for your question");
            model.setQuestionsAndAnswers(model.getQuestionsAndAnswers()+"\n Q: "+question);
        }
        return null;
    }

    @Override
    public Integer select(int chosenMenuIndex) {
        return chosenMenuIndex;
    }

    @Override
    public void ask() {
        printProjectDetails(model);
        askProject(model);
        view.showInputPrompt();
    }

    private void askProject(Project chosenProject) {
        view.showMenuElementWithID("Invest in project", "1");
        view.showMenuElementWithID("Ask a question", "2");
    }

    private void printProjectDetails(Project project) {
        view.showFullDescription(project);
    }

    public void setModel(Project model) {
        this.model = model;
    }
}