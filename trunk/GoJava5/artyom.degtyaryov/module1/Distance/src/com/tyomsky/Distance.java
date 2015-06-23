package com.tyomsky;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Distance {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); //todo: вынести в глобальную переменную
        int[] inputArray;
        int distanceBetweenMins;

        System.out.println("Enter values:");
        inputArray = getArrayOfIntegersFromConsole(reader);
        if (inputArray == null) {return;}

        distanceBetweenMins = getDistanceBetweenMins(inputArray);
        System.out.println("Distance between mins: "+distanceBetweenMins);
    }

    private static int getDistanceBetweenMins(int[] inputArray) {
        if(inputArray != null && inputArray.length > 1){
            int firstMinValueIndex = 0;
            int secondMinValueIndex = 0;
            for (int i = 0; i < inputArray.length; i++) {
                if (inputArray[firstMinValueIndex] <= inputArray[i]) {firstMinValueIndex = i;}
            }
            for (int i = 0; i < inputArray.length; i++) {
                if (i == firstMinValueIndex) {continue;}
                if (inputArray[secondMinValueIndex] <= inputArray[i]) {secondMinValueIndex = i;}
            }
            return Math.abs(firstMinValueIndex - secondMinValueIndex);
        }
        return 0;
    }

    public static int[] getArrayOfIntegersFromConsole(BufferedReader reader){
        String[] inputStringArray;
        int[] result;
        try {
            inputStringArray = reader.readLine().split(" ");
            result = new int[inputStringArray.length];
            for (int i = 0; i < inputStringArray.length; i++){
                result[i] = Integer.parseInt(inputStringArray[i]);
            }
        }catch (Exception e){ /// думаю тут  не важно что ловить
            System.out.println("Invalid input");
            return null;
        }
        return result;
    }

}
