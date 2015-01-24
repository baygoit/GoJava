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
        
        manager.addProject("Bicycle", "Bicycle description", 10000, 100, 30, 1);
        manager.addProject("Snowboard", "Snowboard description", 2000, 200, 20, 1);
        manager.addProject("BMW X3", "BMW X3 description", 30000, 3000, 300, 2);
        manager.addProject("Audi Q5", "Audi Q5 description", 40000, 400, 40, 2);
        manager.addProject("Laptop", "Laptop description", 500, 50, 50, 3);
        manager.addProject("Mobile phone", "Mobile phone description", 60, 60, 6, 3);
        manager.displayProjects(categoryNumber);
    }

}
