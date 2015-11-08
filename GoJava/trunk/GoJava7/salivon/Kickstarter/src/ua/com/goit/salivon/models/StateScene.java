/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.goit.salivon.models;

/**
 *
 * @author Salivon Ivan
 */
public class StateScene {

    public static final String WELCOME_SCENE = "WELCOME";
    public static final String CATEGORY_SCENE = "CATEGORY";
    public static final String PROJECT_SCENE = "PROJECT";
    private String currentState;
    private boolean error;

    public StateScene() {
        this.currentState = WELCOME_SCENE;
        error = false;
    }

    public String getCurrentState() {
        return currentState;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
    

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

}
