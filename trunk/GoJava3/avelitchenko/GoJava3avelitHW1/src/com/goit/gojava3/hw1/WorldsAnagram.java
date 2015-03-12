package com.goit.gojava3.hw1;

import java.util.Scanner;

public class WorldsAnagram {

    public static void main(String[] args) {
        
        System.out.flush();
        System.out.println("Input string");
        
        Scanner sc = new Scanner(System.in);
        String inputLine = sc.nextLine();
        sc.close();
        
        StringBuilder builder = new StringBuilder();
        
        String[] arrayString = inputLine.split("[ ]+");
        for(String str:arrayString){
            for(int i = 0; i < str.length(); i++){
                builder.append(str.charAt(str.length() - i - 1));
            }
            builder.append(" ");
        } 
        System.out.println("result: " + builder.toString());
    }

}
