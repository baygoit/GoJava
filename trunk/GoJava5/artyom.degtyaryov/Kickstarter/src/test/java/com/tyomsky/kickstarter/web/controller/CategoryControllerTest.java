package com.tyomsky.kickstarter.web.controller;

import com.tyomsky.kickstarter.domain.Category;
import com.tyomsky.kickstarter.domain.Project;
import com.tyomsky.kickstarter.service.CategoryService;
import com.tyomsky.kickstarter.service.ProjectService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-test-config/testContextForControllers.xml", "classpath:spring/spring-web-servlet.xml"})
@WebAppConfiguration
public class CategoryControllerTest {

    @Autowired private CategoryService categoryServiceMock;
    @Autowired private ProjectService projectServiceMock;
    @Autowired private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        Mockito.reset(projectServiceMock);
        Mockito.reset(categoryServiceMock);

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testGetCategory() throws Exception {

        int requestedCategoryId = 1;

        Category category = new Category();
        category.setId(requestedCategoryId);
        category.setName("Games");

        Project project1 = new Project(1, "GTA 2", "GTA 2 descriprion", category);
        Project project2 = new Project(2, "GTA 5", "GTA 5 descriprion", category);


        when(categoryServiceMock.getCategoryById(requestedCategoryId)).thenReturn(category);
        when(projectServiceMock.getProjectsByCategory(category)).thenReturn(Arrays.asList(project1, project2));

        String requestURI = "/category/"+requestedCategoryId + "/";
        mockMvc.perform(get(requestURI))
                .andExpect(status().isOk())
                .andExpect(view().name("category"))
                .andExpect(model().attribute("category", hasProperty("id", is(category.getId()))))
                .andExpect(model().attribute("category", hasProperty("name", is(category.getName()))))
                .andExpect(model().attribute("projects", hasSize(2)))
                .andExpect(model().attribute("projects", hasItem(
                        allOf(
                                hasProperty("id", is(project1.getId())),
                                hasProperty("name", is(project1.getName())),
                                hasProperty("description", is(project1.getDescription())),
                                hasProperty("category", is(project1.getCategory()))
                        )
                )))
                .andExpect(model().attribute("projects", hasItem(
                        allOf(
                                hasProperty("id", is(project2.getId())),
                                hasProperty("name", is(project2.getName())),
                                hasProperty("description", is(project2.getDescription())),
                                hasProperty("category", is(project2.getCategory()))
                        )
                )));
        verify(projectServiceMock, times(1)).getProjectsByCategory(category);
        verify(categoryServiceMock, times(1)).getCategoryById(requestedCategoryId);
    }
}