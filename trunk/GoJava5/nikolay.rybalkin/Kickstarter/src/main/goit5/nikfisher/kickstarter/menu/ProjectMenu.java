package goit5.nikfisher.kickstarter.menu;

import goit5.nikfisher.kickstarter.model.Project;
import goit5.nikfisher.kickstarter.streams.ConsoleInterfaceIO;

class ProjectMenu {

    final private ConsoleInterfaceIO IO;

    public ProjectMenu(ConsoleInterfaceIO io) {
        this.IO = io;
    }

    public void projectMenuRun(Project project) {

        while (true) {

            IO.println("Operations on the project: [0 - go to the list of projects, 1 - invest in the project, 2 - asc questions");

            int menuIndexElement = IO.consoleScanInt();

            if (menuIndexElement == 0) {
                break;
            }

            if (menuIndexElement == 1) {
                IO.println("Thank you want to help!");
                int required_amount = project.getAmount();

                IO.println("The required amount: " + String.valueOf(required_amount));

                PaymentMenu bonusMenu = new PaymentMenu(IO);
                bonusMenu.bonusMenu(project);

            }
            if (menuIndexElement == 2) {
                IO.println("Enter your name");
                String name = IO.consoleScanString();
                IO.println("Enter your question");
                String question = IO.consoleScanString();
                IO.println("Thank you " + name + " for your question");
                IO.println("---------------------------------------");

                project.question((question));
            }
        }
    }
}
