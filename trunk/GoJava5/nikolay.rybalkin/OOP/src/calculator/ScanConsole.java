package calculator;

import java.util.Scanner;

public class ScanConsole {

    public String consoleScan(){

        Scanner scanner = new Scanner(System.in);
        String number = "";
        try {
            if(scanner.hasNextInt()){
                number = scanner.nextLine();
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("You entered is not a number!");
        }
        return number;
    }
}
