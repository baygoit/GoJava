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
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (Integer el : intArray) {
            Integer amount = hash.get(el);
            if (amount == null) {
                hash.put(el, 1);
            } else {
                hash.put(el, ++amount);
            }
        }
        for (Map.Entry<Integer, Integer> h : hash.entrySet()) {
            if (h.getValue() == 1) {
                System.out.println("result 0: " + h.getKey());
                break;
            }
        }
    }
    public static void findByRadix3(int[] intArray) {
        String result = "0";
        final int radix = 3;
        for (Integer el : intArray) {
            String elRadix3 = Integer.toString(el, radix);
            result = sumByModule3(result,elRadix3);
        }
        System.out.println("result 1: " + Integer.parseInt(result, radix));
    }

    public static String sumByModule3(String str1,String str2) {
        String localResult = "";
        int minLenght = Math.min(str1.length(), str2.length());
        // add 0..0 to begin
        if (minLenght < str2.length()) {
            str1 = "000000000000000000000000000".substring(0, str2.length() - minLenght) + str1;
        }
        else if (minLenght < str1.length()){
            str2 = "000000000000000000000000000".substring(0, str1.length() - minLenght) + str2;
        }
        // now both str have same length
        for (int i = 0; i < str2.length(); i++) {
            localResult += String.valueOf(((Integer.parseInt(str1.substring(i,i + 1)) + Integer.parseInt(str2.substring(i,i + 1))) % 3));
        }
        return localResult;
    }

}
