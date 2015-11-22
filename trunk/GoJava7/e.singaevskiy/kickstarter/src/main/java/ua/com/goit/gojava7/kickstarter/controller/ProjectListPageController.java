package ua.com.goit.gojava7.kickstarter.controller;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.beans.Category;
import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.dao.PaymentStorage;
import ua.com.goit.gojava7.kickstarter.dao.ProjectStorage;

public class ProjectListPageController extends PageController<Category> {

    private List<Project> foundProjects;

    @Override
    protected void handle() {
        
        ProjectStorage projectDAO = storageFactory.getProjectDAO();
        PaymentStorage paymentDAO = storageFactory.getPaymentDAO();
        
        foundProjects = projectDAO.getByCategory(request);
        foundProjects.forEach(project -> project.setBalanceSum(paymentDAO.getSum(project)));
        page.showProjects(foundProjects);

        
    }

    @Override
    protected boolean isDone() {
        int option = getMenuOptionFromUser(foundProjects.size());

        if (option == OPTION_EXIT) {
            return true;
        } else { 
            
            PageController<Project> nextPage = new ProjectDetailsPageController();
            dispatchNext(foundProjects.get(option-1), nextPage);
            
            return false;
        }
    }

}
