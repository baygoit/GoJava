package columndivision;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Division {
    private static final int RESULT_ACCURACY = 11;
    private static final String VERTICAL_SEPARATOR = "|";
    private static final String HORIZONTAL_SEPARATOR = "---";
    public static void main(String[] args) throws Exception{
        int[] numbersList = userInputDigits();
        printDivision(numbersList[0], numbersList[1]);
    }
    
    private static int[] userInputDigits() throws Exception {
        
        int[] list = new int[2];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String string = reader.readLine();
        String[] arrayOfStrings = string.split("/");
        try{
            for(int i = 0; i < arrayOfStrings.length; i++){
                list[i] = Integer.parseInt(arrayOfStrings[i]);

            }
        }
        catch(NumberFormatException e){
            e.printStackTrace();
        }
        return list;
    }

public static void printDivision(int divident, int divider) {

        StringBuilder wholeProcessDivision = new StringBuilder();
        StringBuilder indent = new StringBuilder();
        StringBuilder wholeNumber = new StringBuilder();
        StringBuilder firstCurrentMinus = new StringBuilder();
        StringBuilder fractionNumber = new StringBuilder();
        ArrayList<Integer> remains = new ArrayList<Integer>();
        StringBuilder processDivision = new StringBuilder();

        if (divident>0) {
            wholeProcessDivision.append("  " + divident + " " + VERTICAL_SEPARATOR + divider  + "\n");
        } else {
            wholeProcessDivision.append(" " + divident + " " + VERTICAL_SEPARATOR + divider  + "\n");
        }
        
        if (divident < 0 || divider < 0) {
            divident = Math.abs(divident);
            divider = Math.abs(divider);
            wholeNumber.append("-");
        }

        for (int i = 0; i <= RESULT_ACCURACY; i++) {
            int result = divident / divider;
            int remainder = divident % divider;
            int currentMinus = divider * result;
            if (i == 0) {
                firstCurrentMinus.append("  -").append(currentMinus);
                processDivision.append(indent).append(" ").append(HORIZONTAL_SEPARATOR).append("\n");
            } else {
                processDivision.append(indent).append(" ").append(divident).append("\n");
                processDivision.append(indent).append("-").append(currentMinus).append("\n");
                processDivision.append(indent).append(" ").append(HORIZONTAL_SEPARATOR).append("\n");
            }
            indent.append(" ");

            if (i == 0) {
                wholeNumber.append(result);
            } else {
                fractionNumber.append(result);
            }

            if (remainder == 0) {
                break;
            } else if (remains.contains(remainder)) {
                fractionNumber.insert(remains.indexOf(remainder), "(");
                fractionNumber.append(")");
                processDivision.append(indent).append(" ").append(remainder).append("\n");
                break;
            }

            divident = remainder * 10;
            remains.add(remainder);
        }
        
        if (fractionNumber.length() > 0) {
            fractionNumber.insert(0,".");
        }
        
        wholeProcessDivision.append(firstCurrentMinus).append("|").append(wholeNumber).append(fractionNumber).append("\n").append(processDivision);
        System.out.println(wholeProcessDivision);

    }
}
