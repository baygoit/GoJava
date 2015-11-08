import java.util.Scanner;

public class Anagrams {

    public static String changeString(String input) {
        StringBuilder newString = new StringBuilder();
        StringBuilder tempString = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                newString.append(tempString.reverse()).append(" ");

                tempString.delete(0, tempString.length());
            } else
                tempString.append(input.charAt(i));
        }
        newString.append(tempString.reverse());

        return newString.toString();
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Insert your string of words separated by space:");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();
        String changedString = changeString(input);

        System.out.println(changedString);

    }

}
