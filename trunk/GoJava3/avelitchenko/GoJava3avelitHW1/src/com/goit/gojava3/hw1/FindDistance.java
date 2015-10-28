package com.goit.gojava3.hw1;

import java.util.Scanner;

public class FindDistance {

    public static void main(String[] args) {
        
        System.out.flush();
        System.out.println("Input string, 'e' for end of input");
        
        Scanner sc = new Scanner(System.in);
        
        int min1 = Integer.MAX_VALUE;
        int positionMin1 = 0;
        int min2 = Integer.MAX_VALUE;
        int positionMin2 = 0;
        int localElement;
        int currentPosition = 1;
        
        while (sc.hasNextInt()) {
            localElement = sc.nextInt(); 
            if (localElement <= min1) {
                min2 = min1;
                positionMin2 = positionMin1;
                min1 = localElement;
                positionMin1 = currentPosition;
            }
            if (currentPosition == 2) {
                if (min1 < localElement) {
                    min2 = localElement;
                    positionMin2 = 2;
                } else {
                    min2 = min1;
                    positionMin2 = 1;
                }
                
            }
            currentPosition++;
        }
        sc.close();
        Integer distance = Math.abs(positionMin2 - positionMin1);
        System.out.printf("minimal %d & %d on distance %d",min1,min2,distance);
    }

}
