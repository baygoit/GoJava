import static org.junit.Assert.*;

public class Test {

    @org.junit.Test
    public void test() {
        try {
            int result;
            result = MinimalDistance.calculateDistance("1 2 3");
            assertEquals(1, result);
            result = MinimalDistance.calculateDistance("1 3 2");
            assertEquals(2, result);
            result = MinimalDistance.calculateDistance("1 1 1");
            assertEquals(1, result);
            result = MinimalDistance.calculateDistance("6 5 3 3 1 1 0 -6");
            assertEquals(1, result);
            result = MinimalDistance.calculateDistance("1 2 1 2 2 1");
            assertEquals(2, result);
            result = MinimalDistance.calculateDistance("1 2 2 1 2 1");
            assertEquals(2, result);
            result = MinimalDistance.calculateDistance("2 9 3 3 3 11 15");
            assertEquals(2, result);
            result = MinimalDistance
                    .calculateDistance("23 45 34 12 45 4 38 56 2 49 100");
            assertEquals(3, result);
            result = MinimalDistance
                    .calculateDistance("23 45 34 4 45 4 38 56 4 4 100");
            assertEquals(1, result);
            result = MinimalDistance
                    .calculateDistance("23 45 34 2 45 4 38 56 2 4 2");
            assertEquals(2, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
