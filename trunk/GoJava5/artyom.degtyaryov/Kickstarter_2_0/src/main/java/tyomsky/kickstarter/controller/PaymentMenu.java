package tyomsky.kickstarter.controller;

import tyomsky.kickstarter.dao.ProjectsDAO;
import tyomsky.kickstarter.model.Project;
import tyomsky.kickstarter.ui.IO;

public class PaymentMenu extends Menu <Integer> {

    private ProjectsDAO projectsDAO;
    private Project project;

    public PaymentMenu(ProjectsDAO projectsDAO, IO io) {
        super(io);
        this.projectsDAO = projectsDAO;
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
    public Integer select(int chosenMenuIndex) {
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

    public void setProject(Project project) {
        this.project = project;
    }

}

