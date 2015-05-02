import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class ColumnDivision {


	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner reader = new Scanner(System.in);
		String dividend = reader.nextLine();
		String devizor =  reader.nextLine();
		int decimalLimit = 7;
		new ColumnDivision(dividend,devizor,decimalLimit).printOutput();
	}
	
	ArrayList<Character> dividend = new ArrayList<Character>();
	ArrayList<Character> devizor = new ArrayList<Character>();
	ArrayList<Character> divisionResult = new ArrayList<Character>();
	ArrayList<Character>[] oneDivisionResult = new ArrayList[2];
	ArrayList<String> divisionOutput = new ArrayList<String>();
	ArrayList<Integer> spacesForOutput = new ArrayList<Integer>();
	int decimalDivisionsCounter, divisionCounter, modulo, nullCounter;
	int DIVIDEND_FOR_ONE_OPERATION = 0;
	int DIVIDEND_NOT_USED_DIGITS = 1;
	
	
	
	public ColumnDivision(String dividendIn, String devizorIn, int decimalLimit) {
		dividend.addAll(toList(dividendIn.toCharArray()));
		devizor.addAll(toList(devizorIn.toCharArray()));
		
		calculateDivision(decimalLimit);
		formatOutput(dividendIn, devizorIn);
		
	}

	private void calculateDivision(int decimalLimit) {
		while (decimalDivisionsCounter != decimalLimit) {
			oneDivisionResult = takeMinDivident(dividend,devizor);
			if (oneDivisionResult!=null) {
				performOneDivisionOperation();
				if (isDividendOver()) break;
			} else {
				addOneMoreZeroToDividend();
			}
			divisionCounter++;
		}
	}

	private void printOutput() {
		int shift = 0;
		for(int index = 0; index < divisionOutput.size(); index+=2) {
			System.out.println(stringOfSize(shift,' ')+divisionOutput.get(index));
			shift += spacesForOutput.get(index);
			System.out.println(stringOfSize(shift,' ')+divisionOutput.get(index+1));
			System.out.println(stringOfSize(shift,' ')+stringOfSize(divisionOutput.get(index).length(),'-'));
			shift += spacesForOutput.get(index+1);
		}
	}

	private void formatOutput(String dividendIn, String devizorIn) {
		if (divisionOutput.size() == 0) {
			System.err.println("Increase decimal limit");
			System.exit(0);
		}
		divisionOutput.remove(0);
		int dividendLength = dividendIn.toCharArray().length;
		int secondLineLength = divisionOutput.get(0).length();
		if (dividendLength > secondLineLength) {
		divisionOutput.add(0,dividendIn+" |"+devizorIn);
		divisionOutput.set(1,divisionOutput.get(1).trim()+stringOfSize(dividendLength-secondLineLength,' ')+" |"+listToString(divisionResult));
		} else if (dividendLength <= secondLineLength) {
		divisionOutput.add(0,dividendIn+stringOfSize(secondLineLength-dividendLength,' ')+" |"+devizorIn);
		divisionOutput.set(1,divisionOutput.get(1).trim()+" |"+listToString(divisionResult));	
		}
	}

	private void addOneMoreZeroToDividend() {
		dividend.add('0');
		if (decimalDivisionsCounter > 0 && nullCounter > 0) divisionResult.add('0');
		if (divisionCounter==0) {
			divisionResult.add('0');
		}
		if (decimalDivisionsCounter == 0) {
			divisionResult.add('.');
		}
		decimalDivisionsCounter++;
		nullCounter++;
	}

	private boolean isDividendOver() {
		return modulo==0 && oneDivisionResult[DIVIDEND_NOT_USED_DIGITS].size() == 0;
	}

	private void performOneDivisionOperation() {
		divisionOutput.add(listToString(oneDivisionResult[DIVIDEND_FOR_ONE_OPERATION]));
		modulo = oneDivisionOperation(oneDivisionResult[DIVIDEND_FOR_ONE_OPERATION],devizor,divisionCounter);
		dividend = toList((""+modulo).toCharArray());
		dividend.addAll(oneDivisionResult[DIVIDEND_NOT_USED_DIGITS]);
		calculateSpacesForFormatting();
		skipNulls();
	}
	
	private void calculateSpacesForFormatting() {
		spacesForOutput.add(oneDivisionResult[DIVIDEND_FOR_ONE_OPERATION].size() - divisionOutput.get(divisionOutput.size()-2).length());
		spacesForOutput.add(oneDivisionResult[DIVIDEND_FOR_ONE_OPERATION].size() - new Integer(modulo).toString().length());
		
	}

	private void skipNulls() {
		while (dividend.size() > 0) {
			if (dividend.get(0)=='0'){
				divisionResult.add('0');
				dividend.remove(0);
			} else break;
			divisionCounter++;

		}
	}
	
	private ArrayList<Character> toList (char[] charArray) {
		ArrayList<Character> result = new ArrayList<Character>();
		for (Character oneChar: charArray) {
			result.add(oneChar);
		}
		return result;
	}
	
	private ArrayList<Character>[] takeMinDivident (ArrayList<Character> dividend, ArrayList<Character> devizor) {
		ArrayList<Character>[] result = new ArrayList[2];
		ArrayList<Character> posibleDevident;
		int dividendNumber,devizorNumber;

		if (dividend.size() >= devizor.size()) {
			posibleDevident = new ArrayList<Character>(dividend.subList(0, devizor.size()));
			dividendNumber = Integer.parseInt(listToString(posibleDevident));
			devizorNumber = Integer.parseInt(listToString(devizor));
			if (dividendNumber >= devizorNumber) {
				result[DIVIDEND_FOR_ONE_OPERATION] = posibleDevident;
				result[DIVIDEND_NOT_USED_DIGITS] = new ArrayList<Character>(dividend.subList(devizor.size(), dividend.size()));
				return result;
			} else if (dividend.size() > devizor.size()) {
				posibleDevident = new ArrayList<Character>(dividend.subList(0, devizor.size()+1));
				result[DIVIDEND_FOR_ONE_OPERATION] = posibleDevident;
				result[DIVIDEND_NOT_USED_DIGITS] = new ArrayList<Character>(dividend.subList(devizor.size()+1, dividend.size()));
				return result;
			} 
		} 
		return null;
		
	}
	
	private int oneDivisionOperation (ArrayList<Character> dividend, ArrayList<Character> devizor, int spaces) {
	int dividendNumber,devizorNumber;
	dividendNumber = Integer.parseInt(listToString(dividend));
	devizorNumber = Integer.parseInt(listToString(devizor));
		divisionOutput.add(devizorNumber*(dividendNumber/devizorNumber)+"");
		divisionResult.add(((dividendNumber/devizorNumber)+"").toCharArray()[0]);
		nullCounter = 0;
		return dividendNumber%devizorNumber;
	}
	
	
	private String listToString (ArrayList<Character> list) {
	    StringBuilder result = new StringBuilder(list.size());
	    for(Character character: list)
	    {
	        result.append(character);
	    }
	    return result.toString();
	}
	
	public static String stringOfSize(Integer size, char character)
	{
	    final char[] array = new char[size];
	    Arrays.fill(array, character);
	    return new String(array);
	}
	
}
