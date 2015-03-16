import java.util.Arrays;
import java.util.Scanner;

public class Anagrams {

    public static void main(String[] args) {

        while (true) {
            String input = new Scanner(System.in).nextLine();
            String[] inputValue = input.split(" ");

            for (int i = 0; i < inputValue.length; i++) {
                String word = inputValue[i];
                String newWord = "";
                for (int j =  word.length()-1; j >= 0; j--) {
                    newWord = newWord + word.charAt(j);
                }
                inputValue[i] = newWord;
            }

            System.out.println(Arrays.toString(inputValue));
        }

    }

}
