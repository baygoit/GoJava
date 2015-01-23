package com.gojava.launch;

import com.gojava.projects.CategoriesList;

public class Launch {

    public static void main(String[] args) {
        Quote quote = new Quote();
        quote.displayQuote();

        CategoriesList categoriesList = new CategoriesList();
        categoriesList.dispalyProjectCategories();
    }

}
