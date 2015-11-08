/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.goit.salivon.handlers;

import ua.com.goit.salivon.handlers.HendlingError;

/**
 *
 * @author salivon.i
 */
public class HendlingErrorProjectScene implements HendlingError {

    @Override
    public boolean validate(String inConsole) {

        try {
            int n = Integer.parseInt(inConsole);
            if (n == 0) {
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
