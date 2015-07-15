package com.tyomsky.kickstarter.mvc.model;

import com.tyomsky.kickstarter.dao.DataProvider;
import com.tyomsky.kickstarter.model.Project;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.xml.crypto.Data;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

public class ProjectModelTest {

    @Mock
    DataProvider dataProvider;

    @Mock
    Project project;

    @InjectMocks
    ProjectModel model;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenUpdateThenGetProject() throws Exception {
        when(dataProvider.getProject(anyInt(), anyInt())).thenReturn(project);

        model.update(1,1);

        Project actual = model.getProject();

        assertEquals(project, actual);
    }
}