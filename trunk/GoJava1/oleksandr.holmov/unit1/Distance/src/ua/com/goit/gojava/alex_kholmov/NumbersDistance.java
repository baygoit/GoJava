/**
 * 
 */
package ua.com.goit.gojava.alex_kholmov;

import java.util.Scanner;

/**
 * @author Alex Kholmov
 *
 */
public class NumbersDistance {

    private static final int MAX_VALUE = 2147483647;

    /**
     * @param args
     */
    public static void main(String[] args) {
        //find two min elements in array
        
        //input string and convert to array of string
        String inpString = inputString();
        
        //convert array of string into array of int
        int[] intArray = convertArrStringToArrInt(inpString);
            
        //find elements and return indexes of this elements
        int[] indexArray = findIndxsOfTwoMinElem(intArray);
            
        //find index distance
        indxDistanceBetweenTwoNum(indexArray);

    }
    //method return input string
    public static String inputString() {
        String msg1 = "Enter space separated sequence of numbers: ";

        Scanner scan = new Scanner(System.in);
        
        System.out.print(msg1);
        String strInput = scan.nextLine();
        scan.close();

        return strInput; 
    }
    //method convert input string to array of int
    public static int[] convertArrStringToArrInt(String inpStr) {
        String regex = "\\s+";
        //convert string to array with a reg. expression
        String[] strArray = inpStr.split(regex);
        
        int[] intArray = new int[strArray.length]; 
        //convert each string elements to int
        try {
            for (int i = 0; i < strArray.length; i++) {
                intArray[i] = Integer.parseInt(strArray[i]);
            }
        } catch (NumberFormatException e) {
            System.err.println("The string must contain only numbers!");
        }
        return intArray;
    }
    //method find two min elements in array and return an array of index of this elements
    public static int[] findIndxsOfTwoMinElem(int[] iArray) {
        int min1 = 0, min2 = MAX_VALUE;
        int indx1 = 0, indx2 = 0;
        min1 = iArray[0];
        for (int i = 1; i < iArray.length; i++) {
            if (iArray[i] < min1) {
                min2 = min1;
                indx2 = indx1;
                min1 = iArray[i];
                indx1 = i;
            } else if (iArray[i] > min1 && iArray[i] < min2) {
                min2 = iArray[i];
                indx2 = i;
            }
        }
        int[] indxArray = {indx1, indx2};
        return indxArray;
    }
    //display result method
    public static void indxDistanceBetweenTwoNum(int[] iArray) {
        int diff = Math.abs(iArray[0] - iArray[1]);
        System.out.println("Index distance between two minimal elemests: " +diff);
    }
}
