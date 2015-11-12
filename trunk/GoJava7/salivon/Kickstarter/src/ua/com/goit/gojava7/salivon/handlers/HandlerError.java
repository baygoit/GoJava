/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.goit.gojava7.salivon.handlers;

import ua.com.goit.gojava7.salivon.state.State;

/**
 *
 * @author salivon.i
 */
public abstract class HandlerError {

    public abstract boolean validate(String outConsole);

    void exit() {
        System.out.println("Goodbye my LORD!");
        State.getScan().close();
        Runtime.getRuntime().exit(0);
    }
}
