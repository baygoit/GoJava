package exercises;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class JunitParametrized {

    private int second;

    private int first;

    private int sum;

    @Parameterized.Parameters
    public static Collection<Integer[]> getData() {
        return Arrays.asList(new Integer[][]
                {{3,1,2}, {4,2,2}, {5,3,2}});
    }

    public JunitParametrized(int sum, int first, int second) {
        this.sum = sum;
        this.first = first;
        this.second = second;
    }

    @Test
    public void testSum() {
        Addition addition = new Addition();
        System.out.println("first: " + first + " + " + " second: " + second + " = " + sum);
        assertEquals("check sum" ,sum, addition.addNumbers(first, second));
    }
}
