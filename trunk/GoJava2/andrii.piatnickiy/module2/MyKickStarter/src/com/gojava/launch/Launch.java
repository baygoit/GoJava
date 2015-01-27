package com.gojava.launch;

import java.util.Scanner;

import com.gojava.input.Scan;
import com.gojava.projects.CategoryStorage;
import com.gojava.projects.ProjectManager;
import com.gojava.projects.ProjectStorage;

public class Launch {

    public static void main(String[] args) {
        int categoryNumber;
        int projectNumber;
        Scan scan = new Scan();
        Quote quote = new Quote();
        quote.displayQuote();
        
        ProjectManager manager = new ProjectManager();

        manager.displayCategories();

        categoryNumber = scan.inputInt();
        manager.displayProjects(categoryNumber);

        projectNumber = scan.inputInt();
        while (true) {
            if (projectNumber == 0) {
                manager.displayCategories();
                categoryNumber = scan.inputInt();
                manager.displayProjects(categoryNumber);
            } else {
                manager.displaySpecificProject(categoryNumber, projectNumber);
            }
        }

    }

}
