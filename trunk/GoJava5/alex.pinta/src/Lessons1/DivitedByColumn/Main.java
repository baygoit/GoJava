package Lessons1.DivitedByColumn;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 28.06.15
 * Time: 8:29
 * @version: 1.0
 */
public class Main {
    public static void main(String args[]){
        StringBuilder[] locStringBuilders;
        Scanner locScanner = new Scanner(System.in);
        String expression;
        for (;;){
            System.out.print("Input expression of divide (or Q for exit):");
            expression = locScanner.nextLine();
            if (expression.equalsIgnoreCase("Q")) {
                System.exit(1);
            }
            locStringBuilders = NumberAlgoritms.dividedByColumn(expression);
            System.out.println(locStringBuilders[0].toString());
            System.out.println(locStringBuilders[1].toString());
        }

    }
}
