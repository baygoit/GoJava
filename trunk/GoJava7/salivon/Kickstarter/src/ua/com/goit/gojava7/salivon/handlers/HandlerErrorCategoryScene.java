/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.goit.gojava7.salivon.handlers;

import java.util.List;
import ua.com.goit.gojava7.salivon.beans.Category;
import ua.com.goit.gojava7.salivon.handlers.HandlerError;
import ua.com.goit.gojava7.salivon.beans.Project;
import ua.com.goit.gojava7.salivon.state.State;
import ua.com.goit.gojava7.salivon.stores.StoreCategories;
import ua.com.goit.gojava7.salivon.stores.StoreProjects;

/**
 *
 * @author salivon.i
 */
public class HandlerErrorCategoryScene extends HandlerError {

    private List<Category> categories = StoreCategories.getCategories();
    private List<Project> projects = StoreProjects.getProjects();

    @Override
    public boolean validate(String inDate) {
        try {
            int n = Integer.parseInt(inDate);
            if (n == 0) {
                return true;
            }

            return n - 1 >= 0 && n - 1 < projects.size() && hasProject(n);

        } catch (NumberFormatException e) {
            if (inDate.equalsIgnoreCase("q")) {
                exit();
            }
            return false;
        }

    }

    private boolean hasProject(int num) {
        Project p = projects.get(num - 1);
        if (p.getIdCategory() == State.getIndexCategory()) {
            return true;
        } else {
            return false;
        }
    }

}
