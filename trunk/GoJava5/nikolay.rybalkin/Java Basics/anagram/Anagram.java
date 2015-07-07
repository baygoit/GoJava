package anagram;

import java.util.Scanner;


public class Anagram {

    private static String SPACE = " ";
    private static Scanner scanConsole;
    private static String ewer = "_";

    public static void main(String[] args) {

        System.out.println("Enter the console words separated by a space, then press enter: ");
        scanConsole = new Scanner(System.in);
        String line = scanConsole.nextLine();
        String[] array = line.split(SPACE);

        for(int i = 0; i < array.length; i++) {
            System.out.print(new StringBuilder(array[i]).reverse().toString());
            if (i < array.length - 1){
                System.out.print(ewer);
            }
        }
    }
}