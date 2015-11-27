package go.it.salivon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HelloWord {

    private static final String HELP_MSG = "Enter Name or enter 'quit' to exit.";

    public static void main(String[] args) throws IOException {
        System.out.println(HELP_MSG);
        String str;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            str = br.readLine();

            if (str.equals("quit")) {
                System.out.println("Goodbye!");
                break;
            } else if (str.equals("")) {
                System.out.println(HELP_MSG);
            } else {
                System.out.println("Hello " + str + "!");
            }

        } while (true);

    }

}
