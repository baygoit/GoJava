package goit.vh.kickstarter.mvc.view;

import java.util.Scanner;

import goit.vh.kickstarter.Output;
import goit.vh.kickstarter.model.Project;
import goit.vh.kickstarter.mvc.model.ProjectModel;

/**
 * Created by Viktor on 14.07.2015.
 */
public class ProjectView {
    private String input;
    private Output output;

    public ProjectView(Output output){
        this.output = output;
    }

    public void renderList(ProjectModel projectModel) {

        Project[] projects = projectModel.getListOfProjectses();
        for (int i = 0; i < projects.length; i++) {
            output.println(String.valueOf(i + 1) + " " + projects[i].getName());
        }
    }

     public void render(ProjectModel projectModel) {

        Project[] projects = projectModel.getListOfProjectses();
        for (int i = 0; i < projects.length; i++) {
            output.println(String.valueOf(i + 1) + " " + projects[i].getName());
        }
    }
     
     public void readUserInput() {
         Scanner scanner = new Scanner(System.in);
         String userInput = scanner.next();
         this.input = userInput;
     }


     public void setInput(String input) {
        this.input = input;
     }

     public String getInput() {
         return this.input;
     }

}
