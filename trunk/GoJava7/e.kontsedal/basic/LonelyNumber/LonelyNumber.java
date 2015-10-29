import java.util.ArrayList;

public class LonelyNumber {
	public static void main(String[] args) {
		int[] numbers = new int[] { 1, 3, 2, 4, 7, 7, 2, 3, 4, 3 };
		findingAndPrintingAloneNumber(numbers);
	}

	public static void findingAndPrintingAloneNumber(int[] array) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int result = 0;
		String output = "Here no \"alone nubmer\"";

		for (int i = 0; i < array.length; i++) {
			if (list.contains(array[i]))
				continue;
			for (int j = 0; j < array.length; j++) {
				if (array[i] == array[j]) {
					result++;
				}
			}

			if (result == 3) {
				output = String.valueOf("\"alone nubmer\" - " + array[i]);
				break;
			}
			result = 0;
		}

		System.out.println(output);
	}
}