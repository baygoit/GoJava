/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.goit.salivon;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author salivon.i
 */
public class StoreProjects {

    private List<Project> projects = new ArrayList<>();

    {
        projects.add(new Project("Circle", 10, 0));
        projects.add(new Project("Elips", 17, 0));
        projects.add(new Project("Line", 4, 0));
        projects.add(new Project("The Man with Ten Thousand Eyes", 241, 1));
        projects.add(new Project("SkyHeart Book I: The Star Seed", 258, 1));
        projects.add(new Project("Deeds Not Words", 541, 1));
        projects.add(new Project("Failsafe", 1025, 2));
        projects.add(new Project("Centauri Saga", 3527, 2));
        
    }

    public void addProject(Project project) {
        projects.add(project);
    }

    public void removeProject(Project project) {
        projects.remove(project);
    }

    public Project getProject(int index) {
        return projects.get(index);
    }

    public List<Project> getProjects() {
        return projects;
    }
    
    
}
