package ua.goit.kyrychok.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console {

    private static final String EXIT_CODE = "y";
    private Scanner scanner = new Scanner(System.in);

    public String read(String inviteMessage) {
        write(inviteMessage);
        return scanner.nextLine();
    }

    public List<Integer> readNumbers(String inviteMessage) throws ParseException {
        String[] input = read(inviteMessage).split(" ");
        List<Integer> result = new ArrayList<>();
        for (String number : input) {
            try {
                result.add(Integer.parseInt(number));
            } catch (NumberFormatException e) {
                throw new ParseException("Error when parsing string: ".concat("\"").concat(number).concat("\"."));
            }
        }
        return result;
    }

    public boolean hasNext() {
        String message = "Repeat(".concat(EXIT_CODE).concat(" - yes, otherwise - exit)?");
        return read(message).equalsIgnoreCase(EXIT_CODE);
    }

    public void writeLine(String text) {
        System.out.println(text);
    }

    public void write(String text) {
        System.out.print(text);
    }

    public void close() {
        scanner.close();
    }

    public int readValidInt(String inviteMessage, int maxValue) {
        int result = 0;
        boolean latch = true;
        while (latch) {
            try {
                String input = read(inviteMessage);
                result = Integer.parseInt(input);
                if (result >= 0 & result <= maxValue) {
                    latch = false;
                }
            } catch (NumberFormatException e) {
                writeLine("Invalid choice");
            }
        }
        return result;
    }

}
