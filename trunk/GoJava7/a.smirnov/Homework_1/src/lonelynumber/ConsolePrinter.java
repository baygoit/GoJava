package lonelynumber;

import java.util.List;

public class ConsolePrinter {
	
	public void print(List<Integer> list) {
		StringBuilder result = new StringBuilder();
		result.
			append("User's inputed numbers : ").
			append(list);
		System.out.println(result.toString());
	}
	
	public void print(String str) {
		System.out.println(str);
	}
	
	public void printLonelyNumber(List<Integer> lonelyNumbers) {
		if (lonelyNumbers.isEmpty()) {
			System.out.println("There is no lonely number in user's inserted numbers");
		} else if (lonelyNumbers.size() == 1) {
			System.out.println("Lonely number : " + lonelyNumbers);
		} else {
			System.out.println("There are more than one lonely numbers. "
					+ "These numbers are : " + lonelyNumbers);
		}
	}
}
