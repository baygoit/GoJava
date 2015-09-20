package ua.com.goit.gojava.plotnikov.anagram;
import java.io.*;

public class anagram {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				
		System.out.println("Введите предложение: ");
		String phrase = reader.readLine();
		
		for (String part: phrase.split(" ")){
			String anagram = new StringBuffer(part).reverse().toString(); 
			System.out.print(anagram + " ");
	      }
	}

}
