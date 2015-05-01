import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class ColumnDivision {


	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner reader = new Scanner(System.in);
		String dividend = reader.nextLine();
		String devizor =  reader.nextLine();
		int declimit = 5;
		new ColumnDivision(dividend,devizor,declimit);
	}
	
	ArrayList<Character> dividend = new ArrayList<Character>();
	ArrayList<Character> devizor = new ArrayList<Character>();
	ArrayList<Character> divisionResult = new ArrayList<Character>();
	ArrayList<Character>[] oneDivisionResult = new ArrayList[2];
	ArrayList<String> divisionOutput = new ArrayList<String>();
	boolean isAboveZero = true;
	int decimalDivisionsCounter=-1,divisionCounter=0,modulo;
	
	
	
	public ColumnDivision(String dividendIn, String devizorIn, int declimit) {
		dividend.addAll(toList(dividendIn.toCharArray()));
		devizor.addAll(toList(devizorIn.toCharArray()));
		
		divisionOutput.add(dividend+"");
		
		while (decimalDivisionsCounter < declimit) {
			oneDivisionResult = takeMinDivident(dividend,devizor);
			if (oneDivisionResult!=null) {
				if (divisionCounter!=0) divisionOutput.set(divisionOutput.size()-1,Integer.parseInt(listToString(oneDivisionResult[0]))+"");
				modulo = oneDivisionOperation(oneDivisionResult[0],devizor,divisionCounter);
				dividend = toList((""+modulo).toCharArray());
				dividend.addAll(oneDivisionResult[1]);
				skipNulls();
				if (modulo==0 && oneDivisionResult[1].size()==0) break;
			} else {
				dividend.add('0');
				if (divisionResult.size()>0 && divisionResult.get(divisionResult.size()-1)=='.') divisionResult.add('0');
				if (divisionCounter==1) divisionResult.add('0');
				if (isAboveZero) {
					divisionResult.add('.');
					isAboveZero = false;
				}
				decimalDivisionsCounter++;
			}
			divisionCounter++;
		}
		
		divisionOutput.set(0,dividendIn+" |"+devizorIn);
		divisionOutput.set(1,divisionOutput.get(1).trim()+" |"+listToString(divisionResult));
		for(String s: divisionOutput) System.out.println(s);
		
	}
	
	private void skipNulls() {
		while (dividend.size()>0) {
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
				result[0] = posibleDevident;
				result[1] = new ArrayList<Character>(dividend.subList(devizor.size(), dividend.size()));
				return result;
			} else if (dividend.size() > devizor.size()) {
				posibleDevident = new ArrayList<Character>(dividend.subList(0, devizor.size()+1));
				result[0] = posibleDevident;
				result[1] = new ArrayList<Character>(dividend.subList(devizor.size()+1, dividend.size()));
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
		divisionOutput.add(generateDelimeters(dividend.size()+1));
		divisionOutput.add(dividendNumber%devizorNumber+"");
		divisionResult.add(((dividendNumber/devizorNumber)+"").toCharArray()[0]);
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
	
	private String generateSpaces (int spacesAmount) {
		String spaces = "";
		for (int index=0; index < spacesAmount; index++) {
			spaces+=" ";
		}
		return spaces;
	}
	
	private String generateDelimeters (int delimetersAmount) {
		String delimeters = "";
		for (int index=0; index < delimetersAmount; index++) {
			delimeters+="-";
		}
		return delimeters;
	}
}
