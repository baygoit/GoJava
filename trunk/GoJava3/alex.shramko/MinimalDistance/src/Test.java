import static org.junit.Assert.*;

public class Test {

    @org.junit.Test
    public void test() {
        try {
            assertEquals(1, MinimalDistance.calculateDistance("1 2 3"));
            assertEquals(2, MinimalDistance.calculateDistance("1 2 1 2 2 1"));
            assertEquals(2, MinimalDistance.calculateDistance("1 2 2 1 2 1"));
            assertEquals(
                    3,
                    MinimalDistance
                            .calculateDistance("23 45 34 12 45 4 38 56 2 49 100"));
            assertEquals(1,
                    MinimalDistance
                            .calculateDistance("23 45 34 4 45 4 38 56 4 4 100"));
            assertEquals(2,
                    MinimalDistance
                            .calculateDistance("23 45 34 2 45 4 38 56 2 4 2"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
