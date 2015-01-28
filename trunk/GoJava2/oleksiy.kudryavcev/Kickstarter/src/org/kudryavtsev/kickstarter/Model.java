package org.kudryavtsev.kickstarter;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<Project> projectsList;
    private List<Category> categoriesList;

    public Model() {
        setProjectsList(new ArrayList<Project>());
        categoriesList = new ArrayList<Category>();
    }

    public void init() {
        categoriesList.add(new Category("Sport", "Sport projects"));
        categoriesList.add(new Category("Technology", "Technology projects"));
        categoriesList.add(new Category("Science", "Science projects"));
        
        categoriesList.get(0).getProjectsList().add(new Project("FutureForward", "FutureForward is an innovative training project", 4, 200, 45));
        categoriesList.get(1).getProjectsList().add(new Project("APEX Wallet", "The Apex is a slim aluminum wallet with RFID protection", 56400, 4000, 12));
        categoriesList.get(2).getProjectsList().add(new Project("EVB", "EVB: Replace the Brain and Sensors in your LEGO® MINDSTORMS EV3 with a BeagleBone Black", 36000, 8000, 1));
        categoriesList.get(0).getProjectsList().add(new Project("U23", "Support Team Canada U23 in their quest for Gold!", 5500, 5000, 5));
        categoriesList.get(1).getProjectsList().add(new Project("Arduino", "We love Arduino and we love space exploration. So we decided to combine them and let people run their own space experiments!", 10600, 35000, 4));
        categoriesList.get(2).getProjectsList().add(new Project("Makeblock", "Makeblock is an aluminum extrusion based construct platform that can be used to build robots", 186000, 30000, 2));
    }

    public List<Project> getProjectsList() {
        return projectsList;
    }

    public List<Category> getCategoriesList() {
        return categoriesList;
    }
    
    private void setProjectsList(ArrayList<Project> arrayList) {
        this.projectsList = arrayList;
    }
}
