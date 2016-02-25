package lonly_number;

public class LonlyNumber {
	public static void main(String[] args) {
		int[] mas = { 2, 3, 2, 4, 3, 5, 2, 3, 4, 4 };
		System.out.println(new LonlyNumber().findLonly(mas));
	}

	public int findLonly(int[] mas) {
		int item = 0;
		int count = 1;
		for (int i = 0; i < mas.length; i++) {
			item = mas[i];
			for (int j = 0; j < mas.length; j++) {
				if (item == mas[j] && i != j) {
					count++;
				}
				if (count > 1) {
					break;
				}
			}
			if (count == 1) {
				break;
			}
			count = 1;
		}
		return item;
	}
}
