package org.kudryavtsev.kickstarter;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<Project> categoriesList;

    public Model() {
        setCategoriesList(new ArrayList<Project>());
    }

    public void init() {
        categoriesList.add(new Project("Sport", "FutureForward",
                "FutureForward is an innovative training project", 4, 200, 45));
        categoriesList.add(new Project("Technology", "APEX Wallet",
                "The Apex is a slim aluminum wallet with RFID protection",
                56400, 4000, 12));
        categoriesList
                .add(new Project(
                        "Science",
                        "EVB",
                        "EVB: Replace the Brain and Sensors in your LEGO® MINDSTORMS EV3 with a BeagleBone Black",
                        36000, 8000, 1));
        categoriesList.add(new Project("Sport", "U23",
                "Support Team Canada U23 in their quest for Gold!", 5500, 5000,
                5));
        categoriesList
                .add(new Project(
                        "Technology",
                        "Arduino",
                        "We love Arduino and we love space exploration. So we decided to combine them and let people run their own space experiments!",
                        10600, 35000, 4));
        categoriesList
                .add(new Project(
                        "Science",
                        "Makeblock",
                        "Makeblock is an aluminum extrusion based construct platform that can be used to build robots",
                        186000, 30000, 2));
    }

    public List<Project> getCategoriesList() {
        return categoriesList;
    }

    private void setCategoriesList(ArrayList<Project> arrayList) {
        this.categoriesList = arrayList;
    }
}
