package ua.com.goit.gojava7.salivon.handlers;

import java.util.List;
import ua.com.goit.gojava7.salivon.ManagerData;
import ua.com.goit.gojava7.salivon.beans.Category;
import ua.com.goit.gojava7.salivon.handlers.ErrorHandler;
import ua.com.goit.gojava7.salivon.beans.Project;
import ua.com.goit.gojava7.salivon.state.State;

public class ErrorHandlerStateCategory implements ErrorHandler {

    private List<Project> projects;

    public ErrorHandlerStateCategory(ManagerData managerData) {
        this.projects = managerData.getProjectsOfCategory(State.getIndexCategory());
    }

    @Override
    public boolean validate(String inData) {
        try {
            int n = Integer.parseInt(inData);
            for (Project project : projects) {
                if (project.getId() == n) {
                    return true;
                }
            }

        } catch (NumberFormatException e) {
            return false;
        }
        return false;
    }

}
