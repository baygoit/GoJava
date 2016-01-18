package ua.com.goit.gojava7.kickstarter.model;

import ua.com.goit.gojava7.kickstarter.view.exception.ExitException;
import ua.com.goit.gojava7.kickstarter.view.View;

import java.io.IOException;

public interface KickstarterObservable {

    void notifyView() throws ExitException, IOException;

    void addObserver(View view);

    void removeObserver(View view);
}
