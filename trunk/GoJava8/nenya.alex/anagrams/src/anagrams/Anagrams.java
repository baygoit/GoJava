package anagrams;

import java.io.IOException;


public class Anagrams {

	public static void main(String[] args){
		IO io = new IOImpl();
		ReverseWords reverse = new ReverseWords();
		String result = "";
		try {
			io.write("Enter the words");
			String str = io.read();
			result = reverse.reverseWords(str);
			
		} catch (IOException | EmptyStringException e) {
			e.printStackTrace();
		}
		io.write("Result:	"+result);
	}
}
