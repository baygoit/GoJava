package com.tyomsky.kickstarter;

import com.tyomsky.kickstarter.mvc.controller.CategoryController;
import com.tyomsky.kickstarter.mvc.controller.MainPageController;
import com.tyomsky.kickstarter.mvc.controller.ProjectController;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import sun.security.krb5.Config;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

public class DispatcherTest {

    @Mock
    MainPageController mainPageController;

    @Mock
    CategoryController categoryController;

    @Mock
    ProjectController projectController;

    @InjectMocks
    Dispatcher dispatcher;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(mainPageController.showModel()).thenReturn(true);
        when(categoryController.showModel(anyInt())).thenReturn(true);
        when(projectController.showModel(anyInt(), anyInt())).thenReturn(true);
    }

    @Test
    public void inInputUpdatePath() throws Exception {
        List<Integer> expectedPath = new ArrayList<>();
        expectedPath.add(1);
        dispatcher.onInput(1);

        assertArrayEquals(expectedPath.toArray(), dispatcher.getPath().toArray());

        expectedPath.add(2);
        dispatcher.onInput(2);

        assertArrayEquals(expectedPath.toArray(), dispatcher.getPath().toArray());

        dispatcher.onInput(2);

        assertArrayEquals(expectedPath.toArray(), dispatcher.getPath().toArray());

        expectedPath.remove(1);
        dispatcher.onInput(0);

        assertArrayEquals(expectedPath.toArray(), dispatcher.getPath().toArray());

        expectedPath.remove(0);
        dispatcher.onInput(0);

        assertArrayEquals(expectedPath.toArray(), dispatcher.getPath().toArray());
    }

    @Test
    public void onInputInvokeControllers() throws Exception {
        int [] inputSequence = {1,1,1,0,0};
        for (int i : inputSequence) {
            dispatcher.onInput(i);
        }
        verify(categoryController, times(2)).showModel(anyInt());
        verify(projectController, times(2)).showModel(anyInt(), anyInt());
        verify(mainPageController, times(1)).showModel();
    }

    @Test
    public void testOnApplicationStart() throws Exception {
        dispatcher.onApplicationStart();
        verify(mainPageController, times(1)).showModel();
    }
}