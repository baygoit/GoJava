package anagram;


import java.io.*;
import java.util.*;

public class Anagram {
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String input = in.nextLine();
        
        Reverse reversedWord= new Reverse(input);
        System.out.print(reversedWord.change());

    }
}