package com.tyomsky.kickstarter.mvc.controller;

import com.tyomsky.kickstarter.mvc.model.MainPageModel;
import com.tyomsky.kickstarter.mvc.view.MainPageView;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class MainPageControllerTest {

    @Mock
    MainPageModel model;

    @Mock
    MainPageView view;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenShowModelUpdateModel() {
        MainPageController controller = new MainPageController(view, model);

        controller.showModel();
        verify(model, times(1)).update();
    }

    @Test
    public void whenShowModelShowView() {
        MainPageController controller = new MainPageController(view, model);

        controller.showModel();
        verify(view, times(1)).show(model);
    }
}