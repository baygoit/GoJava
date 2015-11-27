package ua.com.goit.gojava7.salivon.handlers;

import java.util.List;
import ua.com.goit.gojava7.salivon.beans.Project;
import ua.com.goit.gojava7.salivon.state.State;
import ua.com.goit.gojava7.salivon.dao.DaoFactory;

public class ErrorHandlerStateCategory implements ErrorHandler {

    private List<Project> projects;

    public ErrorHandlerStateCategory() {
        this.projects = DaoFactory.getProjectDao(State.getCurrentDataType()).getProjectsOfCategory(State.getIdCategory());
    }

    @Override
    public boolean validate(String inData) {
        try {
            int n = Integer.parseInt(inData);
            return n - 1 >= 0 && n - 1 < projects.size();
        } catch (NumberFormatException e) {
            return false;
        }

    }

}
