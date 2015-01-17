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
    
    //method reverse input string
    public static String reverseInputString(String inpStr) {
        int startWordIndex, endWordIndex; //index begin and end word which find
        String strReverse = "";
        Character ch;
        
        //convert string to char array
        char[] charArray = inpStr.toCharArray();
        
        //reversing string
        for (int i = 0; i < charArray.length; i++) {
            ch = new Character(charArray[i]);
            if (Character.isAlphabetic(ch)) {
                startWordIndex = i;
                do {
                    ch = charArray[i];
                    i++;
                } while (Character.isAlphabetic(ch));
                endWordIndex = i - 2;
                for (int j = endWordIndex; j >= startWordIndex; j--) {
                    strReverse += charArray[j];
                }
                i -= 2;
            } else {
                strReverse += ch;
            }
        }
        return strReverse;
    } 
}
