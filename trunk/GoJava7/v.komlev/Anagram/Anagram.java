package logic;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Anagram {

	static String strValues = null, strResult = null;
	static char chArray[];
	static char tmp;

	public static char[] getArray() {
		for (int i = 0; i < chArray.length - 1; i++) {
			for (int j = 0; j < (chArray.length - 1) - i; j++) {
				tmp = chArray[j];
				chArray[j] = chArray[j + 1];
				chArray[j + 1] = tmp;
			}
		}
		return chArray;
	}

	public static void convertToChar() {
		chArray = new char[strValues.length()];
		strValues.getChars(0, strValues.length(), chArray, 0);
	}

	public static void inputString() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your text");
		strValues = scanner.nextLine();
		scanner.close();
		System.out.println("====================");
	}

	public static void viewResult() {
		System.out.println("Resalt: " + strResult);
	}

	public static void main(String[] args) {

		inputString();

		StringTokenizer st = new StringTokenizer(strValues);

		while (st.hasMoreElements()) {
			strValues = st.nextElement().toString();
			convertToChar();
			if (strResult == null) {
				strResult = String.valueOf(getArray());
			} else {
				strResult += " " + String.valueOf(getArray());
			}
		}

		viewResult();
	}

}
