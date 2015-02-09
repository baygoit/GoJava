package org.kudryavtsev.kickstarter.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import org.junit.BeforeClass;
import org.junit.Test;
import org.kudryavtsev.kickstarter.Controller;
import org.kudryavtsev.kickstarter.inout.Input;

public class ControllerTest {
    private static Controller mockedController;
 
    private static void init() {
//        mockedController = mock(Controller.class);
      //Stubbing the methods of mocked BookDAL with mocked data.
//        21.when(mockedBookDAL.getAllBooks()).thenReturn(Arrays.asList(book1, book2));
//        22.when(mockedBookDAL.getBook("8131721019")).thenReturn(book1);
//        23.when(mockedBookDAL.addBook(book1)).thenReturn(book1.getIsbn());
//        24.when(mockedBookDAL.updateBook(book1)).thenReturn(book1.getIsbn());
        // fail("Not yet implemented"); // TODO
//        mockedController.start();
//        verify(mockedController).start();
        //when(mockedController.start()).thenReturn(0);
        
    
    }

    @Test
    public void shouldReturnZero_whenStartExecute() {
        // fail("Not yet implemented"); // TODO

//        assertEquals(0, actual);
    }

}
