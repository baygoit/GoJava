package ua.com.goit.gojava7.kickstarter.view.page;

import ua.com.goit.gojava7.kickstarter.model.Project;
import ua.com.goit.gojava7.kickstarter.view.ConsoleView;
import ua.com.goit.gojava7.kickstarter.view.exception.ExitException;

import java.io.BufferedReader;
import java.io.IOException;

public class ProjectPage implements Page {
    ConsoleView view;

    Project project;

    public ProjectPage(ConsoleView view, Project project) {
        this.view = view;
        this.project = project;
    }

    @Override
    public void show() throws ExitException, IOException {
        view.printProjectDetailedInfo(project);

        System.out.println();

        System.out.println("Would you like to donate? (Enter \"y\" if so or any key otherwise.)");

        BufferedReader reader = view.getReader();

        String confirmation = reader.readLine();

        if (confirmation.equals("y") || confirmation.equals("Y")) {
            System.out.println("Enter your name please.");

            String name = reader.readLine(); // currently ignored

            System.out.println("Enter number of your card please.");

            String card = reader.readLine(); // currently ignored

            System.out.println("What sum would you like to donate?");

            String money = reader.readLine();

            int sum;
            try {
                sum = Integer.parseInt(money);
                if (sum <= 0) {
                    System.out.println("Sorry, can't accept donation.");
                    System.out.println();
                    remindToChoose();
                } else {
                    System.out.println("Thank you for your donation.");
                    System.out.println();
                    view.getController().donate(project, sum);
                }
            } catch (NumberFormatException | NullPointerException e) {
                System.out.println("Sorry, can't accept donation.");
                System.out.println();
                remindToChoose();
            }
        } else {
            System.out.println("OK, no donation at the moment.");
            System.out.println();
            remindToChoose();
        }
    }

    @Override
    public void remindToChoose() {
        System.out.println("Press any key to go back to category \"" + project.getCategory().getName()
                + "\" when ready.");
    }


    @Override
    public Page getUpdated(String command) {
        return new CategoryPage(view, project.getCategory());
}

}
