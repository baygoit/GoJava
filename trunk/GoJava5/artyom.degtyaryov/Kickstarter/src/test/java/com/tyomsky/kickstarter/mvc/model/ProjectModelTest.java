package com.tyomsky.kickstarter.mvc.model;

import com.tyomsky.kickstarter.dao.DataRegistry;
import com.tyomsky.kickstarter.model.Project;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

public class ProjectModelTest {

    @Mock
    DataRegistry dataProvider;

    @Mock
    Project project;

    @InjectMocks
    ProjectPageModel model;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenUpdateThenGetProject() throws Exception {
        when(dataProvider.getProjectById(anyInt(), anyInt())).thenReturn(project);

        model.update(1,1);

        Project actual = model.getProject();

        assertEquals(project, actual);
    }
}