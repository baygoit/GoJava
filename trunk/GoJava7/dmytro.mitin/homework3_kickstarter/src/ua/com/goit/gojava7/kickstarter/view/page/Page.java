package ua.com.goit.gojava7.kickstarter.view.page;

import ua.com.goit.gojava7.kickstarter.view.exception.ExitException;

public interface Page {
    void show() throws ExitException;

    void remindToChoose();

    Page getUpdated(String command);

}
