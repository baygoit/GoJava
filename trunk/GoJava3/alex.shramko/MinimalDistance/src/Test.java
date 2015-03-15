import static org.junit.Assert.*;

public class Test {

	@org.junit.Test
	public void test() {
		try {
			assertArrayEquals(new int[] { 1, 2, 1 },
					MinimalDistance.checkInput("1 2 3"));
			assertArrayEquals(new int[] { 1, 1, 2 },
					MinimalDistance.checkInput("1 2 1 2 2 1"));
			assertArrayEquals(new int[] { 1, 1, 2 },
					MinimalDistance.checkInput("1 2 2 1 2 1"));
			assertArrayEquals(new int[] { 2, 4, 3 },
					MinimalDistance.checkInput("23 45 34 12 45 4 38 56 2 49 100"));
			assertArrayEquals(new int[] { 4, 4, 1 },
					MinimalDistance.checkInput("23 45 34 4 45 4 38 56 4 4 100"));	
			assertArrayEquals(new int[] { 2, 2, 2 },
					MinimalDistance.checkInput("23 45 34 2 45 4 38 56 2 4 2"));	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
