/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.goit.salivon.handlers;

import ua.com.goit.salivon.handlers.HendlingError;
import ua.com.goit.salivon.stores.StoreCategories;

/**
 *
 * @author salivon.i
 */
public class HendlingErrorWelcomScene implements HendlingError {

    StoreCategories categories;

    public HendlingErrorWelcomScene(StoreCategories categories) {
        this.categories = categories;
    }

    @Override
    public boolean validate(String inConsole) {
        if (inConsole==null) {
            return true;
        }
        try {

            int n = Integer.parseInt(inConsole);
            if (n - 1 >= 0 && n - 1 < categories.getCategories().size()) {
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

}
