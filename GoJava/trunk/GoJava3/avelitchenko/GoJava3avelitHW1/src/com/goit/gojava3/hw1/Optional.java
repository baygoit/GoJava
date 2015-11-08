package com.goit.gojava3.hw1;

import java.util.HashMap;
import java.util.Map;

public class Optional {

    public static void main(String[] args) {

        int[] intArray = { 2, 3, 2, 4, 3, 7, 2, 3, 4, 4 };

        findByDictionary(intArray);

        findByRadix3(intArray);

    }

    public static void findByDictionary(int[] intArray) {
        HashMap<Integer, Integer> hashCountPresence = new HashMap<>();
        for (Integer number : intArray) {
            Integer amount = hashCountPresence.get(number);
            if (amount == null) {
                hashCountPresence.put(number, 1);
            } else {
                hashCountPresence.put(number, ++amount);
            }
        }
        for (Map.Entry<Integer, Integer> entry : hashCountPresence.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println("result 0: " + entry.getKey());
                break;
            }
        }
    }

    public static void findByRadix3(int[] intArray) {
        String result = "0";
        final int radix = 3;
        for (Integer number : intArray) {
            String elRadix3 = Integer.toString(number, radix);
            result = sumByModule3(result, elRadix3);
        }
        System.out.println("result 1: " + Integer.parseInt(result, radix));
    }

    public static String sumByModule3(String number1, String number2) {
        String localResult = "";
        int minLenght = Math.min(number1.length(), number2.length());
        // add 0..0 to begin
        if (number1.length() == number2.length()) {
            // do nothing
        } else if (minLenght < number2.length()) {
            number1 = "000000000000000000000000000000000"
                    .substring(0,number2.length() - minLenght) + number1;
        } else {
            number2 = "000000000000000000000000000000000"
                    .substring(0,number1.length() - minLenght) + number2;
        }
        // now both numbers have same length
        for (int i = 0; i < number2.length(); i++) {
            localResult += ((number1.charAt(i) - '0') + (number2.charAt(i) - '0')) % 3;
        }
        return localResult;
    }

}
