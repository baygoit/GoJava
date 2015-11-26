package ua.com.goit.gojava7.kickstarter.controller;

import ua.com.goit.gojava7.kickstarter.beans.Project;

public class ProjectDetailsPageController extends PageController<Project> {

    @Override
    protected void handle() {        
        request.setQuestions(storageFactory.getQuestionsDAO().getByProject(request.getId()));
        request.setBalanceSum(storageFactory.getPaymentDAO().getSum(request.getId()));
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
