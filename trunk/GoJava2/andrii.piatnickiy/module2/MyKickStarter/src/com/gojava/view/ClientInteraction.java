package com.gojava.view;

import java.util.ArrayList;

import com.gojava.projects.ProjectStorage;

public class ClientInteraction {
    Menu menu;
    ProjectStorage projectStorage;
    public ClientInteraction(Menu menu, ProjectStorage projectStorage) {
        this.menu = menu;
        this.projectStorage = projectStorage;
        interactions.add(new InvestInteraction(menu, projectStorage));
        interactions.add(new QuestionInteraction());
    }

    ArrayList<Interactionable> interactions = new ArrayList<>();

  
}
