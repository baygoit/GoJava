/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.goit.gojava7.salivon.view;

import java.util.Scanner;
import ua.com.goit.gojava7.salivon.state.CategoryState;
import ua.com.goit.gojava7.salivon.state.ProjectState;
import ua.com.goit.gojava7.salivon.state.State;
import ua.com.goit.gojava7.salivon.state.WelcomeState;
import ua.com.goit.gojava7.salivon.stores.StoreCategories;
import ua.com.goit.gojava7.salivon.stores.StoreProjects;

/**
 *
 * @author Salivon Ivan
 */
public class Console {

    private State welcomState;
    private State categoryState;
    private State projectState;
    private State currentState;
    private String inData;
    private Scanner scan;

    public Console() {
        welcomState = new WelcomeState();
        categoryState = new CategoryState();
        projectState = new ProjectState();
        scan = new Scanner(System.in);
        currentState = welcomState;
    }

    public String getInData() {
        return inData;
    }

    public State getWelcomState() {
        return welcomState;
    }

    public State getCategoryState() {
        return categoryState;
    }

    public State getProjectState() {
        return projectState;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    void outputContentState() {
        currentState.outputContentState();
    }

    void verification() {
        currentState.verification(this);
    }

    public void execute() {
        outputContentState();
        verification();
        execute();
    }

}
