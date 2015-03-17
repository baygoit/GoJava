import junit.framework.TestCase;

/**
 * Created by Алексей on 17.03.2015.
 */
public class Test extends TestCase {
    public void test1() {
        int expectedResult = 8;
        int actualResult = Operations.pow(2, 3);
        assertEquals(actualResult, expectedResult);
    }
}
