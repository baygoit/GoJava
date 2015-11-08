import java.io.IOException;
import java.util.Scanner;

/*
 * найти расстояние между двумя наименьшими числами в массиве. 
 */


public class DistanceBetweenMinimums {
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		int[] array = arrayCreation();	
		System.out.println("Distance between mimimums is " + findDistanceBetweenMinimumsInArray(array));
	}
	
	public static int[] arrayCreation(){
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter amount of numbers");
		int amount = input.nextInt();
		System.out.println("Please enter your numbers each followed with enter key");
		int[] array = new int[amount];
		for	(int i = 0; i < amount; i++){
			array[i] = input.nextInt();
		}
		input.close();
		
		return array;
	}
	
	public static int findDistanceBetweenMinimumsInArray(int[] array){
		int lowest = array[0], lowestPosition = 0;
		int secondLowest = array[1], secondLowPosition = 1;
		for (int i = 1; i < array.length; i++){
			if (array[i] <= lowest){
				secondLowest = lowest;
				secondLowPosition = lowestPosition;
				lowest = array[i];
				lowestPosition = i;
			}
		}
		int distance = Math.abs(secondLowPosition - lowestPosition);
		//System.out.println("Lowest numbers are " + secondLowest + " and " + lowest);
		//System.out.println("Their positions in array are " + secondLowPosition + " and " + lowestPosition);

		return distance;
	}
}
