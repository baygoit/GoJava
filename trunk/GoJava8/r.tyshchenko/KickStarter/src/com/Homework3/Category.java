package com.Homework3;

import java.util.Arrays;

/**
 * Created by roman on 06.03.16.
 */
public class Category {
    public Category(String name) {
        this.name = name;
    }

    private  String name;

    public String getName() {
        return  name;
    }
    /*public static void categoryBuilder() {
        Category category1 = new Category("IT");
        Category category2 = new Category("Cars");
        Category category3 = new Category("Electricity");

        Categories categories = new Categories();
        categories.add(category1);
        categories.add(category2);
        categories.add(category3);
        System.out.println(Arrays.toString(categories.getCategories()));
    }*/

}
