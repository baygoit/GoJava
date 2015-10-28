import junit.framework.TestCase;

/**
 * Created by Aleksey Kurkov on 17.03.2015.
 */

public class Test extends TestCase {
    public void test1() {
        int expectedResult = 8;
        int actualResult = Operations.pow(2, 3);
        assertEquals(actualResult, expectedResult);
    }
    public void test2() {
        int expectedResult = 1;
        int actualResult = Operations.pow(2, 0);
        assertEquals(actualResult, expectedResult);
    }
    public void test3() {
        int expectedResult = 116;
        int actualResult = Operations.pow(3, 10);
        assertEquals(actualResult, expectedResult);
    }
}
