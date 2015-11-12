/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.goit.gojava7.salivon.stores;

import java.util.ArrayList;
import java.util.List;
import ua.com.goit.gojava7.salivon.beans.Category;

/**
 *
 * @author Оля
 */
public class StoreCategories {

    static List<Category> categories = new ArrayList<>();

  static   {
        categories.add(new Category("Art"));
        categories.add(new Category("Comics"));
        categories.add(new Category("Games"));
    }

    public static List<Category> getCategories() {
        return categories;
    }

}
