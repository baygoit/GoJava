package distance;

import java.util.Scanner;

public class Distance {

    private static int  distance;
    private static int max1 = Integer.MAX_VALUE;
    private static int max2 = Integer.MAX_VALUE;
    private static int firstMinIndex = -1;
    private static int secondMinIndex = -1;

    public static void main(String[] args) {

        System.out.println("Enter the console 10 number: ");
        Scanner scanConsole = new Scanner(System.in);
        int array[] = new int[10];

        parser(scanConsole, array);
        calculation_distance(array);

        System.out.println("Distance = " + distance);
    }

    private static void calculation_distance(int[] array) {
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
    }

    private static void parser(Scanner scanConsole, int[] array) {
        int count = 0;
        while (count < 10) {
            if (scanConsole.hasNextInt()) {
                array[count++] = scanConsole.nextInt(); //При каждой итерации ложишь новое значение в новую ячейку
            } else {
                String input = scanConsole.next();  // А почему не nextLine() ?
                System.out.println("Your input: \"" + input + "\" is not a number");
            }
        }
    }
}