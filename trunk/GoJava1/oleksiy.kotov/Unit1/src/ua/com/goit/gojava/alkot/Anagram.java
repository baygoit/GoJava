package ua.com.goit.gojava.alkot;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @author tima.peaceworld
 */
public class Anagram {
        
        public void startProcessing() {
                
                System.out.println("----- Enter a sentence and get reversed version of it. "
                                                        + "To exit enter sc -exit; -----");
                
                String line;
                while (!(line = enterSent()).equals("sc -exit;")) {
                        System.out.println("The reversed sentence: " + getReversedSent(line));          
                }
                System.out.println("**** The App closed ****");
        }
        
        private String enterSent() {
                System.out.print("\nEnter a sentence: ");
                return new Scanner(System.in).nextLine();
        }       
        
        private String getReversedSent(String sentence) {
                String delimiters = " ,.!?@#$%^&*()-_=+<>/\';:[]{}|~`\""; // The symbols will not revers.
                StringTokenizer token = new StringTokenizer(sentence, delimiters, true);
                
                String resultString = "";
        
                while (token.hasMoreTokens()){
                        resultString += new StringBuffer(token.nextToken()).reverse();
                }
                return resultString;
        }
        
        public static void main(String[] args) {
                Anagram anagramOb = new Anagram();
                anagramOb.startProcessing();
        }
}
//
//import java.util.Scanner;
//
//public class Anagram {
//
//    public static void main(String[] args) {
//
//        Scanner scan = new Scanner(System.in);
//
//        System.out.println("¬ведите фразу:");
//        String s = scan.nextLine();
//        scan.close();
//
//        String[] alphabeticStringsArray = s.split("[^a-zA-Zа-€ј-я]+");
//        String[] otherStringsArray = s.split("[a-zA-Zа-€ј-я]+");
//
//        String result = "";
//        int maxIndex = Math.max(alphabeticStringsArray.length,
//                otherStringsArray.length);
//
//        if (alphabeticStringsArray[0].equals("")) // то фраза начинаетс€ с
//                                                  // разделител€, а не буквы
//            for (int i = 0; i < maxIndex; i++) {
//                if (i < otherStringsArray.length)
//                    result += otherStringsArray[i];
//                if (i + 1 < alphabeticStringsArray.length)
//                    result += reversOfString(alphabeticStringsArray[i + 1]);
//            }
//        else
//            for (int i = 0; i < maxIndex; i++) {
//                if (i < alphabeticStringsArray.length)
//                    result += reversOfString(alphabeticStringsArray[i]);
//                if (i + 1 < otherStringsArray.length)
//                    result += otherStringsArray[i + 1];
//            }
//        System.out.println(result);
//
//    }
//
//    private static String reversOfString(String str) {
//
//        String reversedStr = "";
//        int strLen = str.length();
//
//        for (int j = strLen - 1; j >= 0; j--)
//            reversedStr = reversedStr + str.substring(j, j + 1);
//        return reversedStr;
//
//    }
//}
