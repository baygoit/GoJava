package com.gojava.view;

import java.util.ArrayList;


import com.gojava.projects.ProjectStorage;

public class ClientInteraction {
    private Menu menu;
    private ProjectStorage projectStorage;
    public ClientInteraction(Menu menu, ProjectStorage projectStorage) {
        this.menu = menu;
        this.projectStorage = projectStorage;
        interactions.add(new InvestInteraction(menu, projectStorage));
        interactions.add(new QuestionInteraction(menu, projectStorage));
    }

    ArrayList<Interactionable> interactions = new ArrayList<>();

  
}
