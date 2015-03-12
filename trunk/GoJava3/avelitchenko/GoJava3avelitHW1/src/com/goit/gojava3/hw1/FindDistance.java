package com.goit.gojava3.hw1;

import java.util.Scanner;

public class FindDistance {

    public static void main(String[] args) {
        
        System.out.flush();
        System.out.println("Input string");
        
        Scanner sc = new Scanner(System.in);
        String inputLine = sc.nextLine();
        sc.close();
        
        int min1 = Integer.MAX_VALUE;
        int positionMin1 = 0;
        int min2 = Integer.MAX_VALUE;
        int positionMin2 = 0;
        
        String[] arrayString = inputLine.split("[ ]+");
        int currentPosition = 1;
        for(String str:arrayString){
            int currInt = Integer.parseInt(str);
            if (currInt <= min1) {
                min2 = min1;
                positionMin2 = positionMin1;
                min1 = currInt;
                positionMin1 = currentPosition;
            }
            currentPosition++;
        }
        System.out.println("minimal " + min1 + " & " + min2 + " on distance " + Math.abs(positionMin2 - positionMin1));
    }

}
