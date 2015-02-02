package ua.com.goit.gojava1.grigorius0sol.Division;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Division{
	
	static private String input;
	static private List<Integer> numbersFromString = new ArrayList<Integer>();
	static private StringBuilder quotient = new StringBuilder();
	static private List<StringBuilder > visualize = new ArrayList<StringBuilder>();
	static private int tempDivisor;
	static private int tempRemainder;
	static private int tempQuotient ;
	static private int tempResult;
	static private int dividen;
	static private int divider;
	static private int tab;
	
	
	public static void main(String args[]){
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please enter two numbers like 1/2");
		
		try {
			input = reader.readLine();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		tab++;
		getNumbersFromString(input);
		
		for(StringBuilder value: visualize){
			
			System.out.println(value);
		}
	}
	
	public static void getNumbersFromString(String source){
		
		
		List<String> tempList = Arrays.asList(source.split("/"));
		for (int i = 0; i < tempList.size(); i++) {
			
			int x = Integer.parseInt(tempList.get(i));
			numbersFromString.add(x);

		}
		
		divider = numbersFromString.get(0);
		dividen = numbersFromString.get(1);

		writeIn(divider + " | " + dividen, tab);
		
		divide(divider, dividen);
	}
	
	public static void divide(int divider, int dividen){
		
		String dividerToString = String.valueOf(divider);
		
		int nextValue = 0;
		while(nextValue < dividerToString.length()){
			
			tempDivisor = tempRemainder * 10 + Integer.parseInt(dividerToString.substring(nextValue, nextValue + 1));
			tempQuotient = tempDivisor / dividen;
			quotient.append(tempQuotient);
			
			tempResult = tempQuotient * dividen; 
			tempRemainder = tempDivisor -  tempResult;  
			
			nextValue++;
		}
		
		
		
		if(tempRemainder != 0){
			
			fractionDivide();
            
		}

		if (quotient.charAt(0) == '0') {
            int counter = 0;
            int i = 0;
            while (quotient.charAt(i) == '0') {
                    counter++;
                    i++;
            }
            if (quotient.charAt(i) == '.') {
                    counter--;
            }
            quotient.delete(0, counter);
		}
		
		visualize.add(1,new StringBuilder("    | " + quotient));
	}
	
	
	public static void fractionDivide(){
		
		
		StringBuilder fractionPartResult = new StringBuilder(100);
		List<Integer> fractionRemainder = new ArrayList<Integer>(100);
		int indexPeriodRepeat;
		
		while(fractionRemainder.size() < 100){
			
			indexPeriodRepeat = getIndexPeriodRepeat(fractionRemainder);
			if (indexPeriodRepeat != -1) {
				fractionPartResult.insert(indexPeriodRepeat, "(");
				fractionPartResult.append(")");
                break;
			}
			
			fractionRemainder.add(tempRemainder);
			tempDivisor = tempRemainder * 10;
			tempQuotient = tempDivisor / dividen;
			fractionPartResult.append(tempQuotient);
			tempResult = tempQuotient * dividen;
			tempRemainder = tempDivisor - tempResult;
			
			outPut(tempDivisor, tempResult, tempRemainder);
			
			if(tempRemainder == 0){
				break;
			}
		}
		quotient.append(".");
        quotient.append(fractionPartResult);

	}
	
	public static int getIndexPeriodRepeat(List<Integer> remainder) {
        for (int i = 0; i < remainder.size()-1; i++) {
                if (remainder.get(remainder.size() - 1).equals(remainder.get(i))) {
                        return i;
                }
        }
        return -1;
	}
	
	public static void outPut(int minuend, int subtrahend, int difference){
		
		String minuendToString = "" + minuend;
		String subtrahendToString = "" + subtrahend;
		String differenceToString = "" + difference;
		int aditionalTab = minuendToString.length() - subtrahendToString.length(); 
		
		writeIn(minuendToString, tab);
		writeIn("-" + subtrahendToString, tab - 1 + aditionalTab);
		writeIn("-----", tab);
		
		
		tab += (minuendToString.length() - differenceToString.length());
		if(difference == 0){
			
			tab++;
		}
		
	}

	public static void writeIn(String value, int tabulation){
		visualize.add(new StringBuilder(""));
		
		for(int i = 0; i < tabulation; i++){
			visualize.get(visualize.size() - 1).append(" ");
		}

		visualize.get(visualize.size() - 1).append(value);
	}
}