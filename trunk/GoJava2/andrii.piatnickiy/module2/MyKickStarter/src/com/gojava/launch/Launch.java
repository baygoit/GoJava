package com.gojava.launch;

import java.util.ArrayList;

import com.gojava.projects.CategoriesList;

public class Launch {

    public static void main(String[] args) {
        Quote quote = new Quote();
        quote.displayQuote();

        CategoriesList categoriesList = new CategoriesList();
        categoriesList.addCategoryList();
        categoriesList.addCategoryList();
        categoriesList.addCategoryList();
        categoriesList.dispalyProjectCategories();

    }

}
