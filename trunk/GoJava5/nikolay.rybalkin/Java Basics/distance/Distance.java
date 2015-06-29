package distance;

import java.util.Scanner;

public class Distance {

    public static void main(String[] args) {

        System.out.println("Enter the console 10 number: ");
        Scanner scanConsole = new Scanner(System.in);
        int array[] = new int[10];

        for(int i = 0; i <= array.length - 1; i++){
            if(scanConsole.hasNextInt() == true){
                array[i] = scanConsole.nextInt();
            }else{
                break;
            }
        }

        int  distance;
        int max1 = Integer.MAX_VALUE;
        int max2 = Integer.MAX_VALUE;
        int firstMinIndex = -1;
        int secondMinIndex = -1;

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
    }

    public static boolean checkingTheNumber(Scanner s){
        try {
            s.nextInt();
            return true;
        } catch (Exception e) {
            System.out.println("You entered is not a number!");
            return false;
        }
    }
}