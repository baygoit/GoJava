package tyomsky.kickstarter.controller;

import tyomsky.kickstarter.dao.ProjectsDAO;
import tyomsky.kickstarter.model.Project;
import tyomsky.kickstarter.ui.Input;
import tyomsky.kickstarter.view.TextView;

public class PaymentMenu extends Menu <Integer> {

    private ProjectsDAO projectsDAO; // for getting payment variants in future
    private Project project;
    private TextView view;

    public PaymentMenu(ProjectsDAO projectsDAO, Input input, TextView view) {
        super(input);
        this.projectsDAO = projectsDAO;
        this.view = view;
    }

    @Override
    public Menu nextMenu(Integer selected) {
        int chosenMenuIndex = selected;
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
                view.printMessage("Enter the amount of money");
                amount = Integer.parseInt(input.read());
                break;
            }
            default:
                amount = 0; //:(
        }
        view.printMessage("Enter your name");
        String name = input.read();
        view.printMessage("Enter the number of your card");
        int cardNumber = Integer.parseInt(input.read());
        project.setMoneyCollected(project.getMoneyCollected() + amount);
        view.printMessage("Thank you, " + name + "! You can go now! ");
        return null;

    }

    @Override
    public Integer select(int chosenMenuIndex) {
        return chosenMenuIndex;
    }

    @Override
    public void ask() {
        //TODO to realise payment variants in project field
        view.showMenuElementWithID("1$", "1");
        view.showMenuElementWithID("5$", "2");
        view.showMenuElementWithID("20$", "3");
        view.showMenuElementWithID("Input sum", "9");
        view.showInputPrompt();
    }

    public void setProject(Project project) {
        this.project = project;
    }

}

