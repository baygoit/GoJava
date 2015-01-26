package com.gojava.launch;

import java.util.Scanner;

import com.gojava.projects.CategoryStorage;
import com.gojava.projects.ProjectManager;
import com.gojava.projects.ProjectStorage;

public class Launch {

    public static void main(String[] args) {
        Quote quote = new Quote();
        quote.displayQuote();

        ProjectManager manager = new ProjectManager();

        manager.displayCategories();

        Scanner in = new Scanner(System.in);
        int categoryNumber = in.nextInt();
        manager.displayProjects(categoryNumber);

        in = new Scanner(System.in);
        int projectNumber = in.nextInt();

        while(true){
            if (projectNumber == 0) {
                manager.displayCategories();
                in = new Scanner(System.in);
                categoryNumber = in.nextInt();
                manager.displayProjects(categoryNumber);
            } else {
                manager.displaySpecificProject(categoryNumber, projectNumber);
            }
        }        
        

    }

}
