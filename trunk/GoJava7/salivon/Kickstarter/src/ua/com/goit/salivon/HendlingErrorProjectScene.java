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
public class HendlingErrorProjectScene implements HendlingError {

    HendlingError hendError = new HendlingErrorQuit();

    @Override
    public boolean validate(String inConsole) {

        try {
            int n = Integer.parseInt(inConsole);
            if (n == 0 || hendError.validate(inConsole)) {
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
