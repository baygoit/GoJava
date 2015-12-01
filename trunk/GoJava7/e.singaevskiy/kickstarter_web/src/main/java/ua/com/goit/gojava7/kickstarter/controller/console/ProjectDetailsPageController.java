package ua.com.goit.gojava7.kickstarter.controller.console;

import ua.com.goit.gojava7.kickstarter.domain.Project;

public class ProjectDetailsPageController extends AbstractPageController<Project> {

    @Override
    protected void handle() {        
        request.setQuestions(storageFactory.getQuestionsDAO().getByProject(request.getId()));
        request.setBalanceSum(storageFactory.getPaymentDAO().getSum(request.getId()));
        printer.showProjectDetails(request);    
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
