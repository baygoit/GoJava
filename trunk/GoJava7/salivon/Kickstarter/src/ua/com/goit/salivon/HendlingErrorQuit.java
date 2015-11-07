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
public class HendlingErrorQuit implements HendlingError {

    @Override
    public boolean validate(String outConsole) {
        if (outConsole.equalsIgnoreCase("q")) {
            return true;
        } else {
            return false;
        }
    }

}
