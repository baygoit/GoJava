/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.goit.salivon;

/**
 *
 * @author salivon.i
 */
public class HendlingErrorCategoryScene implements HendlingError {

    HendlingError hendError = new HendlingErrorQuit();
    StoreProjects projects;

    public HendlingErrorCategoryScene(StoreProjects projects) {
        this.projects = projects;
    }

    @Override
    public boolean validate(String inConsole) {
        try {
            int n = Integer.parseInt(inConsole);
            int iu = projects.getProjects().size();
            if ((n - 1 >= 0 && n - 1 < projects.getProjects().size())
                    || hendError.validate(inConsole) || n == 0) {
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException e) {
            if (inConsole.equalsIgnoreCase("q")) {
            System.exit(0);
        }
            return false;
        }

    }

}
