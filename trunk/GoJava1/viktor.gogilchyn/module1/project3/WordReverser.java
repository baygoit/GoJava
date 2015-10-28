/**
 * WordReverser - converts letters in words vice versa, keeping words order
 *
 * @version 0.2
 * 
 * @author Viktor "lslayer" Gogilchyn
 */

package ua.com.goit.gojava.lslayer.module1.project3;

import java.util.Scanner;

public final class WordReverser {
    private static final String DELIMETER = "[ ,.]+";
    private String              originalPhrase = null;

    public WordReverser() {
    }

    /**
     * Constructs an WordReverser containing specified String
     */
    public WordReverser(String receivedValue) {
        this.originalPhrase = receivedValue;
    }

    /**
     * Initializes an WordReverser with String
     * 
     * @param receivedValue
     *        String
     */
    public void setOriginalPhrase(String receivedValue) {
        this.originalPhrase = receivedValue;
    }

    /**
     * Returns the original phrase
     * 
     * @return Original phrase
     */
    public String getOriginalPhrase() {
        return this.originalPhrase;
    }

    /**
     * Reverses chars in words, returns result of reversing
     * 
     * @return Result of reversing
     */
    public String reverse() {
        if (this.originalPhrase == null) {
            this.originalPhrase = this.readFromConsole();
        }
        StringBuilder result = new StringBuilder();
        String[] wordsArray = this.originalPhrase.split(DELIMETER);
        for (String word : wordsArray) 
            result.append(new StringBuilder(word).reverse()+" ");
        return result.substring(0, result.length()-1).toString(); //Trim spaces
    }

    private String readFromConsole() {
        try {
            System.out.println("Enter phrase:");
            return new Scanner(System.in).nextLine();
        } catch (Throwable e) {
            System.err.println(e.getMessage());
            return "";
        } 
    }
}
