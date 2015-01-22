package ua.com.goit.gojava.andriidnikitin;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class DivisionUnit {
	
	public static final double MAX_FRACTAL_DEPTH = 35;	
	
	public static int FRACTAL_IS_NOT_SYSTEMATIC = -1;
				
	public static void main(String[] args) throws IOException{
		
		int dividend;
		int divider;	
		try(Scanner inputSource = new Scanner(System.in)){
			System.out.println ("Type input numbers:"
					+ "");
			System.out.println ("dividend = ");	
			dividend = getIntNumber(inputSource);
			System.out.println("divider = ");
			divider = getIntNumber(inputSource);
			System.out.println(longDivision(dividend, divider));
		}
		catch (IllegalArgumentException e){
			System.out.println("Wrong input!");
		}
	}
	
	public static String longDivision(int inputDividend, int inputDivider){
		if (inputDividend == 0){			
			return divisionZeroDividendCase(inputDividend, inputDivider);
		}
		
		if (inputDivider == 0) {
			return divisionZeroDividerCase(inputDividend, inputDivider);
		}				
		else {
			return divisionRegularCase(inputDividend, inputDivider);
		}
	}
			
	private static String divisionZeroDividendCase(int inputDividend, 
			int inputDivider){
		
		if (inputDivider == 0) {
			return "Not a Number";
		}
		else {
			return "0"; 	
		}
	}
	
	private static String divisionZeroDividerCase(int inputDividend, 
			int inputDivider){
		
		return "infinity";
	}
	
	private static String divisionRegularCase(int inputDividend, 
			int inputDivider){
		
		String result = "0";
		
		int dividendFractive = inputDividend % inputDivider;
		
		int dividendNatural = inputDividend - dividendFractive;
		
		if (dividendNatural != 0) {
			result = Integer.valueOf(divisionNaturalPart(inputDividend, 
					inputDivider)).toString(); 
		}
					
		if (dividendFractive != 0){
			result+= divisionFractivePart(dividendFractive, 
					inputDivider);
		}
		else {
			result+= ".0";
		}
		
		return result;
	}	
	
	private static int divisionNaturalPart(int inputDividend, int divider){
		
		int dividend = inputDividend;
		
		Stack<Integer> dividendDigits = numberToStackOfDigits (dividend);
		
		int resultNatural = 0;
		
		dividend = 0;
		
		while (!dividendDigits.empty()) {
						
			if (dividend < divider) {
				dividend = dividend * 10 + (Integer)dividendDigits.pop(); 
				if (dividend < divider){
					resultNatural = resultNatural * 10;
				}					
			}
			
			if (dividend >= divider) {
				resultNatural = resultNatural * 10 + dividend / divider;	
				int newDividend = dividend % divider;
				writeDividendAndSubtrahend(dividend, dividend - newDividend);
				dividend = dividend % divider;
			}
		}
		return resultNatural;
	}
	
	private static Stack<Integer> numberToStackOfDigits(int inputNumber){
		Stack<Integer> dividendDigits = new Stack<Integer>();
		while (inputNumber > 0){
			dividendDigits.push(inputNumber % 10);
			inputNumber = inputNumber / 10;
		}
		return dividendDigits;
	}

	private static String divisionFractivePart(int dividend, int divider){
		
		StringBuilder resultRow = new StringBuilder(); 
		int periodisedElement = FRACTAL_IS_NOT_SYSTEMATIC;
		boolean pushZeroToResult = false;
		List<Integer> dividendList = new ArrayList<Integer>();
		for (int position = 0; position < MAX_FRACTAL_DEPTH; position++){
			if (dividendListContainsDividend(dividend, dividendList)){
				periodisedElement = indexOfElementInDividendList(dividend, dividendList);
				break;
			}					
			
			if (dividend!= 0){
				while (dividend < divider) { 
					if (pushZeroToResult){
						position++;
						resultRow.append('0');
					}
					dividend = dividend * 10;
					pushZeroToResult = true;					
				}
			}
			else {
				break;
			}
			
			pushZeroToResult = false;
			
			dividendListAdd(dividendList, dividend);
			resultRow.append(dividend / divider);
			int tempSubtrahend = dividend % divider;
			writeDividendAndSubtrahend(dividend, tempSubtrahend);
			dividend = tempSubtrahend;
		}
		
		return formattedResult(resultRow, periodisedElement);
	}
	
	private static int indexOfElementInDividendList(int element, List<Integer> list){
		element = cutZerosFromEnd(element);
		return list.indexOf(element);
	}
	
	private static boolean dividendListContainsDividend(int element, List<Integer> list){
		return list.contains(cutZerosFromEnd(element));
	}
	
	
	private static String formattedResult(StringBuilder resultRow, int periodisedElement ){
		String result = resultRow.toString();
		if (periodisedElement != FRACTAL_IS_NOT_SYSTEMATIC) {
			if (periodisedElement == 0) result = "(" + result + ")";	
			else 
				result = result.substring(0, periodisedElement) 
				+"(" + result.substring(periodisedElement) + ")";
		}
		return "." + result;
	}
	
	private static void dividendListAdd(List<Integer> dividendVector, int number) {
			number = cutZerosFromEnd(number);
		dividendVector.add(number);
	}
	
	private static int cutZerosFromEnd(int number){
		while ((number != 0) && (number % 10 == 0)) {
			number = number / 10;
		}
		return number;
	}
	
	
	
	private static int getIntNumber(Scanner inputSource) 
			throws NumberFormatException{
		
		String input = inputSource.nextLine();
		return Integer.parseInt(input);
	}	
	
	private static void writeDividendAndSubtrahend(int dividend, int subtrahend){
		
	}
}