//package com.tyomsky.kickstarter.mvc.controller;
//
//import com.tyomsky.kickstarter.mvc.model.ProjectPageModel;
//import com.tyomsky.kickstarter.mvc.view.ProjectPageView;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//
//public class ProjectControllerTest {
//    @Mock
//    ProjectPageModel model;
//
//    @Mock
//    ProjectPageView view;
//
//    @Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void whenShowModelUpdateModel() {
//        ProjectController controller = new ProjectController(view, model);
//        int categoryIndex = 1;
//        int projectIndex = 1;
//        controller.showModel(categoryIndex, projectIndex);
//        verify(model, times(1)).update(categoryIndex, projectIndex);
//    }
//
//    @Test
//    public void whenShowModelShowView() {
//        ProjectController controller = new ProjectController(view, model);
//
//        controller.showModel(1, 1);
//        verify(view, times(1)).show(model);
//    }
//
//}