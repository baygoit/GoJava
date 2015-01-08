import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Anagram {

	public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter string: ");
        String[] words = br.readLine().split(" "); 
        String result = "";  
        
        for (int i = 0; i < words.length; i++) {
            char[] word = words[i].toCharArray();
            String anagram = "";
            for (int j = (word.length - 1); j >= 0; j--) {
                anagram += word[j];
            }
            result += anagram + " ";
        }
        System.out.println("Result: " + result);
    }
}
