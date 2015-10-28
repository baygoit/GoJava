package ua.com.goit.lesson1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * Lesson 1 - Task 4
 * Твоя задача реализовать программу, которая визуализирует деление в столбик в консоли в текстовом режиме,
 * как например вот тут. 
 * Например, на вход передается строка "12/42", программа напечатает: 
 * -12 |42 
 *   84|0.(285714) 
 *   --- 
 *    360 
 *   -336 
 *    ----
 */
public class LongDivision {
	
	public static final String SLASH = "/";
	public static final String SPACE = " ";
	public static final String MINUS = "-";
	public static final String VERTICAL = "|";
	public static final String HORIZONTAL = "---";
	public static final String POINT = ".";
	public static final int FIRST_ROW_INDEX = 0;
	public static final int RESULT_ROW_INDEX = 1;
	
	private static ArrayList<String> output;
	private static ArrayList<Integer> operandStack;
	private static String result = "";
	private static String prefixWithSpace;
	private static String prefixWithMinus;

	public static void main(String[] args)
	{
		output = new ArrayList<String>(100);
		operandStack = new ArrayList<Integer>(100);
		prefixWithSpace = SPACE;
		prefixWithMinus = MINUS;
		
		makeDivision();
		showOutput();
	}
		
	private static int[] getOperands() throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = reader.readLine().split(SLASH);
		int[] operands = new int[2];
		
		if (input.length == 2)
		{
			operands[0] = Integer.parseInt(input[0]);
			operands[1] = Integer.parseInt(input[1]);
		}
		else throw new IOException("Wrong number of operands! Must be only two.");
		
		if (operands[1] == 0)
			throw new ArithmeticException("Division by zero!");
		
		return operands;
	}
	
	private static void makeDivision()
	{
		int[] operands;
		boolean notEnd = true;
		
		try
		{
			operands = getOperands();
		}
		catch (Exception e)
		{
			System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
			return;
		}
		
		setNextOperand(operands[0]);
		int divisor = operands[1];
		addToOutput(operands[0], operands[1]);
				
		for(int count = 0; count <= 100 && notEnd; count++)
		{
			notEnd = makeCurrentDivision(divisor, count);
		}
	}
	
	private static boolean makeCurrentDivision(int divisor, int count)
	{
		int operand = getNextOperand();
		int currentResult = operand / divisor;
		int currentRemaining = operand % divisor;
		int currentMinus = currentResult * divisor;
		
		addToResult(currentResult);
		
		if (currentRemaining == 0)
			return false;
		
		if (currentMinus > 0)
			addToOutput(operand, currentMinus);
						
		operand = mult10(currentRemaining);
	
		setNextOperand(operand);
		
		return !isPeriodFound(operand);
	}
	
	private static int getNextOperand()
	{
		return operandStack.get(0);
	}
	
	private static void setNextOperand(int operand)
	{
		operandStack.add(0, operand);
	}
	
	private static int mult10(int operand)
	{
		return operand *= 10;
	}
	
	private static void addToResult(int divisionResult)
	{
		if (isPointNeeded())
		{
			addPointToResult();
			result += divisionResult;
		}
		else 
			result += divisionResult;
	}
	
	private static void addPointToResult()
	{
		result += POINT;
	}
	
	private static boolean isPointNeeded()
	{
		return (!result.isEmpty() && result.indexOf(POINT) < 0);
	}
	
	private static void showOutput()
	{
		updateOutputForResult(RESULT_ROW_INDEX);
		
		for(String row : output)
			System.out.println(row);
	}
	
	private static void addToOutput(int operand1, int operand2)
	{
		String row1 = "";
		String row2 = "";
		String separator = HORIZONTAL;
		
		if (isFirstRow()) {
			row1 += prefixWithSpace + operand1 + VERTICAL + operand2;
			output.add(row1);
		} else if (isResultRow()) {
			row1 += prefixWithMinus + operand2 + VERTICAL;
			output.add(row1);
			output.add(separator);
		} else {
			row1 += prefixWithSpace + operand1;
			output.add(row1);
			row2 += prefixWithMinus + operand2;
			output.add(row2);
			separator = prefixWithSpace + separator;
			output.add(separator);
			
			prefixWithSpace = " " + prefixWithSpace;
			prefixWithMinus = " " + prefixWithMinus;
		}
		
	}
	
	private static boolean isFirstRow()
	{
		return output.size() == FIRST_ROW_INDEX;
	}
	
	private static boolean isResultRow()
	{
		return output.size() == RESULT_ROW_INDEX;
	}
	
	private static void updateOutputForResult(int index)
	{
		if (output.size() > index)
		{
			output.set(index, output.get(index) + result);
		}
		else if (output.size() == index)
		{
			int length = output.get(index - 1).indexOf(VERTICAL);
			String emptySpace = "";
			for (int count = 0; count < length; count++)
				emptySpace += SPACE;
			output.add(emptySpace + VERTICAL + result);
		}
	}
	
	private static void formatResultForPeriod(int index)
	{
		int length = result.length();
		result = result.substring(0, length - index) + "(" + result.substring(length - index) + ")";
	}
	
	private static boolean isPeriodFound(int operand)
	{
		for (int index = 1; index < operandStack.size(); index++)
		{
			if (operandStack.get(index) == operand)
			{
				formatResultForPeriod(index);
				return true;
			}
		}
		
		return false;
	}
		
}
