package ua.com.goit.iegorovDmitri.longDivision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LongDivision {
	private static int numberAfterPoint = 10;

	public static void main(String[] args) throws IOException {

		BufferedReader builder = new BufferedReader(new InputStreamReader(
				System.in));
		int devident = Integer.parseInt(builder.readLine());
		int divisor = Integer.parseInt(builder.readLine());
		LinkedList<Integer> splitDevident = toArray(devident);
		System.out.println(splitDevident);
		String quotient = "";
		int counter = 0;

		while ((splitDevident.size() != 1) || (splitDevident.get(0) != 0)) {
			int i = 0;
			String stringNumber;
			stringNumber = "" + splitDevident.get(i);
			int number = Integer.parseInt(stringNumber);

			while (counter < numberAfterPoint+1) {
				if (number / divisor > 0) {
					number = Integer.parseInt(stringNumber);
					quotient += number / divisor;
					if (splitDevident.size() == 0) {
						break;
					}
					splitDevident.removeFirst();
					splitDevident.addFirst(number % divisor);
					if (splitDevident.get(0) != 0) {
						System.out.println(splitDevident);
						System.out.println("quotient is " + quotient);
					}
					break;
				} else {

					if ((splitDevident.size() == 1) && (number / divisor == 0)) {
						splitDevident.addLast(0);
						if (counter == 0) {
							if (quotient == "") {
								quotient += 0;
							}
							quotient += ".";
						}
						counter++;
					}

					while (number / divisor < 1) {
						if (splitDevident.size() == 1) {
							splitDevident.addLast(0);
							if (counter == 0) {
								if (quotient == "") {
									quotient += 0;
								}
								quotient += ".";
							}
							counter++;
						}
						stringNumber += splitDevident.get(i + 1);
						splitDevident.removeFirst();
						number = Integer.parseInt(stringNumber);
					}

					System.out.println(stringNumber);
					System.out.println("-");
					System.out.println((number / divisor) * divisor);
					System.out.println(Integer.parseInt(stringNumber)
							- (number / divisor) * divisor);

					i++;
				}
			}
		}
		if (quotient.contains(".")) {
			String[] parts = quotient.split("\\.");
			System.out.print("quotient is " + parts[0] + "."
					+ checkPeriod(parts[1]));
		} else {
			System.out.println("quotient is " + quotient);
		}

	}

	public static LinkedList<Integer> toArray(int number) {

		LinkedList<Integer> temp = new LinkedList<Integer>();

		while (number > 0) {
			temp.addFirst(number % 10);
			number = number / 10;
		}

		return temp;
	}

	public static String checkPeriod(String string) {
		String s = "";
		if (string.length() < numberAfterPoint){
			return string;
		}
		for (int k = 1; k < string.length()/2; k++) {
			int j = 0, i = 0;
			s = "";
			String[] strings = new String[string.length()];

			while (i + k < string.length()) {
				strings[j] = string.substring(i, i + k);
				i += k;
				j++;
			}

			for (int n = 0; n < strings.length; n++) {
				if ((strings[n] != null) && (strings[n + 1] != null)) {
					if (strings[n].equals(strings[n + 1])) {
						if (strings[n + 2] != null) {
							if (strings[n].equals(strings[n + 2])) {
								s += "(" + strings[n] + ")";
								break;
							}
						} else {
							s += "(" + strings[n] + ")";
							break;
						}
					} else {
						s += strings[n];
					}
				}
			}
			if (s.contains("(")) {
				break;
			}

		}
		return s;
	}
}
