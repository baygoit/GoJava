package ua.com.goit.gojava7.salivon.context;

import java.util.Scanner;
import ua.com.goit.gojava7.salivon.state.CategoryState;
import ua.com.goit.gojava7.salivon.state.PaymentState;
import ua.com.goit.gojava7.salivon.state.ProjectState;
import ua.com.goit.gojava7.salivon.state.State;
import ua.com.goit.gojava7.salivon.state.WelcomeState;
import ua.com.goit.gojava7.salivon.stores.StoreCategories;
import ua.com.goit.gojava7.salivon.stores.StoreProjects;

public class Console {

    private State currentState = new WelcomeState();
    private String inData;

    public String getInData() {
        return inData;
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
