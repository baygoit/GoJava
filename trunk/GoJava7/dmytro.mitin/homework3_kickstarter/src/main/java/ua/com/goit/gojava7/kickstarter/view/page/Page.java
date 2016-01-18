package ua.com.goit.gojava7.kickstarter.view.page;

import ua.com.goit.gojava7.kickstarter.view.exception.ExitException;

import java.io.IOException;

public interface Page {
    void show() throws ExitException, IOException;

    void remindToChoose();

    Page getUpdated(String command);

}
