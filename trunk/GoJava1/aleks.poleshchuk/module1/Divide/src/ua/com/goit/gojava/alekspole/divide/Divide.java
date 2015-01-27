package ua.com.goit.gojava.alekspole.divide;

import java.util.List;
import java.util.ArrayList;

public class Divide {

	
	public static int[] dividendToArray(int dividend) {
        String stringDividend = Integer.toString(dividend);
        int[] dividendAsArray = new int[stringDividend.length()];
        for (int i = 0; i < dividendAsArray.length; i++) {
                dividendAsArray[i] = Integer.parseInt(Character.toString(stringDividend.charAt(i)));
        }
        return dividendAsArray;
        
	}
	
	
	public static String formatPeriodResult(int index, String result) {
        int dotIndex = result.indexOf(".");
        String beforeParenthesis = result.substring(0, index + dotIndex + 2);
        String inParenthesis = result.substring(index + dotIndex + 2, result.length());
        beforeParenthesis += "(";
        inParenthesis += ")";
        return beforeParenthesis + inParenthesis;
	}
	
	
	 public static String repeatString(String space, int numberOfSpaces) {
         String result = "";
         for (int i = 1; i <= numberOfSpaces; i++) {
                 result += space;
         }
         return result;
	 }

	 public static String tab(int currentNumberToCalculateSpaces, int width) {
         String tab = "";
         int length = Integer.toString(currentNumberToCalculateSpaces).length();
         tab = repeatString(" ", width - length);
         return tab;
	 }
	
	
	 public static String calculateResult(int dividend, int divisor, int[] dividendAsArray, List<String> resultList) {
         
		 int reminder = 0;
         int part = dividendAsArray[0];
         int[] reminderArray = new int[10];
         boolean isPeriod = false;
         boolean isFirst = false;
         String result = "";
         
         
         resultList.add(" " + dividend);
        
         int j = 0;
         while (part < divisor && part != dividend) {
                 part = part * 10 + dividendAsArray[j + 1];
                 j++;
         }

         int tempResult = 0;
         while (j < dividendAsArray.length) {
                 result += part / divisor;
                 if (part / divisor > 0) {
                         tempResult = (part / divisor) * divisor;
                         if (isFirst) {
                        	 	resultList.add(tab(part, j) + " " + part);
                         }
                         resultList.add(tab(tempResult, j) + "-" + tempResult);
                         resultList.add(tab(tempResult, j) + " " + "---");
                 }
                 reminder = part % divisor;
                
                 if (j == (dividendAsArray.length - 1)) {
                         part = reminder * 10;
                 } else {
                         part = reminder * 10 + dividendAsArray[j + 1];
                 }
                 j++;
                 isFirst = true;
         }

         if (reminder != 0) {
                 result += ".";
         }

         int i = 0;
         int fraction = 0;
         int periodIndex = 0;
         while (reminder != 0 && fraction < 10 && !isPeriod) {
                 for (int k = 0; k < reminderArray.length; k++) {
                         if (reminder == reminderArray[k]) {
                                 isPeriod = true;
                                 periodIndex = k - 1;
                                 break;
                         }
                 }
                 if (part / divisor > 0) {
                         tempResult = (part / divisor) * divisor;
                         resultList.add(tab(part, j) + " " + part);
                         resultList.add(tab(tempResult, j) + "-" + tempResult);
                         resultList.add(tab(tempResult, j) + " " + "---");
                 }
                 reminderArray[i] = reminder;
                 reminder = part % divisor;
                 if (!isPeriod) {
                         result += part / divisor;
                         part = reminder * 10;
                         fraction++;
                         i++;
                         j++;
                 }
         }
         if (isPeriod && reminder != 0) {
                 return formatPeriodResult(periodIndex, result);
         } else {
                 return result;
         }
	 }
	
	 
	 public static void showDivision (List<String> resultList, int dividend, int divisor, String result, int pos){
		 System.out.println(dividend + " | " + divisor);
		 System.out.println(resultList.get(1) + tab(1,pos)+ result);
		 for (int i=2; i<resultList.size(); i++){
			 System.out.println(resultList.get(i));
		 }
		 
	 }
	 
	
	
	public static void main (String[] args){
		
		if (args.length == 0){
			System.out.println("Input something");
			return;
		}
		int pos = args[0].indexOf("/");
		if (pos == -1) {
			System.out.println("/ not found");
			return;
		}
		
		int divisor;
		int dividend;
		
		try {
			dividend = Integer.parseInt(args[0].substring(0, pos));
			divisor = Integer.parseInt(args[0].substring(pos+1, args[0].length()));
		} catch (NumberFormatException e) {
			throw new NumberFormatException("Cannot convert numbers to int!");
		}
		
		if (divisor == 0) {
			System.out.println ("Can't divide with 0");
			return;
		}
		
		
		int[] dividendAsArray = dividendToArray(dividend);
		List<String> resultList = new ArrayList<String>();
		
		String result = calculateResult(dividend, divisor, dividendAsArray, resultList);
		showDivision(resultList, dividend, divisor, result, pos);
		
	}
	
	
	
}
