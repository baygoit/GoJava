package com.gojava.launch;

import java.util.Scanner;

import com.gojava.projects.CategoryStorage;
import com.gojava.projects.ProjectManager;
import com.gojava.projects.ProjectStorage;

public class Launch {

    public static void main(String[] args) {
        Quote quote = new Quote();
        quote.displayQuote();

        ProjectStorage projectStorage = new ProjectStorage();
        CategoryStorage categoryStorage = new CategoryStorage();
        ProjectManager manager = new ProjectManager(categoryStorage, projectStorage);

        manager.addCategory("Sport", 1);
        manager.addCategory("Car", 2);
        manager.addCategory("Devices", 3);
        manager.displayCategories();
        
        Scanner in = new Scanner(System.in);
        int categoryNumber = in.nextInt();
        manager.displaySpecificProjectCategory(categoryNumber);
        
        manager.addProjects("Bicycle", "Bicycle description", 10000, 100, 10, "History", "Link on video", "Questions and answers", 1);
        manager.addProjects("Snowboard", "Snowboard description", 2000, 200, 20, "History", "Link on video", "Questions and answers", 1);
        manager.addProjects("BMW X3", "BMW X3 description", 30000, 3000, 300, "History", "Link on video", "Questions and answers", 2);
        manager.addProjects("Audi Q5", "Audi Q5 description", 40000, 400, 40, "History", "Link on video", "Questions and answers", 2);
        manager.addProjects("Laptop", "Laptop description", 500, 50, 50, "History", "Link on video", "Questions and answers", 3);
        manager.addProjects("Mobile phone", "Mobile phone description", 60, 60, 6, "History", "Link on video", "Questions and answers", 3);
        manager.displayProjects(categoryNumber);
        
        Scanner in1 = new Scanner(System.in);
        int projectNumber = in1.nextInt();
        manager.displaySpecificProject(categoryNumber, projectNumber);

        
        
    }

}
