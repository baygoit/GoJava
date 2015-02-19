package org.kudryavtsev.kickstarter.data;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private List<Project> projectsList;
    private List<Category> categoriesList;

    public Model() {
        setProjectsList(new ArrayList<Project>());
        setCategoriesList(new ArrayList<Category>());
    }

    public void init() {
        getCategoriesList().add(new Category("Sport", "Sport projects"));
        getCategoriesList().add(new Category("Technology", "Technology projects"));
        getCategoriesList().add(new Category("Science", "Science projects"));

        getCategoriesList()
                .get(0)
                .getProjectsList()
                .add(new Project("FutureForward",
                        "FutureForward is an innovative training project", 4, 200, 45));
        getCategoriesList()
                .get(1)
                .getProjectsList()
                .add(new Project("APEX Wallet",
                        "The Apex is a slim aluminum wallet with RFID protection", 56400, 4000, 12));
        getCategoriesList()
                .get(2)
                .getProjectsList()
                .add(new Project(
                        "EVB",
                        "EVB: Replace the Brain and Sensors in your LEGO® MINDSTORMS EV3 with a BeagleBone Black",
                        36000, 8000, 1));
        getCategoriesList()
                .get(0)
                .getProjectsList()
                .add(new Project("U23", "Support Team Canada U23 in their quest for Gold!", 5500,
                        5000, 5));
        getCategoriesList()
                .get(1)
                .getProjectsList()
                .add(new Project(
                        "Arduino",
                        "We love Arduino and we love space exploration. So we decided to combine them and let people run their own space experiments!",
                        10600, 35000, 4));
        getCategoriesList()
                .get(2)
                .getProjectsList()
                .add(new Project(
                        "Makeblock",
                        "Makeblock is an aluminum extrusion based construct platform that can be used to build robots",
                        186000, 30000, 2));
    }

    public List<Category> getCategoriesList() {
        return categoriesList;
    }

    public List<Project> getProjectsList() {
        return projectsList;
    }

    public void setProjectsList(ArrayList<Project> arrayList) {
        this.projectsList = arrayList;
    }

    public void setCategoriesList(List<Category> categoriesList) {
        this.categoriesList = categoriesList;
    }
}
