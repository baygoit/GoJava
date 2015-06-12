package anagram;

import java.io.*;
import java.util.*;

public class Anagram {
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("New Changes!!!!!!!!!!!!!");
        System.out.println("Changes!!!!!!!!!!!!!");
        System.out.println("Enter a sentence:");
        String input = in.nextLine();
        
        String[] arrayString = input.split(" ");
        
        for ( int i = 0; i < arrayString.length; i++ ) {
            String reverse = new StringBuffer(arrayString[i]).reverse().toString();
            System.out.print(reverse + " ");
        }
    }
}