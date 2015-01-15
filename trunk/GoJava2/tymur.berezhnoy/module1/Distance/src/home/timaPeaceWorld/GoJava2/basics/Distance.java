package home.timaPeaceWorld.GoJava2.basics;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author tima.peaceworld
 */
public class Distance {

	public void startProcessing() {
		System.out.print("Enter at least two numbers, don't duplicate the numbers. To finish enter \"q\": ");
		System.out.println("The distance is " + getMinimumDistance(readNumbers()));
	}
	
	private ArrayList<Double> readNumbers() {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Double> listOfNumbers = new ArrayList<>();
		while (scanner.hasNextDouble()) {
			listOfNumbers.add(scanner.nextDouble());
		}
		return listOfNumbers;
	}

	private int getMinimumDistance(ArrayList<Double> arrayOfNumbers) {				
		if (arrayOfNumbers.size() <= 1) {
			return 0;
		}
		int indexOfFirstMinimum = 0;
		int indexOfSecondMinimum = 1;
		
		for (int i = 1; i < arrayOfNumbers.size(); i++) {
			if (arrayOfNumbers.get(i) < arrayOfNumbers.get(indexOfFirstMinimum)) {
				indexOfSecondMinimum = indexOfFirstMinimum;
				indexOfFirstMinimum = i;
			} else if (arrayOfNumbers.get(i) < arrayOfNumbers.get(indexOfSecondMinimum)) {
				indexOfSecondMinimum = i;
			}
		}			
		return Math.abs(indexOfFirstMinimum - indexOfSecondMinimum);
	}

	public static void main(String[] args) {
		Distance distance = new Distance();
		distance.startProcessing();
	}
}