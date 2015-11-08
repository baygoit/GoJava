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
public class HendlingErrorWelcomScene implements HendlingError {

    HendlingError hendError = new HendlingErrorQuit();
    StoreCategories categories;

    public HendlingErrorWelcomScene(StoreCategories categories) {
        this.categories = categories;
    }

    @Override
    public boolean validate(String inConsole) {
        try {

            int n = Integer.parseInt(inConsole);
            if ((n - 1 >= 0 && n - 1 < categories.getCategories().size())
                    || hendError.validate(inConsole)) {
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
