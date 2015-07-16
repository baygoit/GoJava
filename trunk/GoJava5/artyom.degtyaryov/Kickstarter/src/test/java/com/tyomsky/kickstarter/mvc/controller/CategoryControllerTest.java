//package com.tyomsky.kickstarter.mvc.controller;
//
//import com.tyomsky.kickstarter.mvc.model.CategoryPageModel;
//import com.tyomsky.kickstarter.mvc.view.CategoryPageView;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//
//public class CategoryControllerTest {
//    @Mock
//    CategoryPageModel model;
//
//    @Mock
//    CategoryPageView view;
//
//    @Before
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void whenShowModelUpdateModel() {
//        CategoryController controller = new CategoryController(view, model);
//        int index = 1;
//        controller.showModel(index);
//        verify(model, times(1)).update(index);
//    }
//
//    @Test
//    public void whenShowModelShowView() {
//        CategoryController controller = new CategoryController(view, model);
//
//        controller.showModel(1);
//        verify(view, times(1)).show(model);
//    }
//}