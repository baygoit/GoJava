package ua.com.goit.gojava.lslayer.module1.project2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayMinDistance {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                System.in));
        System.out.println("Enter numbers, delimitered by spaces");
        String inputString = reader.readLine();
        int PositionMin1 = -1;
        int PositionMin2 = -1;
        int Min1 = Integer.MAX_VALUE;
        int Min2 = Integer.MAX_VALUE;
        int iterator = 0;
        try {
            for (String element : inputString.split("[ ]+")) {
                int currentValue = Integer.parseInt(element);
                if ((currentValue < Min1) || (currentValue < Min2)) {
                    if (Min2 > Min1) {
                        Min2 = Min1;
                        PositionMin2 = PositionMin1;
                    }
                    Min1 = currentValue;
                    PositionMin1 = iterator;
                }
                iterator++;
            }
        } catch (NumberFormatException e) {
            System.err.print(e.getMessage());
        }
        System.out.println("Minimal numbers are: " + Min1
                + " and " + Min2
                + ", distance between them are "
                + Math.abs((PositionMin2 - PositionMin1)));
    }

}
