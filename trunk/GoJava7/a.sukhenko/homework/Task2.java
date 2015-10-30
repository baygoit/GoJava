import java.util.ArrayList;

/**
 * Task2.java
 * 
 * @author Artur Sukhenko
 * @version 23.10.2015
 * @java 8
 * @category Homework
 * 
 */
public class Task2 {

	public static void main(String[] args) {
		if (args.length != 0) {
			if (args[0] != null) {
				if (args.length >= 2) {
					for (int i = 0; i < args.length; i++) {
						if (!checkString(args[i])) {
							System.exit(1);
						}
					}
					task2v2(args).forEach(System.out::println);
				}

			}
		}

	}

	public static boolean checkString(String string) {
		try {
			Integer.parseInt(string);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static ArrayList<String> task2v2(String[] arr) {
		ArrayList<String> output = new ArrayList<>();
		ArrayList<Integer> min1s = new ArrayList<>();
		ArrayList<Integer> min2s = new ArrayList<>();
		String inputArray = "Input array: ";
		int[] inputArr = new int[arr.length];
		int min1 = Integer.MAX_VALUE - 1, min2 = Integer.MAX_VALUE;
		for (int i = 0; i < inputArr.length; i++) {
			inputArr[i] = Integer.parseInt(arr[i]);
			inputArray += inputArr[i] + "(#" + i + ") ";
			if (inputArr[i] < min2 && inputArr[i] > min1) {
				min2 = inputArr[i];
			} else if (inputArr[i] < min1) {
				min1 = inputArr[i];
			}
		}
		for (int i = inputArr.length - 1; i >= 0; i--) {
			if (inputArr[i] < min2 && inputArr[i] > min1) {
				min2 = inputArr[i];
			} else if (inputArr[i] < min1) {
				min1 = inputArr[i];
			}
		}
		output.add(inputArray);
		output.add("Min1: " + min1 + " Min2: " + min2);
		for (int i = 0; i < inputArr.length; i++) {
			if (inputArr[i] == min1) {
				min1s.add(i);
			} else if (inputArr[i] == min2) {
				min2s.add(i);
			}
		}

		for (Integer x : min1s) {
			for (Integer y : min2s) {
				output.add("Distance between " + min1 + "(#" + x + ")" + " and " + min2 + "(#" + y + ")" + " = "
						+ Math.abs(y - x));
			}
		}
		return output;

	}

}
