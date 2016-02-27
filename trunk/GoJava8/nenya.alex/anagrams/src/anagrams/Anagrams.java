package anagrams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Anagrams {

	public static void main(String[] args){
		StringBuilder sb = null;
		StringBuilder resultBuilder = new StringBuilder();
		String separator = "";
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the words");
		String str = "";
		try {
			str = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] strArr = str.split(" ");
		for (int i = 0; i < strArr.length; i++) {
			sb = new StringBuilder(strArr[i]);
			resultBuilder.append(separator).append(sb.reverse());
			separator = " ";
		}

		System.out.println(resultBuilder.toString());
	}

}
