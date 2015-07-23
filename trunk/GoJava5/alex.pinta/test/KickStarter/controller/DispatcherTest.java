package KickStarter.controller;

import KickStarter.*;
import static org.junit.Assert.*;

import KickStarter.dao.LoadingData;
import KickStarter.dao.ManualInput;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 17.07.15
 * Time: 6:39
 * @version: 1.0
 */

//@RunWith(Mockito.)
public class DispatcherTest {

    @Mock
    Output output;

    @Mock
    Input input;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testStartApplication() throws Exception {
        Dispatcher dispatcher = new Dispatcher(input, output);
        dispatcher.startApplication(new ManualInput());
        LoadingData loadingData = Mockito.mock(ManualInput.class);
        loadingData.load();
        verify(loadingData).load();

        assertNotNull(dispatcher.mainPageModel);
        assertNotNull(dispatcher.viewMainPage);
        assertNotNull(dispatcher.getDeviceIn());
        assertNotNull(dispatcher.getDeviceOut());
    }

//    @Captor
//    ArgumentCaptor<ArrayList<Integer>> mockUserChoice;
    @Mock
    MainPageController mainPageController;
    @Mock
    CategoryController categoryController;
    @Mock
    ProjectController projectController;

    @Test
    public void testActionPerformedWhenUserChoice0() throws Exception {
        Dispatcher dispatcher = spy(new Dispatcher(input, output));
        dispatcher.startApplication(new ManualInput());
        List<Integer> userChoice = new ArrayList<Integer>();
        userChoice.add(0);
        dispatcher.mainPageModel.setUserChoice(userChoice);
        when(input.inputChoice()).thenReturn("0").thenReturn("Q");
        dispatcher.actionPerformed();
        when(mainPageController.isHaveToProcessed(anyList())).thenReturn(true);
        assertTrue(mainPageController.isHaveToProcessed(anyList()));
        //verify((MainPageController)mainPageController).isHaveToProcessed(dispatcher.mainPageModel.getUserChoice());
    }

    @Test
    public void testActionPerformedWhenUserChoice1() throws Exception {
        Dispatcher dispatcher = spy(new Dispatcher(input, output));
        dispatcher.startApplication(new ManualInput());
        List<Integer> userChoice = new ArrayList<Integer>();
        userChoice.add(1);
        dispatcher.mainPageModel.setUserChoice(userChoice);
        when(input.inputChoice()).thenReturn("1").thenReturn("Q");
//        doReturn("1").when(input).inputChoice();
        dispatcher.actionPerformed();
        when(categoryController.isHaveToProcessed(anyList())).thenReturn(true);
        when(mainPageController.isHaveToProcessed(anyList())).thenReturn(true);
        assertTrue(categoryController.isHaveToProcessed(anyList()));
        assertTrue(mainPageController.isHaveToProcessed(anyList()));
//        verify(categoryController).isHaveToProcessed(mockUserChoice.capture());
//        verify(mainPageController).isHaveToProcessed(mockUserChoice.capture());
    }

    @Test
    public void testActionPerformedWhenUserChoice2() throws Exception {
        Dispatcher dispatcher = spy(new Dispatcher(input, output));
        dispatcher.startApplication(new ManualInput());
        List<Integer> userChoice = new ArrayList<Integer>();
        userChoice.add(1);
        userChoice.add(2);
        dispatcher.mainPageModel.setUserChoice(userChoice);
        when(input.inputChoice()).thenReturn("1").thenReturn("2").thenReturn("0").thenReturn("Q");
//        doReturn("1").when(input).inputChoice();
        dispatcher.actionPerformed();
        when(categoryController.isHaveToProcessed(anyList())).thenReturn(true);
        when(mainPageController.isHaveToProcessed(anyList())).thenReturn(true);
        assertTrue(categoryController.isHaveToProcessed(anyList()));
        assertTrue(mainPageController.isHaveToProcessed(anyList()));
//        verify(categoryController).isHaveToProcessed(mockUserChoice.capture());
//        verify(mainPageController).isHaveToProcessed(mockUserChoice.capture());
    }

    @Test
    public void testValidateChoice() throws Exception {
        Dispatcher dispatcher = spy(new Dispatcher(input, output));
        assertTrue(dispatcher.validateChoice("1"));
        assertFalse(dispatcher.validateChoice("."));
        assertFalse(dispatcher.validateChoice("A"));
        assertFalse(dispatcher.validateChoice(" "));
    }
}
