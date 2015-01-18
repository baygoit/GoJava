/**
 * 
 */
package ua.com.goit.gojava.alex_kholmov;

import java.util.Scanner;

/**
 * @author Alex Kholmov
 *
 */
public class ReverseString {

    /**
     * @param args
     */
    public static void main(String[] args) {
 
        String inpStr = inputString();
        String revStr = reverseInputString(inpStr);
        
        //display result
        System.out.println("Invert string: " + revStr);

    }
    
    //method return input string
    public static String inputString() {
        String msg1 = "Enter string: ";
        String strInput = "";
        
        // get string from input
        Scanner scan = new Scanner(System.in);
        System.out.print(msg1);
        strInput = scan.nextLine();
        scan.close();
        
        return strInput;
    }
    
    // method reverse input string
    public static String reverseInputString(String inpStr) {
        int startWordIndex, endWordIndex; // index begin and end word which find
        String strReverse = "";

        // convert string to char array
        char[] charArray = inpStr.toCharArray();

        // reversing string
        int i = 0;
        while (i < charArray.length) {
            if (Character.isAlphabetic(charArray[i])) {
                startWordIndex = i;
                while (i < charArray.length && Character.isAlphabetic(charArray[i])) {
                    i++;
                }
                endWordIndex = i - 1;
                i--;
                for (int j = endWordIndex; j >= startWordIndex; j--) {
                    strReverse += charArray[j];
                }
            } else {
                strReverse += charArray[i];
            }
            i++;
        }
        return strReverse;
    } 
}
