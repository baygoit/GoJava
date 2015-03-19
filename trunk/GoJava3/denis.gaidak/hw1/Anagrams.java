import java.util.Arrays;
import java.util.Scanner;

public class Anagrams {

    public static void main(String[] args) {

        while (true) {
            String input = new Scanner(System.in).nextLine();
            String[] inputValue = input.split(" ");
            for (int i = 0; i < inputValue.length; i++) {
                StringBuilder stringBuilder = new StringBuilder(inputValue[i]);
                inputValue[i] = stringBuilder.reverse().toString();
            }
            System.out.println(Arrays.toString(inputValue));
        }

    }

}
