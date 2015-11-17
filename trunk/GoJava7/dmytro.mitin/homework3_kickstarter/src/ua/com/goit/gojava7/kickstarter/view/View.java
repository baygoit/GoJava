package ua.com.goit.gojava7.kickstarter.view;

import ua.com.goit.gojava7.kickstarter.view.exception.ExitException;

/**
 * Created by Dmytro on 07.11.2015.
 */
public interface View {
    // implementing Observer pattern
    public abstract void reloadPage() throws ExitException;
}
