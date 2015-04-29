import java.util.Scanner;

public class DistanceBetween2numbers {

	private static Scanner scanner;

	public static void main(String[] args) {

		System.out.println("Enter array of numbers");
		scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		if (isValid(str)) {
			findDistanceBetween2Min(getArray(str.split(" ")));
		} else {
			System.out.println("Enter correct string");
		}
	}

	private static boolean isValid(String str) {
		if (str.isEmpty()) {
			return false;
		} else {
			char[] charArray = str.toCharArray();
			for (int i = 0; i < charArray.length; i++) {
				if ((charArray[i] != '1') && (charArray[i] != '2')
						&& (charArray[i] != '3') && (charArray[i] != '4')
						&& (charArray[i] != '5') && (charArray[i] != '6')
						&& (charArray[i] != '7') && (charArray[i] != '8')
						&& (charArray[i] != '9') && (charArray[i] != '0')
						&& (charArray[i] != ' ')) {
					return false;
				}
			}
			if (maxNumberCheck(str.split(" "))) {
				return true;
			} else
				return false;
		}

	}

	private static boolean maxNumberCheck(String[] s) {

		for (int i = 0; i < s.length; i++) {
			if (!(s[i].isEmpty())) {
				if (s[i].length() > 10) {
					return false;
				} else {
					if (Long.parseLong(s[i]) > Integer.MAX_VALUE) {
						return false;
					}
				}

			}

		}
		return true;
	}

	private static int[] getArray(String[] s) {
		int arrLength = s.length;
		for (int i = 0; i < s.length; i++) {
			if (s[i].isEmpty()) {
				arrLength--;
			}
		}
		int[] arr = new int[arrLength];
		for (int i = 0, j = 0; i < s.length || j < arrLength; i++, j++) {
			if (s[i].isEmpty()) {
				j--;
			} else {
				arr[j] = Integer.valueOf(s[i]);
			}

		}
		return arr;
	}

	private static void findDistanceBetween2Min(int[] arr) {
		int min1 = arr[0];
		int min1Index = 0;
		int min2, min2Index;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min1) {
				min1 = arr[i];
				min1Index = i;
			}

		}
		if (min1Index != 0) {
			min2Index = 0;
			min2 = arr[0];
		} else {
			min2Index = 1;
			min2 = arr[1];
		}
		for (int i = 0; i < arr.length; i++) {
			if (i != min1Index) {
				if (arr[i] < min2) {
					min2 = arr[i];
					min2Index = i;
				}
			}
		}

		System.out.println("result: " + Math.abs(min2Index - min1Index)
				+ " MinNumber1: " + min1 + " MinNumber2: " + min2);
	}

}
