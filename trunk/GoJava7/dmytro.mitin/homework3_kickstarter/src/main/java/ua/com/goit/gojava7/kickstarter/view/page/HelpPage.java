package ua.com.goit.gojava7.kickstarter.view.page;

import ua.com.goit.gojava7.kickstarter.view.ConsoleView;

public class HelpPage implements Page {
    ConsoleView view;

    public HelpPage(ConsoleView view) {
        this.view = view;
    }

    @Override
    public void show() {
        System.out.println("Help:");
        System.out.println("h - help");
        System.out.println("x or 0 - exit");
        System.out.println("c - list of categories");
        System.out.println("u - update");
        System.out.println("b - back");
        System.out.println();
        remindToChoose();
    }

    @Override
    public void remindToChoose() {
        System.out.println("Please make your choice (h/x/c/u/b).");
    }

    @Override
    public Page getUpdated(String command) {
        if (ConsoleView.isStandard(command)) {
            return view.updatePageToStandard(command);
        }
        return new ErrorPage(view);
    }
}
