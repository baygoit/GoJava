/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.goit.gojava7.salivon.handlers;

import ua.com.goit.gojava7.salivon.handlers.HandlerError;

/**
 *
 * @author salivon.i
 */
public class HandlerErrorProjectScene extends HandlerError {

    @Override
    public boolean validate(String inDate) {

        try {
            int n = Integer.parseInt(inDate);

            return n == 0 || n == 1 || n == 2;

        } catch (NumberFormatException e) {
            if (inDate.equalsIgnoreCase("q")) {
                exit();
            }
            return false;
        }

    }

}
