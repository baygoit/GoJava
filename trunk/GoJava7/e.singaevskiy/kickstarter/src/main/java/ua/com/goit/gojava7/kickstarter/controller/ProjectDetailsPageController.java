package ua.com.goit.gojava7.kickstarter.controller;

import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.dao.PledgeStorage;

public class ProjectDetailsPageController extends PageController<Project> {

    @Override
    protected void handle() {        
        PledgeStorage pledgeDAO = storageFactory.getPledgeDAO();
        request.setBalanceSum(pledgeDAO.getSum(request));
        page.showProjectDetails(request);    
    }

    @Override
    protected boolean isDone() {
        int option = getMenuOptionFromUser(2);       

        if (option == OPTION_EXIT) {
            return true;
        } else if (option == 1) { 
            
            dispatchNext(request, new MessagePageController());

        } else if (option == 2) { 
            
            dispatchNext(request, new RewardSelectionPageController());

        }
        
        return false;
    }

}
