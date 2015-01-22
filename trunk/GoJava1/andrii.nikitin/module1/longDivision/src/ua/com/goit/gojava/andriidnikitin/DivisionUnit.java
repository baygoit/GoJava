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
		
		List<StringBuilder> log = new ArrayList<StringBuilder>();
		
		String result = "0";
		
		int dividendFractive = inputDividend % inputDivider;
		
		int dividendNatural = inputDividend - dividendFractive;
		
		if (dividendNatural != 0) {
			result = Integer.valueOf(divisionNaturalPart(inputDividend, 
					inputDivider, log)).toString(); 
		}
					
		if (dividendFractive != 0){
			result+= divisionFractivePart(dividendFractive, 
					inputDivider, log);
		}
		else {
			result+= ".0";
		}
		
		for (int i = 0; i < log.size(); i++){
			System.out.println(log.get(i));
		}
		
		return result;
	}	
	
	private static int divisionNaturalPart(int inputDividend, int divider, 
			List<StringBuilder> log){
		
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
				log = writeToLog(dividend, newDividend, log);
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

	private static String divisionFractivePart(int dividend, int divider,
			List<StringBuilder> log){
		
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
			int newDividend = dividend % divider;
			log = writeToLog(dividend, newDividend,log);
			dividend = newDividend;
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
	
	private static List<StringBuilder> writeToLog(int dividend, int newDividend, 
			List<StringBuilder> log){
		
		int subtrahend = dividend - newDividend;
		int identationSize = readIdentation(log);
		StringBuilder identationDividend = getIdentation(identationSize).append(' ');
		StringBuilder identationSubtrahend = new StringBuilder(identationDividend);
		identationSubtrahend.setCharAt(0,'-');
		int shiftLength = differenceOfLengths(dividend,  subtrahend);
		StringBuilder shift = getIdentation(shiftLength);
		identationSubtrahend.append(shift);
		log.add(identationDividend.append(dividend));
		log.add(identationSubtrahend.append(subtrahend));	
		identationSize += differenceOfLengths(dividend, newDividend);
		log = saveIdentation(identationSize, log);
		return log;
	}
	
	private static int readIdentation(List<StringBuilder> log){
		int result;
		if ( log.isEmpty() ) {
			return 0;
		}
		try {
			int index = log.size() - 1;
			result = Integer.parseInt(log.get(index).toString());
			
		} catch (IndexOutOfBoundsException exception) {
			result = 0;
		} catch (NumberFormatException exception) {
			result = 0;
		}
		
		return result;
	}
	
	private static StringBuilder getIdentation(int length){
		StringBuilder result = new StringBuilder();
		if (length <= 0) {
			return result;
		}
		for (int i = 0; i < length; i++) {
			result.append(' ');
		}
		return result;
	}
	
	private static List<StringBuilder>saveIdentation(int identationSize, 
			List<StringBuilder> log){
		log.add(new StringBuilder(identationSize));
		return log;
	}
	
private static int differenceOfLengths(int arg0, int arg1){		
		return Integer.valueOf(arg0).toString().length()
				-Integer.valueOf(arg1).toString().length();
	}
	
}