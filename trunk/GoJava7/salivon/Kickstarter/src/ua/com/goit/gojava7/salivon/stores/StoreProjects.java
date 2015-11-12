/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.goit.gojava7.salivon.stores;

import java.util.ArrayList;
import java.util.List;
import ua.com.goit.gojava7.salivon.beans.Project;

/**
 *
 * @author salivon.i
 */
public class StoreProjects {

    private static List<Project> projects = new ArrayList<>();

    static {
        projects.add(new Project("Circle", 10, 1));
        projects.add(new Project("Elips", 17, 1));
        projects.add(new Project("Line", 4, 1));
        projects.add(new Project("The Man with Ten Thousand Eyes", 241, 2));
        projects.add(new Project("SkyHeart Book I: The Star Seed", 258, 2));
        projects.add(new Project("Deeds Not Words", 541, 2));
        projects.add(new Project("Failsafe", 1025, 3));
        projects.add(new Project("Centauri Saga", 3527, 3));

    }

    public static List<Project> getProjects() {
        return projects;
    }

}
