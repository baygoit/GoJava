package ua.com.goit.gojava1.iavorskyi;

import java.util.Scanner;

public class LongDivider {

	private static final int TEN = 10;

	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
		System.out.println("This programs divides A/B. Only int numbers permited.");
		System.out.println("Enter A:");
		int dividend = in.nextInt();
		System.out.println("Enter B:");
		int divisor = in.nextInt();
		in.close();
		int[] dividendAsArray = dividendToArray(dividend);
		String result = calculateResult(dividend, divisor, dividendAsArray);
		System.out.print("\n" + dividend + " / " + divisor + " = " + result);
		
	}

	
	public static String calculateResult(int dividend, int divisor, int[] dividendAsArray) {
		int reminder = 0;
		int part = dividendAsArray[0];
		int[] reminderArray = new int[TEN];
		boolean period = false;
		boolean first = false;
		String result = "";

		int j = 0;
		while (part < divisor && part != dividend) {
			part = part * 10 + dividendAsArray[j + 1];
			j++;
		}

		int f = 0;
		while (j < dividendAsArray.length) {
			result += part / divisor;
			if (part / divisor > 0) {
				f = (part / divisor) * divisor;
				if (first) {
					System.out.print("\n" + tab(part, j) + " " + part);
				}
				System.out.print("\n" + tab(f, j) + "-" + f);
				System.out.print("\n" + tab(f, j) + " " + "---");
			}
			reminder = part % divisor;
			part = (j == (dividendAsArray.length - 1)) ? reminder * 10 : reminder
					* 10 + dividendAsArray[j + 1];
			j++;
			first = true;
		}

		if (reminder != 0) {
			result += ".";
		}

		int i = 0;
		int fraction = 0;
		int periodIndex = 0;
		while (reminder != 0 && fraction < TEN && !period) {
			for (int k = 0; k < reminderArray.length; k++) {
				if (reminder == reminderArray[k]) {
					period = true;
					periodIndex = k - 1;
					break;
				}
			}
			if (part / divisor > 0) {
				f = (part / divisor) * divisor;
				System.out.print("\n" + tab(part, j) + " " + part);
				System.out.print("\n" + tab(f, j) + "-" + f);
				System.out.print("\n" + tab(f, j) + " " + "---");
			}
			reminderArray[i] = reminder;
			reminder = part % divisor;
			if (period == false) {
				result += part / divisor;
				part = reminder * 10;
				fraction++;
				i++;
				j++;
			}
		}
		if (period && reminder != 0) {
			return formatPeriodResult(periodIndex, result);
		} else {
			return result;
		}
	}

	public static int[] dividendToArray(int dividend) {
		String stringDividend = Integer.toString(dividend);
		int[] dividendAsArray = new int[stringDividend.length()];
		for (int i = 0; i < dividendAsArray.length; i++) {
			dividendAsArray[i] = Integer.parseInt(Character.toString(stringDividend.charAt(i)));
		}
		return dividendAsArray;
	}

	public static String repeatString(String str, int j) {
		String result = "";
		if (str == null) {
			return "";
		}
		for (int i = 1; i <= j; i++) {
			result += str;
		}
		return result;
	}
	
	public static String tab(int i, int width) {
		String tab = "";
		int length = Integer.toString(i).length();
		tab = repeatString(" ", width - length);
		return tab;
	}

	public static String formatPeriodResult(int index, String result) {
		int dotIndex = result.indexOf(".");
		String str1 = result.substring(0, index + dotIndex + 2);
		String str2 = result.substring(index + dotIndex + 2, result.length());
		str1 += "(";
		str2 += ")";
		return str1 + str2;
	}

}