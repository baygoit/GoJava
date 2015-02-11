package com.gojava.view;

import java.util.ArrayList;

public class ClientInteraction {
    public ClientInteraction() {
        add();
    }

    ArrayList<Interactionable> interactions = new ArrayList<>();

    public void add() {
        interactions.add(new InvestInteraction());
        interactions.add(new QuestionInteraction());
    }

}
