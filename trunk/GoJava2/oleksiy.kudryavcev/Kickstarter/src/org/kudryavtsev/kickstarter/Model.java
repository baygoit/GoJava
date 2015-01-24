package org.kudryavtsev.kickstarter;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<String> categoriesList;

    public Model() {
        setCategoriesList(new ArrayList<String>());
    }

    public void init() {
        getCategoriesList().add("Sport");
        getCategoriesList().add("Technology");
        getCategoriesList().add("Science");
    }

    public List<String> getCategoriesList() {
        return categoriesList;
    }

    private void setCategoriesList(List<String> categoriesList) {
        this.categoriesList = categoriesList;
    }
}
