import static org.junit.Assert.*;

import org.junit.Test;


public class MainTest {
    @Test
    public void test() {
        int result;
        result = Main.power(3, 19);
        assertEquals(1162261467, result);
        result = Main.power(2, 2);
        assertEquals(4, result);
        
    }

}
