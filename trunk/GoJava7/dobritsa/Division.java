//it will be modify in nearest future

package go.it.dobritsa;

public class Division extends go.it.main.Division {
	static String visualization = "";

	public static void main(String[] args) {
		String myExample = "12/42";
		myDivide(myExample);		
		System.out.println(visualization);	
		
		String myExample2 = "12/63";
		myDivide(myExample2);	
		System.out.println(visualization);	
		
		String myExample3 = "85/63";
		myDivide(myExample3);	
		System.out.println(visualization);	
	}
	
	public static String myDivide(String exampleStr) {
		String[] exampleArr = exampleStr.split("/");				
		int dividentInteger = Integer.valueOf(exampleArr[0]);
		int divisorInteger = Integer.valueOf(exampleArr[1]);
		return myDivide(dividentInteger, divisorInteger);
	}	
	
	public static String myDivide(int divident, int divisor) {
		visualization = "";	
		String indent = "";			
		int dividentInteger = divident;
		int divisorInteger = divisor;		
		Float result = (float)dividentInteger/(float)divisorInteger;				
		char[] resultListChar = result.toString().toCharArray();	
		int line1 = dividentInteger;	
		int line2 = divisorInteger*Character.getNumericValue(resultListChar[2]);		
		
		//printFirstLine		
		visualization += indent + "  " + dividentInteger + " |" + divisorInteger + "\n";
	
		//printSecondLine
		if(dividentInteger < divisorInteger) {	
			line1 = line1 * 10;	
			indent += " ";			
			visualization += indent + "-" + line2 + " |" + result + "\n" + indent + " " + "---" + "\n";
		} else {			
			visualization += "The divident must be less than the divisor for this task";
			System.out.println(visualization);
			System.exit(0);
		}

		//printOthersLines
		for (int i = 3; i < resultListChar.length - 1; i++) {			
			if (Character.getNumericValue(resultListChar[i]) != 0) {
				indent +=" ";		
				line1 = (line1 - line2)*10;
				line2  = divisorInteger*Character.getNumericValue(resultListChar[i]);			
				visualization += indent + " " + line1 + "\n" + indent + "-" + line2 + "\n" + indent + " " + "---"  + "\n";
				
			} else {
				indent +="  ";		
				line1 = (line1 - line2)*100;
				line2  = divisorInteger*Character.getNumericValue(resultListChar[++i]);				
				visualization += indent + " " + line1 + "\n" + indent + "-" + line2 + "\n" + indent + " " + "---" + "\n";
			}			
		}
		
		//printLastLine
		line1 = (line1 - line2);	
		visualization += indent + " " + line1  + "\n";
		return visualization;
	}	
	
	@Override
	public String divide(int divident, int divisor) {		
		return myDivide(divident, divisor);
	}

}
