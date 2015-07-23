package goit5.nikfisher.kickstarter.menu;

import goit5.nikfisher.kickstarter.model.Project;
import goit5.nikfisher.kickstarter.streams.InputOutputConsoleInterface;

public class ProjectMenu {

    private static InputOutputConsoleInterface io;

    public ProjectMenu(InputOutputConsoleInterface io) {
        ProjectMenu.io = io;
    }

    public void projectMenuRun(Project project) {

        while (true) {

            io.println("Operations on the project: [0 - go to the list of projects, 1 - invest in the project, 2 - asc questions");

            int menuIndexElement = io.consoleScanInt();

            if (menuIndexElement == 0) {
                break;
            }

            if (menuIndexElement == 1) {
                io.println("Thank you want to help!");
                int required_amount = project.getAmount();
                io.println("The required amount: " + String.valueOf(required_amount));
                io.println("1) If you invest up to 10% of the required amount, you will receive a 1% to 5%.");
                io.println("2) If you invest up to 50% of the required amount, you will receive a 5% to 15%.");
                io.println("3) If you invest up to 100% of the required amount, you will receive a 15% to 30%.");
                io.println("-----------------");
                io.println("Enter your name");
                String name = io.consoleScanString();
                io.println("Enter the number of your card");
                int cardNumber = io.consoleScanInt();
                io.println("Enter the amount of money");
                int amount = io.consoleScanInt();
                //TODO проверку наа вводимые значения

                io.println("Thank you " + name + " your money is successfully transferred to the account of the project");
                io.println("---------------------------------------");

                project.donate((amount));
            }
            if (menuIndexElement == 2) {
                io.println("Enter your name");
                String name = io.consoleScanString();
                io.println("Enter your question");
                String question = io.consoleScanString();
                io.println("Thank you " + name + " for your question");
                io.println("---------------------------------------");

                project.question((question));
            }
        }
    }

}
