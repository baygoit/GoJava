package org.kudryavtsev.kickstarter;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<Project> categoriesList;

    public Model() {
        setCategoriesList(new ArrayList<Project>());
    }

    public void init() {
        // categoriesList.add("Sport");
        // categoriesList.add("Technology");
        // categoriesList.add("Science");
        categoriesList.add(new Project("Sport", "FutureForward",
                "FutureForward is an innovative training project", 4, 200, 45));
        categoriesList.add(new Project("Technology", "APEX Wallet",
                "The Apex is a slim aluminum wallet with RFID protection",
                56400, 4000, 12));
        categoriesList.add(new Project("Science", "EVB",
                        "EVB: Replace the Brain and Sensors in your LEGO® MINDSTORMS EV3 with a BeagleBone Black",
                        36000, 8000, 1));
    }

    public List<Project> getCategoriesList() {
        return categoriesList;
    }

    private void setCategoriesList(ArrayList<Project> arrayList) {
        this.categoriesList = arrayList;
    }
}
