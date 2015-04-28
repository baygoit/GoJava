package long_division;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Division {
	
	private String sNumber1, sNumber2;
	private int number1, number2;
	private int accuracy = 6;
	
	public Division(String formula) throws NumberFormatException {
		String[] numbers = formula.split("/"); 
		if (numbers.length != 2) {
			throw new NumberFormatException();
		}
		this.sNumber1 = numbers[0];
		for (int i = 0; i < accuracy; i++) {
			this.sNumber1 += "0";
		}
		this.sNumber2 = numbers[1];
		this.number1 = Integer.parseInt(this.sNumber1);
		this.number2 = Integer.parseInt(this.sNumber2);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("Input formula:");
			String formula = reader.readLine();
			new Division(formula).showResult();
		} catch (NumberFormatException e) {
			System.out.println("Incorrect formula!");
			return;
		} finally {
			reader.close();
		}
	}

	public void showResult() {
		while (getNext()) {
			calcResult();
		}
		outputResult();
	}

	private StringBuilder sResult = new StringBuilder();
	private StringBuilder logResult = new StringBuilder();
	private StringBuilder spaces = new StringBuilder();
	private int index = 0;
	private int currentNumber = 0;
	private void calcResult() {
		int localResult = currentNumber / number2;
		sResult.append(localResult);
		localResult *= number2;
		logResult.append(spaces.toString()+localResult+"\n");
		spaces.append(" ");
		currentNumber -= localResult;
	}

	private boolean getNext() {
		if (index >= sNumber1.length()) {
			logResult.append(spaces.toString()+currentNumber+"\n");
			return false;
		}
		currentNumber *= 10;
		currentNumber += Integer.parseInt(sNumber1.substring(index,index+1));
		index++;
		if (currentNumber != 0 && currentNumber / number2 < 1) {
			getNext();
		}
		if (spaces.length() > 0) {
			logResult.append(spaces.toString()+currentNumber+"\n");			
		}
		return true;
	}
	
	private void outputResult() {
		int number1 = this.number1;
		double localResult = Integer.parseInt(sResult.toString());
		for (int i = 0; i < accuracy; i++) {
			number1 /= 10;
			localResult /= 10;
		}
		System.out.println(number1 + " | "+ number2);
		System.out.println(spaces.toString() + "  |" + localResult);
		System.out.println(logResult.toString());
	}
}