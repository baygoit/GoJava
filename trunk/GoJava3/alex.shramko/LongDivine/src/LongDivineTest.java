import static org.junit.Assert.*;

import org.junit.Test;

public class LongDivineTest {

    @Test
    public void test() {
        assertEquals("2", LongDivine.longDivine(6, 3));
        assertEquals("0.0(54)", LongDivine.longDivine(3, 55));
        assertEquals("0.(3)", LongDivine.longDivine(1, 3));
        assertEquals("0.25", LongDivine.longDivine(1, 4));
        assertEquals("0.(285714)", LongDivine.longDivine(12, 42));
        assertEquals("0.1(6)", LongDivine.longDivine(1, 6));
        assertEquals("16.(6)", LongDivine.longDivine(50, 3));
    }

}
