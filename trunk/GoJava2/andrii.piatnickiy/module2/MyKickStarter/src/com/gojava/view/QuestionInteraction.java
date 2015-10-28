package com.gojava.view;

import java.util.Scanner;

import com.gojava.projects.Project;
import com.gojava.projects.ProjectStorage;

public class QuestionInteraction implements Interactionable{
    Menu menu;
    ProjectStorage projectStorage;
    
    public QuestionInteraction(Menu menu, ProjectStorage projectStorage) {
        this.menu = menu;
        this.projectStorage = projectStorage;
    }

    @Override
    public String description() {
        return "Ask a question";
    }

    @Override
    public void displayInteractionSet() {
        question();
    }
    
    private void question() {
        String questionMessage = "Please, enter your question";
        System.out.println(questionMessage);
        Scanner scanner = new Scanner(System.in);
        String question = scanner.nextLine();
        Project project = projectStorage.getSpecificProject(menu.currentCategory, menu.currentProject);
        project.setQuestionsAndAnswers(question + "\n" + project.getQuestionsAndAnswers());;
    }
}
