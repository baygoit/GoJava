package goit.vh.kickstarter.mvc.model;

import goit.vh.kickstarter.DataRegistry;
import goit.vh.kickstarter.Output;
import goit.vh.kickstarter.mvc.controller.CategoryController;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.*;

/**
 * Created by Viktor on 26.07.2015.
 */
public class CategoryModelTest  {
//    @Mock
//    private DataRegistry dataRegistry;

    @Mock
    private Output output = new Output();

    @Before
    public  void setUp(){
        MockitoAnnotations.initMocks(this);
    }


    @Test()
    public void whenRefreshShouldReturn0() throws Exception {
       CategoryModel categoryModel = new CategoryModel();
          DataRegistry dataRegistry = new DataRegistry();


        Map<Integer,List> mapOfSize2 = new HashMap<>();
        mapOfSize2.put(1, anyList());
        mapOfSize2.put(1,anyList());
        when(dataRegistry.getCategories().size()).thenReturn(mapOfSize2.size());
        Assert.assertEquals("Should return null", null, categoryModel.refreshModel(5));


    }
}