package com.gojava.launch;

import java.util.Scanner;

import com.gojava.projects.CategoriesList;
import com.gojava.projects.ProjectCategory;

public class Launch {

    public static void main(String[] args) {
        Quote quote = new Quote();
        quote.displayQuote();

        CategoriesList categoriesList = new CategoriesList();
        categoriesList.dispalyProjectCategories();
        
        System.out.println("Choose number of categories");
        
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        categoriesList.displaySpecificProjectCategory(a);
        
        ProjectCategory projectCategory = categoriesList.getChhosedProjectCategory();
        System.out.println("Project name = " + projectCategory.getName());
        projectCategory.dispalyProjectList();
        
    }   

}
