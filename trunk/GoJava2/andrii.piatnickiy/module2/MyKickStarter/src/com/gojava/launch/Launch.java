package com.gojava.launch;

import java.util.Scanner;

import com.gojava.projects.CategoryStorage;
import com.gojava.projects.Project;
import com.gojava.projects.Category;
import com.gojava.projects.ProjectManager;
import com.gojava.projects.ProjectStorage;

public class Launch {

    public static void main(String[] args) {
        Quote quote = new Quote();
        quote.displayQuote();

        ProjectStorage projectStorage = new ProjectStorage();
        CategoryStorage categoryStorage = new CategoryStorage();
        ProjectManager manager = new ProjectManager(categoryStorage,
                projectStorage);

        manager.addCategory("Sport", 1);
        manager.addCategory("Health", 2);
        manager.addCategory("Devices", 3);

        manager.displayCategories();
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        manager.displaySpecificProjectCategory(a);

        // manager.addProject();
        // manager.displayProjects();

        // CategoriesList categoriesList = new CategoriesList();
        // categoriesList.dispalyProjectCategories();
        //
        // System.out.println("Choose number of categories");
        //
        // Scanner in = new Scanner(System.in);
        // int a = in.nextInt();
        // categoriesList.displaySpecificProjectCategory(a);
        //
        // Category projectCategory =
        // categoriesList.getChhosedProjectCategory();
        // System.out.println("Project name = " + projectCategory.getName());
        // projectCategory.dispalyProjectList();

    }

}
