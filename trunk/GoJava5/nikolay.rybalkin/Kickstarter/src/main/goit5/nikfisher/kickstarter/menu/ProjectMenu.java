package goit5.nikfisher.kickstarter.menu;

import goit5.nikfisher.kickstarter.model.Project;
import goit5.nikfisher.kickstarter.streams.ConsoleInterfaceIO;

public class ProjectMenu {

    private static ConsoleInterfaceIO io;

    public ProjectMenu(ConsoleInterfaceIO io) {
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

                BonusMenu bonusMenu = new BonusMenu(io);
                bonusMenu.bonusMenu();

                io.println("-----------------");
                io.println("Enter your name");
                String name = io.consoleScanString();
                io.println("Enter the number of your card");
                int cardNumber = io.consoleScanInt();
                io.println("Enter the amount of money");
                int amount = io.consoleScanInt();
                //TODO

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
