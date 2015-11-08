package ua.com.goit.gojava7.kickstarter.view.page;

import ua.com.goit.gojava7.kickstarter.view.exception.ExitException;

/**
 * Created by Dmytro on 07.11.2015.
 */
public interface Page {
    void show() throws ExitException;

    void remindToChoose();

    Page getUpdated(String command);

}
