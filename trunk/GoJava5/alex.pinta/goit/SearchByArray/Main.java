package Lessons1.SearchByArray;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Alex_Pinta
 * Date: 25.06.15
 * Time: 11:35
 * @version: 1.0
 */
public class Main {
    private static final int QUANTITY_INPUTED_ELEMENTS = 7;
    public static void main(String args[]) {
        Scanner locScanner = new Scanner(System.in);
        String inputType = "";
        ArrayList locArrayList;
        int distance = 0;
        while(true) {
            System.out.println("What kind of type you want to use in array?:");
            System.out.println("1. Integer");
            System.out.println("2. Double");
            System.out.println("2. Long");
            System.out.println("Quit (or any key). Exit from program");

            switch {
                case "1":


            }
            while (inputType.equals("")) {
                inputType = locScanner.nextLine();
            }
            if (inputType.equals("1")) {
                locArrayList = ArrayBuilder.getIntegerArrayGenericType();
            } else if (inputType.equals("2")) {
                locArrayList = ArrayBuilder.getDoubleArrayGenericType();
            } else if (inputType.equals("3")) {
                locArrayList = ArrayBuilder.getLongArrayGenericType();
            } else {
                System.exit(1);
                return;
            }
            inputType = "";

            System.out.print("Input quantity analized elements: ");
            int tempVar = locScanner.nextInt();
            if (ArrayAlgoritms.inputElementsOfArray(locArrayList, QUANTITY_INPUTED_ELEMENTS, System.in)) {
                distance = ArrayAlgoritms.findDistanceBetweenMinElements(locArrayList, tempVar);
                System.out.println("Distance: " + distance);
            }
        }

    }

}
