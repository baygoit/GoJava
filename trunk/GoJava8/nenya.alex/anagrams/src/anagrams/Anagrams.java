package anagrams;

import java.io.IOException;

public class Anagrams {

	public static void main(String[] args) throws IOException{
		IO io = new IOImpl();
		ReverseWords reverse = new ReverseWords();
		String result = "";
		io.write("Enter the words");
		String str = io.read();
		result = reverse.reverseWords(str);
		io.write("Result:	" + result);
	}
}
