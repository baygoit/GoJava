package com.vladik.dao.memory;

import java.util.ArrayList;
import java.util.List;

import com.vladik.model.Category;
import com.vladik.model.Project;
import com.vladik.dao.AbstractProjectDao;

public class ProjectDaoMemoryImpl extends AbstractProjectDao {

    private List<Project> projects = new ArrayList<>();

    public ProjectDaoMemoryImpl() {
        Project project1 = new Project();
        project1.setTitle("Project 1");
        project1.setBriefDescription("Brief description 1");
        project1.setRequiredSum(30_000);
        project1.setDeadline(7, 12, 2016);
        project1.setUniqueID(1);
        project1.setCategoryID(1);

        Project project2 = new Project();
        project2.setTitle("Project 2");
        project2.setBriefDescription("Brief description 2");
        project2.setRequiredSum(45_0001);
        project2.setDeadline(8, 12, 2016);
        project2.setUniqueID(2);
        project2.setCategoryID(1);

        Project project3 = new Project();
        project3.setTitle("Project 3");
        project3.setBriefDescription("Brief description 3");
        project3.setRequiredSum(10_000);
        project3.setDeadline(11, 12, 2016);
        project3.setUniqueID(3);
        project3.setCategoryID(2);

        Project project4 = new Project();
        project4.setTitle("Project 4");
        project4.setBriefDescription("Brief description 4");
        project4.setRequiredSum(42_000);
        project4.setDeadline(14, 12, 2016);
        project4.setUniqueID(4);
        project4.setCategoryID(3);

        Project project5 = new Project();
        project5.setTitle("Project 5");
        project5.setBriefDescription("Brief description 5");
        project5.setRequiredSum(88_000);
        project5.setDeadline(18, 12, 2016);
        project5.setUniqueID(5);
        project5.setCategoryID(3);

        add(project1);
        add(project2);
        add(project3);
        add(project4);
        add(project5);
    }

    @Override
    public void add(Project project) {
        projects.add(project);

    }

    @Override
    public void remove(Project project) {
        projects.remove(project);

    }

    @Override
    public List<Project> getAll() {
        return projects;
    }

    @Override
    public int getSize() {
        return projects.size();
    }

    @Override
    public List<Project> getProjectsFromCategory(Category category) {
        List<Project> projectsFromCategory = new ArrayList<>();

        for (Project project : projects) {
            if (project.getCategoryID() == category.getUniqueID()) {
                projectsFromCategory.add(project);
            }
        }
        return projectsFromCategory;
    }
}
