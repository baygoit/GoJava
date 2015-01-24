package com.gojava.launch;

import java.util.ArrayList;
import java.util.Scanner;

import com.gojava.projects.CategoriesList;
import com.gojava.projects.CategoryStorage;
import com.gojava.projects.Project;
import com.gojava.projects.Category;
import com.gojava.projects.ProjectManager;
import com.gojava.projects.ProjectStorage;

public class Launch {

    public static void main(String[] args) {
        ProjectStorage projectStorage = new ProjectStorage();
        CategoryStorage categoryStorage = new CategoryStorage();
        ProjectManager manager = new ProjectManager(categoryStorage, projectStorage);
        
         manager.addCategory("Category", 1);
         manager.displayCategories();

        Quote quote = new Quote();
        quote.displayQuote();

        CategoriesList categoriesList = new CategoriesList();
        categoriesList.dispalyProjectCategories();

        System.out.println("Choose number of categories");

        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        categoriesList.displaySpecificProjectCategory(a);

        Category projectCategory = categoriesList.getChhosedProjectCategory();
        System.out.println("Project name = " + projectCategory.getName());
        projectCategory.dispalyProjectList();

    }

}
