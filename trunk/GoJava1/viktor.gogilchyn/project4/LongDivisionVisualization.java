package ua.com.goit.gojava.lslayer.module1.project4;

import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.Locale;

public class LongDivisionVisualization {
	private static final int DEPTH_CAP = 6;
	private static final Locale LOCALE = Locale.US;
	private int divident;
	private int divisor;
	
	public LongDivisionVisualization(int divident, int divisor) {
		this.divident = divident;
		this.divisor = divisor;
	}
	
	public int replaceFirstNumbers (int from, int where, int howMuch) {
	    return (from % (int) Math.pow(10, intLength(from) - howMuch)) + 
               (where * (int) Math.pow(10, intLength(from) - howMuch));
	}
	
	public DivisionContainer divide (int divident, int divisor, boolean belowZero, int level) {
	    //Debug mode on
	    DivisionContainer result = new DivisionContainer();
	    if (divident == divisor) {
	        result.result = 1;
	        result.rest = 0;
	        result.belowZero = belowZero;
	    }
	    int i = 1;
	    while (selectNumberByPositions(divident, 0, i) < divisor) i++;
	    return result;
	}
	
	public void visualize() {
	}
	
	
	public void readDividentAndDivider(String in) {
		String[] divArray = in.split("[ /]+");
		this.divident = Integer.parseInt(divArray[0]);
		this.divisor = Integer.parseInt(divArray[1]);
		if (divisor == 0) {
		    throw new IllegalArgumentException("Argument 'divisor' is 0");
		}
	}
	
	public void readDividenAndDivider(int divident, int divisor) {
		this.divident = divident;
		this.divisor = divisor;
		if (divisor == 0) {
		    throw new IllegalArgumentException("Argument 'divisor' is 0");
		}
	}
	
	private void printIteration(int top, int bottom, int levelOfIndent) {
	}
	
	private String multiplySymbols(int quantity, String symbol) {
		return new String(new char[quantity]).replace("\0", symbol);
	}
	
    public int selectNumberByPositions(int Number, int startPosition, int endPosition) {
        int result = 0;
        if (startPosition < endPosition) {
            result = Integer.parseInt((String)Integer.toString(Number).subSequence(startPosition, endPosition));
        } else {
            throw new InvalidParameterException("Start position should be less then end position");
        }
        return result;
    }
	
	private int intLength(int i) {
		return Integer.toString(i).length();
	}
}

class DivisionContainer {
    public int result;
    public int rest;
    public int level;
    public boolean belowZero;
}