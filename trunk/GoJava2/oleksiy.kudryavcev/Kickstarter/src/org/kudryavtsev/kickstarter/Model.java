package org.kudryavtsev.kickstarter;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private View view;
    private int totalProjects;
    private List<String> categoriesList;

    public Model() {
        // System.out.println("Model created");
        setCategoryList(new ArrayList<String>());
    }

    public void addView(View view) {
        this.view = view;
        // System.out.println("Model added view");
    }

    public void init(int i) {
        totalProjects = i;
        getCategoryList().add("Sport");
        getCategoryList().add("Technology");
        getCategoryList().add("Science");
    }

    /**
     * @return the categoriesList
     */
    public List<String> getCategoryList() {
        return categoriesList;
    }

    /**
     * @param categoriesList the categoriesList to set
     */
    private void setCategoryList(List<String> categoriesList) {
        this.categoriesList = categoriesList;
    }

}
