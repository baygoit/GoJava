package com.gojava6.service;

import static org.junit.Assert.*;

import com.gojava6.dao.CategoryDao;
import com.gojava6.entity.Category;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

import java.sql.SQLException;

/**
 * @author Sergii Getman (GESE) / WorldTicket A/S
 * @version 12/16/15
 */
public class CategoryServiceTest {

    @Mock
    CategoryDao mockTarget;

    CategoryService categoryService = new CategoryService();

    short id = (short) 1;

    Category fruit = new Category(id, "fruit");

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        categoryService.categoryDao = mockTarget;
    }

    @Test
    public void testFindAll() throws Exception {

    }

    @Test
    public void testFind() throws Exception {
        //setup
        when(mockTarget.find(id)).thenReturn(fruit);
        //execution
        Category actual = categoryService.find(id);
        //verification
        verify(mockTarget).find(id);

        assertEquals(fruit, actual);
    }

    @Test
    public void testCreate() throws Exception {

    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {
        //setup
        when(mockTarget.find(anyShort())).thenReturn(fruit);
        //execution
        categoryService.delete(id);
        //verification
        verify(mockTarget).find(id);
        verify(mockTarget).delete(fruit);
    }

    @Test
    public void testDeleteInOrder() throws Exception {
        //setup
        when(mockTarget.find(anyShort())).thenReturn(fruit);
        //create inOrder object passing any mocks that need to be verified in order
        InOrder inOrder = inOrder(mockTarget, mockTarget);
        //execution
        categoryService.delete(id);
        //verification
        inOrder.verify(mockTarget).find(id);
        inOrder.verify(mockTarget).delete(fruit);
    }

    @Test(expected = SQLException.class)
    public void testDeleteWithExc() throws Exception {
        //setup
        when(mockTarget.find(anyShort())).thenReturn(null);
        try {
            //execution
            categoryService.delete(id);
        } catch (Exception ex) {
            //verification
            verify(mockTarget, times(1)).find(eq(id));
            verify(mockTarget, never()).delete(fruit);
            throw ex;
        }
    }

    @Test
    public void testDeleteWithExcMock() throws Exception {
        //setup
        doThrow(new RuntimeException()).when(mockTarget).delete(anyShort());
        //exec
        try {
            mockTarget.delete(anyShort());
        } catch (Exception e) {
            verify(mockTarget, atLeastOnce()).delete(any());
        }

    }

    /**
     * Spying on real objects
     */
    @Test
    public void testSpy() {
        CategoryService spy = spy(categoryService);

        when(spy.create(any(Category.class))).thenReturn(fruit);
        doReturn(fruit).when(spy).create(any(Category.class));

        when(mockTarget.find(anyShort())).thenReturn(fruit);

        Category create =  spy.create(fruit);
        Category find =  spy.find(id);

        InOrder inOrder = inOrder(mockTarget, spy);

        inOrder.verify(spy, times(2)).create(any(Category.class));
        inOrder.verify(mockTarget, times(1)).find(anyShort());
    }


}