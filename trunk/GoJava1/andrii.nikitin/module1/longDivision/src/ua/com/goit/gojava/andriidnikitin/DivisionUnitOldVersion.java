package ua.com.goit.gojava.andriidnikitin;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
//TODO: TRY 2/37
//SOLUTION: ADD TO DIVIDEND LIST BEFORE ADDING ZEROS
public class DivisionUnitOldVersion {
	
	public static final double MAX_FRACTAL_DEPTH = 35;	
	
	public static int FRACTAL_IS_NOT_SYSTEMATIC = -1;
				
	static List<String> log = new ArrayList<String>();
				
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
			longDivision(dividend, divider);
			visualise();
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
			log.add("0 / 0 = NaN");
			return "Not a Number";
		}
		else {
			log.add("0 / " 
			+ inputDivider + " = 0");
			return "0"; 	
		}
	}
	
	private static String divisionZeroDividerCase(int inputDividend, 
			int inputDivider){
		
		log.add(inputDividend + " / 0 = infinity");
		return "infinity";
	}
	
	private static String divisionRegularCase(int inputDividend, 
			int inputDivider){
		
		StringBuilder indentation = new StringBuilder();
		String result = "0";
		int dividendFractive = inputDividend % inputDivider;
		
		if (inputDividend - dividendFractive != 0) 
			result = Integer.valueOf(divisionNaturalPart(inputDividend, 
					inputDivider, indentation)).toString(); 
		else {
			visualiseStep(0, 0, 0, inputDivider, indentation);
		}
		
		if (dividendFractive != 0)
			result+= divisionFractivePart(dividendFractive, 
					inputDivider, indentation);
		else {
			result+= ".0";
			log.add(indentation + "0");
		}
		
		completeLog(inputDividend, inputDivider, result);
		return result;
	}	
	
	private static void completeLog(int inputDividend,
			int inputDivider, String result){
		
		log.set(0, " " + inputDividend);
		int maxLengthOf0and1LogRows = 
				Math.abs(log.get(0).length() - log.get(1).length());
		StringBuilder finalIndentantion = new StringBuilder();
		for (int i = 0; i < maxLengthOf0and1LogRows; i++) 
			finalIndentantion.append(' ');
		if (log.get(0).length() > log.get(1).length()){
			log.set(0, log.get(0) + "|_" + inputDivider);
			log.set(1, log.get(1) + finalIndentantion + '|' + result);
		}
		else{
			log.set(0, log.get(0) + finalIndentantion + "|_" + inputDivider);
			log.set(1, log.get(1) + '|' + result);
		}	
	}
	
	private static int divisionNaturalPart(int dividend, int divider,
			StringBuilder indentation){
		Stack<Integer> dividendDigits = numberToStackOfDigits (dividend);
		int resultNatural = 0;
		while (!dividendDigits.empty()) {
			int shiftLength = 0;
			if (dividend == 0) {
				indentation.append(' ');
				resultNatural = resultNatural * 10;				
			}
			if (dividend< divider){
				while (!dividendDigits.empty())
						dividend = dividend * 10 + (Integer)dividendDigits.pop(); 
				if (dividendDigits.empty()) break;
			}
			resultNatural = resultNatural * 10 + dividend / divider;
			int tempSubtrahend = dividend % divider;
			visualiseStep(dividend, tempSubtrahend, shiftLength, divider, indentation);
			dividend = tempSubtrahend; 
		}
		return resultNatural;
	}
	
	private static Stack<Integer> numberToStackOfDigits(int inputNumber){
		Stack<Integer> dividendDigits = new Stack<Integer>();
		while (inputNumber > 9){
			dividendDigits.push(inputNumber % 10);
			inputNumber = inputNumber / 10;
		}
		return dividendDigits;
	}
		//_____________________________________________________________________1
	private static String divisionFractivePart(int dividend, int divider,
			StringBuilder indentation){
		
		StringBuilder resultRow = new StringBuilder(); 
		int periodisedElement = FRACTAL_IS_NOT_SYSTEMATIC;
		boolean pushZeroToResult = false;
		List<Integer> dividendVector = new ArrayList<Integer>();
		for (int i = 0; i < MAX_FRACTAL_DEPTH; i++){	
			if (dividend!= 0)
				while (dividend < divider) { 	
					if (pushZeroToResult){
						i++;
						resultRow.append('0');
					}
					dividend = dividend * 10;
					pushZeroToResult = true;					
				}
			else break;
			pushZeroToResult = false;
			if (dividendVector.contains(dividend)){
				periodisedElement = dividendVector.indexOf(dividend);
				indentation.append(' ');
				log.add(indentation.toString() + dividend);
				break;
			}			
			dividendVectorAdd(dividendVector, dividend);
			resultRow.append(dividend / divider);
			int tempSubtrahend = dividend % divider;
			visualiseStep(dividend, tempSubtrahend, 0, 0, indentation);
			dividend = tempSubtrahend;
		}
		String result = resultRow.toString();
		if (periodisedElement != FRACTAL_IS_NOT_SYSTEMATIC) {
			if (periodisedElement == 0) result = "(" + result + ")";	
			else 
				result = result.substring(0, periodisedElement) 
				+"(" + result.substring(periodisedElement) + ")";
		}
		return "." + result;
	}
	
	//_____________________________________________________________________|
		
	private static void dividendVectorAdd(List<Integer> dividendVector, int number){
		while (number % 10 != 0)
			number = number / 10;
		dividendVector.add(number);
	}
	
	private static void visualiseStep(int dividend, int subtrahend, 
			int shift, int divider,	StringBuilder indentation){	
		
		shift+= differenceOfLengths(dividend - subtrahend, subtrahend);
		subtrahend = dividend - subtrahend;
		int dividerShiftLength = differenceOfLengths(dividend, subtrahend);
		StringBuilder dividerShift = new StringBuilder();
			for (int i = 0; i < dividerShiftLength; i++)
				dividerShift.append(' ');
		log.add(" " + indentation.toString() + dividend);
		log.add(indentation.toString() + '-' + dividerShift + subtrahend);
		for (int i = 0; i < shift; i++) indentation.append(' ');
		indentation.append(dividerShift);
	}
		
	private static void visualise(){
		
		for (String x: log) System.out.println(x);
	}
	
	private static int differenceOfLengths(int arg0, int arg1){
		
		return Integer.valueOf(arg0).toString().length()
				-Integer.valueOf(arg1).toString().length();
	}
	
	private static int getIntNumber(Scanner inputSource) 
			throws NumberFormatException{
		
		String input = inputSource.nextLine();
		return Integer.parseInt(input);
	}	
}