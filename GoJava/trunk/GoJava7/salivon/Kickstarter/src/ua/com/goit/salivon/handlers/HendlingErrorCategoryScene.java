/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.goit.salivon.handlers;

import ua.com.goit.salivon.handlers.HendlingError;
import ua.com.goit.salivon.beans.Project;
import ua.com.goit.salivon.stores.StoreProjects;

/**
 *
 * @author salivon.i
 */
public class HendlingErrorCategoryScene implements HendlingError {

    private StoreProjects projects;
    private int idCategory;

    public HendlingErrorCategoryScene(StoreProjects projects, int indexCategory) {
        this.projects = projects;
        this.idCategory = indexCategory - 1;
    }

    @Override
    public boolean validate(String inConsole) {
        try {
            int n = Integer.parseInt(inConsole);
            if (n==0) {
                return true;
            }
            if (n-1 >= 0 && n -1< projects.getProjects().size()&&hasProject(n)) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException e) {
            if (inConsole.equalsIgnoreCase("q")) {
                return true;
            }
            return false;
        }

    }

    private boolean hasProject(int num) {
        Project p = projects.getProject(num - 1);
        if (p.getIdCategory() == idCategory) {
            return true;
        } else {
            return false;
        }
    }

}
