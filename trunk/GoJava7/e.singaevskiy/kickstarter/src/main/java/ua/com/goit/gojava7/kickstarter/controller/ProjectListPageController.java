package ua.com.goit.gojava7.kickstarter.controller;

import java.util.List;

import ua.com.goit.gojava7.kickstarter.dao.PaymentDAO;
import ua.com.goit.gojava7.kickstarter.dao.ProjectDAO;
import ua.com.goit.gojava7.kickstarter.domain.Category;
import ua.com.goit.gojava7.kickstarter.domain.Project;

public class ProjectListPageController extends AbstractPageController<Category> {

    private List<Project> foundProjects;

    @Override
    protected void handle() {
        
        ProjectDAO projectDAO = storageFactory.getProjectDAO();
        PaymentDAO paymentDAO = storageFactory.getPaymentDAO();
        
        foundProjects = projectDAO.getByCategory(request.getId());
        foundProjects.forEach(project -> project.setBalanceSum(paymentDAO.getSum(project.getId())));
        printer.showProjects(foundProjects);

        
    }

    @Override
    protected boolean isDone() {
        int option = getMenuOptionFromUser(foundProjects.size());

        if (option == OPTION_EXIT) {
            return true;
        } else { 
            
            AbstractPageController<Project> nextPage = new ProjectDetailsPageController();
            dispatchNext(foundProjects.get(option-1), nextPage);
            
            return false;
        }
    }

}
