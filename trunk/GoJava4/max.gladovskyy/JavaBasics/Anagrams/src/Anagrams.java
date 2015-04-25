import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Anagrams {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String str = new String(reader.readLine());
		String[] list = str.split(" ");
		
		for (String s: list) {
			System.out.print(anagram(s)+" ");
		}
		
	}

	private static String anagram(String s) {
		char[] c = s.toCharArray();
		char[] c1 = new char[c.length];
		
		for (int i=0; i<c.length; i++) {
			c1[c.length-1-i] = c[i];
		}
		return new String(c1);
	}

}
