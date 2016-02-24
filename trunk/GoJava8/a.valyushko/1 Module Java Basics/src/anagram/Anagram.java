package anagram;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Anagram {
    public static void main(String[] args)throws Exception{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String userInput = reader.readLine();
        String[] arrayOfWords = userInput.split(" ");
        for(int i = 0; i < arrayOfWords.length; i++){
            System.out.print(outputAnagram(arrayOfWords[i].toString()) + " ");
        }
    }

    
    public static String outputAnagram(String string){
        return new StringBuilder(string).reverse().toString();
    }
}
