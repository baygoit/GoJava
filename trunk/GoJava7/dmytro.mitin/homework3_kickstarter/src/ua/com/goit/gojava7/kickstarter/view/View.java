package ua.com.goit.gojava7.kickstarter.view;

import ua.com.goit.gojava7.kickstarter.view.exception.ExitException;

public interface View {
    // implementing Observer pattern
    void handleNotification() throws ExitException;
}
