package distance;

import java.util.Scanner;

public class Distance {

    public static void main(String[] args) {

        Scanner scanConsole;
        int  distance;
        int max1 = Integer.MAX_VALUE;
        int max2 = Integer.MAX_VALUE;
        int firstMinIndex = -1;
        int secondMinIndex = -1;

        System.out.println("Enter the console 10 number: ");
        scanConsole = new Scanner(System.in);
        int array[] = new int[10];

        try {
            scanConsole.hasNextInt();
            for (int i = 0; i < array.length; i++){
                array[i] = scanConsole.nextInt();
            }

            for (int i = 0; i < array.length; i++) {
                if (array[i] < max1) {
                    max2 = max1;
                    secondMinIndex = firstMinIndex;
                    max1 = array[i];
                    firstMinIndex = i;
                } else if (array[i] < max2) {
                    max2 = array[i];
                    secondMinIndex = i;
                }
            }
            distance = Math.abs(firstMinIndex - secondMinIndex);
            System.out.println("Distance = " + distance);

        } catch (Exception e) {
            System.out.println("You entered is not a number!");
        }
    }
}