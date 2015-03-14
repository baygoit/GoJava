package com.goit.gojava3.hw1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        int limitIterations = 20;
        List<Integer> leftPart = new ArrayList<>();
        List<Integer> leftPartAdditional = new ArrayList<>();
        int[] result = new int[limitIterations];

        System.out.flush();
        System.out.println("Input string");

        Scanner sc = new Scanner(System.in);
        String inputLine = sc.nextLine();
        sc.close();

        String[] arrayString = inputLine.split("/");

        if (arrayString.length != 2) {
            System.out.println("wrong string, must be x/y");
            System.exit(0);
        }
        char[] firstNumberChar = arrayString[0].toCharArray();
        Integer secondNumber = Integer.parseInt(arrayString[1]);

        int i = 0;
        Integer curNumber = 0;
        Integer curNumberAdditional = 0;

        // finding first real number
        while (curNumber < secondNumber && i < firstNumberChar.length) {   
            curNumber = curNumber * 10  + (firstNumberChar[i] - '0');
            i++;
        }

        int startNumber = i;// for output without 0

        int pointNumber = limitIterations + 1;
        int bracketNumber = limitIterations + 1;

        do {
            if (curNumber < secondNumber) {
                curNumber = curNumber * 10
                        + ((i < firstNumberChar.length) ? (firstNumberChar[i] - '0') : 0);
                result[i] = 0;
                leftPart.add(0);
                leftPartAdditional.add(0);
                if (i >= firstNumberChar.length && pointNumber == limitIterations + 1) {
                    pointNumber = i; 
                }
                continue;
            }
            
            if (leftPart.contains(curNumber) && leftPart.indexOf(curNumber) > pointNumber){
                bracketNumber = leftPart.indexOf(curNumber) - 1;
                i--;
                break;
            }

            result[i] = curNumber / secondNumber;
            
            leftPart.add(curNumber);
            curNumber %= secondNumber;
            curNumberAdditional = secondNumber * result[i];
            leftPartAdditional.add(curNumberAdditional);
            i++;
        } while ((i < limitIterations)
                && !(curNumber == 0 && i > firstNumberChar.length - 1));

        System.out.println(arrayString[0] + "|" + arrayString[1]);
        System.out.print("                  ".substring(0, arrayString[0].length()) + "|");
        for (int j = startNumber; j < i && j < limitIterations; j++) {
            if (j == pointNumber) {
                System.out.print(".");
            }
            if (j == bracketNumber) {
                System.out.print("(");
            }
            System.out.print(result[j]);
        }
        if (bracketNumber < limitIterations) {
            System.out.print(")");
        }
        System.out.println();
        
        String indent = "";
        for (int j = 0; j < leftPart.size(); j++) {
            if (leftPart.get(j) > 0 && leftPartAdditional.get(j) > 0) {
                System.out.println(indent + leftPart.get(j));
                System.out.println(indent + leftPartAdditional.get(j));
            }
            indent += " ";
        }

    }

}
