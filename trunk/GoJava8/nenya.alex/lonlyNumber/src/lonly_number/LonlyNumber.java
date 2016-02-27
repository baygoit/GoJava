package lonly_number;

public class LonlyNumber {
	public static void main(String[] args) {
		FindLonlyNumber find = new FindLonlyNumber();
		int[] mas = {1,1, 2, 3, 2, 4, 2, 4, 4 };
		try {
			System.out.println(find.findLonly(mas));
		} catch (EmptyArrayException e) {
			e.printStackTrace();
		}
	}

	
}
