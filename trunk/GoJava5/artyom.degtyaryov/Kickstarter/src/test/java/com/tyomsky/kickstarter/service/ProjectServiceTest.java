package com.tyomsky.kickstarter.service;

import com.tyomsky.kickstarter.dao.ProjectDAO;
import com.tyomsky.kickstarter.domain.Category;
import com.tyomsky.kickstarter.domain.Project;
import com.tyomsky.kickstarter.service.impl.ProjectServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ProjectServiceTest {

    @Mock
    ProjectDAO projectDAO;

    @InjectMocks
    ProjectServiceImpl projectService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenGetProjectsByCategory_thenReturnProjectsByCategoryProperty() throws Exception {
        Category category = new Category();
        category.setId(1);
        category.setName("Games");

        Project project1 = new Project(1, "proj1", "desc1", category);
        Project project2 = new Project(2, "proj2", "desc2", category);

        List<Project> expectedProjects = Arrays.asList(project1, project2);

        when(projectDAO.getListByCategory(category)).thenReturn(expectedProjects);

        List<Project> actualProjects = projectService.getProjectsByCategory(category);

        verify(projectDAO, times(1)).getListByCategory(category);

        assertArrayEquals(expectedProjects.toArray(), actualProjects.toArray());
    }

    @Test
    public void whenGetProjectById_thenReturnProject() throws Exception {
        Category category = new Category();
        category.setId(1);
        category.setName("Games");

        Project expectedProject = new Project(1, "proj1", "desc1", category);

        when(projectDAO.get(1)).thenReturn(expectedProject);

        Project actualProject = projectService.getProjectById(1);

        verify(projectDAO, times(1)).get(1);
        assertEquals(expectedProject, actualProject);
    }
}