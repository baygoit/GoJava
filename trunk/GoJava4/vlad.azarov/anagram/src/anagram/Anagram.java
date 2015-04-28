package anagram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Anagram {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter some text: ");
		String str = reader.readLine();
		
		System.out.println(reverseText(str));
		
	}
	
	public static String reverseText(String s) {
		char[] buf = s.toCharArray();
		int len = buf.length;
		int start = 0;
		for (int i = 0; i < len; i++) {
			if (buf[i] == ' ' || i == (len-1)) {
				if(i == (len-1)) {
					i = len;
				}
				int end = (start + i) / 2;
				for (int j = start; j < end; j++) {
					char c = buf[j];
					int pos = (start + i) - j - 1;
					buf[j] = buf[pos];
					buf[pos] = c;
				}
				start = i + 1;
			}
		}
		return new String(buf);
	}
}
