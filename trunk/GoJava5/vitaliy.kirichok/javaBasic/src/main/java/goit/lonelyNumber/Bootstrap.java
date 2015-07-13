package goit.lonelyNumber;

import goit.common.Console;
import goit.common.ParseException;

import java.util.List;

public class Bootstrap {

    public static void main(String[] args) {
        Console console = new Console();
        List<Integer> number;
        do {
            try {
                number = console.readNumbers("Enter numbers:");
                LonelyNumber lonelyNumber = new LonelyNumber(number);
                System.out.println("Appearance: " + lonelyNumber.getMinValue());
                System.out.println("Values: " + lonelyNumber.retrieve());
            } catch (ParseException e) {
                console.writeLine(e.toString());
            }
        } while (console.hasNext());
    }
}
