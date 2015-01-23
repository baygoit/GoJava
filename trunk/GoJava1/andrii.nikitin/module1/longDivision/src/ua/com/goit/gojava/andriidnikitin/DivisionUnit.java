package ua.com.goit.gojava.andriidnikitin;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class DivisionUnit {
	
	public final double MAX_FRACTAL_DEPTH = 35;	
	
	public final int FRACTAL_IS_NOT_SYSTEMATIC = -1;
	
	List<StringBuilder> log;
	
	String result;
	
	public DivisionUnit(){
		log = new ArrayList<StringBuilder>();		
		result = new String();					
	}	
	
	public List<StringBuilder> getLog(){
		return log;
	}
	
	public String getResult(){
		return result;
	}
	
	public void longDivision(int inputDividend, int inputDivider) 
			throws IllegalArgumentException, ArithmeticException {
		
		if ((inputDividend < 0) || (inputDivider < 0)) {
			throw new IllegalArgumentException("One or more arguments are less than zero.");
		}
		
		if (inputDivider == 0) {
			throw new ArithmeticException("Divide by zero.");
		}	
		
		if (inputDividend == 0){			
			result =  divisionZeroDividendCase(inputDividend, inputDivider);
		}		
		else {		
			result =  divisionRegularCase(inputDividend, inputDivider);		
		}

		logFormatting(inputDividend, inputDivider);		
	}	
			
	private String divisionZeroDividendCase(int inputDividend, int inputDivider) 
			throws  ArithmeticException {
		if (inputDivider == 0) {
			throw new ArithmeticException("Divide by zero.");
		}			
		log.add(new StringBuilder().append(inputDividend));
		log.add(new StringBuilder());
		log.add(new StringBuilder());
		return "0";
	}
	
	private String divisionRegularCase(int inputDividend, int inputDivider){
		
		log = new ArrayList<StringBuilder>();
		
		String result = "0";
		
		int dividendFractive = inputDividend % inputDivider;
		
		int dividendNatural = inputDividend - dividendFractive;
		
		if (dividendNatural != 0) {
			result = Integer.valueOf(divisionNaturalPart(inputDividend, 
					inputDivider)).toString(); 
		}
		else {
			writeToLog(inputDividend, inputDividend);
			trimFirstSymbolOfLogRow(1);
		}
					
		if (dividendFractive != 0){
			result+= divisionFractivePart(dividendFractive, inputDivider);
		}
		else {
			result+= ".0";
			writeZeroToEndOfLog();
		}		
		return result;
	}	
	
	private void logFormatting(int inputDividend, int inputDivider) {
		deleteLastRowFromLog();
		StringBuilder firstRow = new StringBuilder().append(' ').append(inputDividend);
		StringBuilder secondRow = log.get(1);
		int difference =  firstRow.length() -  secondRow.length();
		if (difference <= 0){
			firstRow.append(getIdentation(-difference));
		}
		else {
			secondRow.append(getIdentation(difference));
		}
		firstRow.append("|_").append(inputDivider);
		secondRow.append("|").append(result);	
		log.set(0, firstRow);
		log.set(1, secondRow);
	}

	private int divisionNaturalPart(int inputDividend, int divider){
		
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
				writeToLog(dividend, newDividend);
				dividend = dividend % divider;
			}
		}
		return resultNatural;
	}
	
	private Stack<Integer> numberToStackOfDigits(int inputNumber){
		Stack<Integer> dividendDigits = new Stack<Integer>();
		while (inputNumber > 0){
			dividendDigits.push(inputNumber % 10);
			inputNumber = inputNumber / 10;
		}
		return dividendDigits;
	}

	private String divisionFractivePart(int dividend, int divider){
		
		StringBuilder resultRow = new StringBuilder(); 
		int periodisedElement = FRACTAL_IS_NOT_SYSTEMATIC;
		boolean pushZeroToResult = false;
		List<Integer> dividendList = new ArrayList<Integer>();
		for (int position = 0; position < MAX_FRACTAL_DEPTH; position++){
			if (dividendListContainsDividend(dividend, dividendList)){
				periodisedElement = indexOfElementInDividendList(dividend, dividendList);
				writeToLog(dividend, 0);
				deleteLastRowFromLog();
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
			writeToLog(dividend, newDividend);
			dividend = newDividend;
		}
		
		return formattedResult(resultRow, periodisedElement);
	}
	
	private int indexOfElementInDividendList(int element, List<Integer> list){
		element = cutZerosFromEnd(element);
		return list.indexOf(element);
	}
	
	private boolean dividendListContainsDividend(int element, List<Integer> list){
		return list.contains(cutZerosFromEnd(element));
	}
	
	
	private String formattedResult(StringBuilder resultRow, int periodisedElement ){
		String result = resultRow.toString();
		if (periodisedElement != FRACTAL_IS_NOT_SYSTEMATIC) {
			if (periodisedElement == 0) result = "(" + result + ")";	
			else 
				result = result.substring(0, periodisedElement) 
				+"(" + result.substring(periodisedElement) + ")";
		}
		return "." + result;
	}
	
	private void dividendListAdd(List<Integer> dividendVector, int number) {
			number = cutZerosFromEnd(number);
		dividendVector.add(number);
	}
	
	private int cutZerosFromEnd(int number){
		while ((number != 0) && (number % 10 == 0)) {
			number = number / 10;
		}
		return number;
	}
	
	private void writeToLog(int dividend, int newDividend){
		
		int subtrahend = dividend - newDividend;
		int identationSize = readIdentation();
		StringBuilder identationDividend = getIdentation(identationSize);
		StringBuilder identationSubtrahend = new StringBuilder(identationDividend);
		int shiftLength = differenceOfLengths(dividend,  subtrahend);
		StringBuilder shift = getIdentation(shiftLength);
		identationSubtrahend.append(shift);
		log.add(identationDividend.append(' ').append(dividend));
		log.add(identationSubtrahend.append('-').append(subtrahend));	
		identationSize += differenceOfLengths(dividend, newDividend);
		log = saveIdentation(identationSize);
	}
	
	private int readIdentation(){
		int result;
		if ( log.isEmpty() ) {
			result = 0;
		}
		
		try {
			int index = log.size() - 1;
			result = Integer.parseInt(log.get(index).toString());
			deleteLastRowFromLog();
			
		} catch (IndexOutOfBoundsException exception) {
			result = 0;
		} catch (NumberFormatException exception) {
			result = 0;
		}
		
		return result;
	}
	
	private StringBuilder getIdentation(int length){
		StringBuilder result = new StringBuilder();
		if (length <= 0) {
			return result;
		}
		for (int i = 0; i < length; i++) {
			result.append(' ');
		}
		return result;
	}
	
	private List<StringBuilder>saveIdentation(int identationSize){
		log.add(new StringBuilder().append(identationSize));
		return log;
	}
	
	private int differenceOfLengths(int arg0, int arg1){		
		return lengthsOfNumber(arg0)
				- lengthsOfNumber(arg1);
	}

	private int lengthsOfNumber(int arg0){
		if (arg0 == 0){
			return 0;
		}
		return Integer.valueOf(arg0).toString().length();
	}
	
	private void deleteLastRowFromLog(){
		int lastElementIndex = log.size() - 1;
		log.remove(lastElementIndex);
	}	
	
	private void trimFirstSymbolOfLogRow(int index){		
		StringBuilder row =  log.get(index);
		row.deleteCharAt(0);
		log.set(index, row);
	}
	
	private void writeZeroToEndOfLog(){
		writeToLog(0, 0);		
		deleteLastRowFromLog();
		trimFirstSymbolOfLogRow(log.size() - 2);
	}
}
