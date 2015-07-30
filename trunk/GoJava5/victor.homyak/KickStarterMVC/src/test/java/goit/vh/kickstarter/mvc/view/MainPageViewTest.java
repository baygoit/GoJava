package goit.vh.kickstarter.mvc.view;

import goit.vh.kickstarter.Input;
import goit.vh.kickstarter.Output;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Created with IntelliJ IDEA.
 * User: dmrachkovskyi
 * Date: 7/11/15
 * Time: 3:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class MainPageViewTest {

    @Mock
    private Output output;

    @Mock
    private Input input;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }


//    @Test
//    public void whenReadUserInputUpdateInputField() throws Exception {
//        String EXPECTED_INPUT  = "01234567";
//
//        when(input.getInput()).thenReturn(EXPECTED_INPUT);
//
//        MainPageView mainPageView = new MainPageView(output);
//        mainPageView.readUserInput();
//        Assert.assertEquals(
//            "User Input should be correct",
//    EXPECTED_INPUT,
//            mainPageView.getUserInput());
//}
//
//    @Test
//    public void whenRenderMainPageThanPrintHelloMsgAndCategoriesList() throws Exception {
//        when(model.getHelloMsg()).thenReturn("Test Msg");
//        CategoryModel[] CategoryModel = {new CategoryModel("CategoryModel 1"), new CategoryModel("CategoryModel 2"), new CategoryModel("CategoryModel 3")};
//        when(model.getCategories()).thenReturn(CategoryModel);
//
//        final List<String> view = new ArrayList<>();
//
//        // Here we mock output.println() to store received argument in List of Strings
//        // so than we can compare it with expected result
//        doAnswer(new Answer<Object>() {
//            @Override
//            public Object answer(InvocationOnMock invocation) throws Throwable {
//                Object[] arguments = invocation.getArguments();
//                String str = (String) arguments[0];
//                view.add(str);
//                return null;
//            }}).when(output).println(anyString()); // here we use anyString matcher so this mocked method
//                                                   // will be call with any string passed to println method
//        MainPageView mainPageView = new MainPageView(output);
//
//        mainPageView.render(model);
//        String[] expectedResult = {"Test Msg", "1 CategoryModel 1", "2 CategoryModel 2", "3 CategoryModel 3"};
//        Assert.assertArrayEquals(expectedResult, view.toArray());
//    }
}
