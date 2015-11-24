package ua.com.goit.gojava7.kickstarter.controller;

import java.io.IOException;

import ua.com.goit.gojava7.kickstarter.beans.Project;
import ua.com.goit.gojava7.kickstarter.beans.Question;

public class MessagePageController extends PageController<Project> {

    @Override
    protected void handle() {
        page.showShortProject(request);
        page.showMessageRequest();
        

    }

    @Override
    protected boolean isDone() {
        try {
            String text = inputReader.readLine();
            Question message = new Question(request, text, "");
            this.storageFactory.getQuestionsDAO().add(message);
            
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}
