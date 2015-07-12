package goit.dm.kickstarter.mvc.model;

import goit.dm.kickstarter.mvc.model.MainPageModel;
import goit.dm.kickstarter.DataRegistry;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * Created with IntelliJ IDEA.
 * User: dmrachkovskyi
 * Date: 7/11/15
 * Time: 2:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class MainPageModelTest {

    @Mock
    private DataRegistry dataRegistry;

    @InjectMocks
    private MainPageModel model;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void whenGetMsgThanReturnNotNull() throws Exception {
        //I`m not instantiating MainPageModel class and do not set dataRegistry field in it.
        //It was done by Mockito framework in setUp method.
        //Also you need to annotate MainPageModel field with @InjectMocks and DataRegistry with @Mock
        //annotations to make it works.
        //Google MockitoAnnotations, @Mock, @InjectMocks documentation for more info.
        when(dataRegistry.getHelloMsg()).thenReturn("Hello Msg");

        String result = model.getHelloMsg();

        //You can have several common assertions in one test method
        assertNotNull("Hello msg must not be null", result);
        assertEquals("Hello Msg must be the same as in date registry", "Hello Msg", result);
    }



}
