package ua.com.goit.gojava7.kickstarter.view.page;

import ua.com.goit.gojava7.kickstarter.view.ConsoleView;

public class ErrorPage implements Page {
    ConsoleView view;

    public ErrorPage(ConsoleView view) {
        this.view = view;
    }

    @Override
    public void show() {
        System.out.println("Error.");
        System.out.println("Please try again.");
        System.out.println("(Enter \"b\" to go back.)");
    }

    @Override
    public void remindToChoose() {
    }

    @Override
    public Page getUpdated(String command) {
        if (ConsoleView.isStandard(command)) {
            return view.updatePageToStandard(command);
        }
        return new ErrorPage(view);
    }
}
