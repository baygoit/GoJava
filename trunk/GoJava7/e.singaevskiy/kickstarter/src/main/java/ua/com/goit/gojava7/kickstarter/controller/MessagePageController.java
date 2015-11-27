package ua.com.goit.gojava7.kickstarter.controller;

import java.io.IOException;

import ua.com.goit.gojava7.kickstarter.domain.Project;
import ua.com.goit.gojava7.kickstarter.domain.Question;

public class MessagePageController extends AbstractPageController<Project> {

    @Override
    protected void handle() {
        printer.showShortProject(request);
        printer.showMessageRequest();
        

    }

    @Override
    protected boolean isDone() {
        try {
            String text = inputReader.readLine();
            Question message = new Question(request.getId(), text, "");
            this.storageFactory.getQuestionsDAO().add(message);
            
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}
