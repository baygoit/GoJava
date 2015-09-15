package com.tyomsky.kickstarter.dao;

import com.tyomsky.kickstarter.domain.Category;
import com.tyomsky.kickstarter.domain.Project;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@ContextConfiguration(locations = "classpath:spring-test-config/application-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ProjectDAOTest {

    @Autowired
    ProjectDAO projectDAO;

    @Test
    @Transactional
    @Rollback
    public void testSave() {
        Project project = new Project();
        project.setName("project1");
        project.setDescription("project1 desc");
        Category category = new Category("category with project 1");
        project.setCategory(category);

        projectDAO.save(project);

        Project actualProject = projectDAO.get(project.getId());
        Category actualCategory = actualProject.getCategory();

        assertEquals(project.getName(), actualProject.getName());
        assertEquals(category.getName(), actualCategory.getName());
    }

    @Test
    @Transactional
    @Rollback
    public void testGet() {
        Project project = new Project();
        project.setName("project1");
        project.setDescription("project1 desc");
        Category category = new Category("category with project 1");
        project.setCategory(category);

        projectDAO.save(project);

        Project actualProject = projectDAO.get(project.getId());
        Category actualCategory = actualProject.getCategory();

        assertEquals(project.getName(), actualProject.getName());
        assertEquals(category.getName(), actualCategory.getName());
    }

    @Test
    @Transactional
    @Rollback
    public void testUpdate() {
        Project project = new Project();
        project.setName("project1");
        project.setDescription("desc");
        Category category1 = new Category("Category");
        project.setCategory(category1);

        projectDAO.save(project);

        Category newCategory = new Category("name of new category");
        project.setCategory(newCategory);
        projectDAO.merge(project);

        projectDAO.get(project.getId());

        assertEquals(project.getCategory().getName(), newCategory.getName());
    }

    @Test
    @Transactional
    @Rollback
    public void testGetByCategory() {
        Category category = new Category("category1");
        Project project1 = new Project("project1", "desc of project 1", category);
        Project project2 = new Project("project2", "desc of project 2", category);
        projectDAO.save(project1);
        projectDAO.save(project2);

        List<Project> projects = projectDAO.getListByCategory(category);

        assertTrue(projects.contains(project1));
        assertTrue(projects.contains(project2));
    }




}
