package ua.com.goit.gojava.alkot;

import java.util.Scanner;

public class TwoNumbersDistance {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("¬ведите р€д целых чисел через пробел:");
        String s = scan.nextLine();
        scan.close();

        String[] strNumArray = s.split(" ");

        int min1, min2, n = strNumArray.length;

        int[] numArray = new int[n];
        for(int i = 0; i < n; i++)
            numArray[i] = Integer.parseInt(strNumArray[i]);

        min1 = 0;
        min2 = 1;
        if (numArray[0] > numArray[1] ) {
            min1 = 1;
            min2 = 0;
        }	

        for(int i = 2; i < n; i++)
            if (numArray[i] < numArray[min2]) 
                if (numArray[i] < numArray[min1]) {
                    min2 = min1;
                    min1 = i;	
                } 
                else min2 = i;

        System.out.println(Math.abs(min1-min2));

    }
}