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
		this.dividend.addAll(toList(dividendIn.toCharArray()));
		this.devizor.addAll(toList(devizorIn.toCharArray()));
		
		divisionOutput.add(dividend+"");
		
		while (decimalDivisionsCounter < declimit) {
			oneDivisionResult = takeMinDivident(this.dividend,this.devizor);
			if (oneDivisionResult!=null) {
				if (divisionCounter!=0) divisionOutput.set(divisionOutput.size()-1,generateSpaces(divisionCounter)+Integer.parseInt(listToString(oneDivisionResult[0])));
				modulo = oneDivisionOperation(oneDivisionResult[0],this.devizor,divisionCounter);
				this.dividend = toList((""+modulo).toCharArray());
				this.dividend.addAll(oneDivisionResult[1]);
				skipNulls();
				if (modulo==0 && oneDivisionResult[1].size()==0) break;
			} else {
				this.dividend.add('0');
				if (this.divisionResult.size()>0 && this.divisionResult.get(this.divisionResult.size()-1)=='.') this.divisionResult.add('0');
				if (divisionCounter==1) this.divisionResult.add('0');
				if (isAboveZero) {
					this.divisionResult.add('.');
					isAboveZero = false;
				}
				decimalDivisionsCounter++;
			}
			divisionCounter++;
		}
		
		divisionOutput.set(0,dividendIn+" |"+devizorIn);
		divisionOutput.set(1,divisionOutput.get(1).trim()+generateSpaces(toList(dividendIn.toCharArray()).size()-divisionOutput.get(1).trim().length())+" |"+listToString(divisionResult));
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
	
	private ArrayList<Character> toList (char[] c) {
		ArrayList<Character> a = new ArrayList<Character>();
		for (Character c1: c) {
			a.add(c1);
		}
		return a;
	}
	
	private ArrayList<Character>[] takeMinDivident (ArrayList<Character> dividend, ArrayList<Character> devizor) {
		ArrayList<Character>[] ret = new ArrayList[2];
		ArrayList<Character> d1, d2;
		int i1,i2;

		if (dividend.size() >= devizor.size()) {
			d1 = new ArrayList<Character>(dividend.subList(0, devizor.size()));
			d2 = devizor;
			i1 = Integer.parseInt(listToString(d1));
			i2 = Integer.parseInt(listToString(d2));
			if (i1 >= i2) {
				ret[0] = d1;
				ret[1] = new ArrayList<Character>(dividend.subList(devizor.size(), dividend.size()));
				return ret;
			} else if (dividend.size() > devizor.size()) {
				d1 = new ArrayList<Character>(dividend.subList(0, devizor.size()+1));
				ret[0] = d1;
				ret[1] = new ArrayList<Character>(dividend.subList(devizor.size()+1, dividend.size()));
				return ret;
			} 
		} 
		return null;
		
	}
	
	private int oneDivisionOperation (ArrayList<Character> dividend, ArrayList<Character> devizor, int spaces) {
	int dividendNumber,i2;
	dividendNumber = Integer.parseInt(listToString(dividend));
	i2 = Integer.parseInt(listToString(devizor));
		divisionOutput.add(generateSpaces(divisionOutput.get(divisionOutput.size()-1).length()-(i2*(dividendNumber/i2)+"").length())+(i2*(dividendNumber/i2)));
		divisionOutput.add(generateSpaces(spaces)+generateDelimeters(dividend.size()+1));
		divisionOutput.add(generateSpaces(divisionOutput.get(divisionOutput.size()-2).length()-((dividendNumber%i2)+"").length())+(dividendNumber%i2));
		divisionResult.add(((dividendNumber/i2)+"").toCharArray()[0]);
		return dividendNumber%i2;
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
