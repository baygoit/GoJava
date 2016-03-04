package ua.dborisenko.kickstarter;

import java.util.ArrayList;
import java.util.List;

public class ControllerMain {
    private boolean exitFlag;
    private ProjectCategory currentProjectCategory;
    private Project currentProject;
    private View currentView = new ViewProjectCategories(DataSource.allProjectCategories,
            DataSourceDailyPhrase.getRandomOne());

    private void showError(int errorCode, String errorName, String errorDescription) {
        Error error = new Error(errorCode, errorName, errorDescription);
        ViewError viewError = new ViewError(error);
        viewError.generate();
    }

    public void showMainMenu() {
        while (!exitFlag) {
            String inputData = this.currentView.generate();
            if (currentView.getClass() == ViewProjectCategories.class) {
                handleViewProjectCategoriesResult(inputData);
            } else if (currentView.getClass() == ViewProjects.class) {
                handleViewProjectsResult(inputData);
            } else if (currentView.getClass() == ViewProject.class) {
                handleViewProjectResult(inputData);
            } else {
                showError(501, "Not Implemented", "Unknown view type.");
            }
        }
        System.out.println("Have a nice day!");
    }

    private void handleViewProjectResult(String inputData) {
        if (inputData.equals("0")) {
            currentProject = null;
            List<Project> currentProjects = new ArrayList<Project>();
            currentProjects = DataSourceProject.getProjectsByCategoryId(currentProjectCategory.getId());
            currentView = new ViewProjects(currentProjects, currentProjectCategory.getName());
        }
    }

    private void handleViewProjectsResult(String inputData) {
        if (inputData.equals("0")) {
            currentProjectCategory = null;
            currentView = new ViewProjectCategories(DataSource.allProjectCategories,
                    DataSourceDailyPhrase.getRandomOne());
        } else {
            try {
                List<Project> currentProjects = new ArrayList<Project>();
                currentProjects = DataSourceProject.getProjectsByCategoryId(currentProjectCategory.getId());
                int projectNumber = Integer.valueOf(inputData) - 1;
                currentProject = currentProjects.get(projectNumber);
                currentView = new ViewProject(currentProject);
            } catch (IndexOutOfBoundsException e) {
                showError(404, "Not Found", "The requested element isn`t found.");
            } catch (NumberFormatException e) {
                showError(400, "Bad Request", "Wrong input data.");
            }
        }
    }

    private void handleViewProjectCategoriesResult(String inputData) {
        if (inputData.equals("0")) {
            exitFlag = true;
        } else {
            try {
                int projectCategoryNumber = Integer.valueOf(inputData) - 1;
                currentProjectCategory = DataSource.allProjectCategories.get(projectCategoryNumber);
                List<Project> currentProjects = new ArrayList<Project>();
                currentProjects = DataSourceProject.getProjectsByCategoryId(currentProjectCategory.getId());
                currentView = new ViewProjects(currentProjects, currentProjectCategory.getName());
            } catch (IndexOutOfBoundsException e) {
                showError(404, "Not Found", "The requested element isn`t found.");
            } catch (NumberFormatException e) {
                showError(400, "Bad Request", "Wrong input data.");
            }
        }
    }
}
