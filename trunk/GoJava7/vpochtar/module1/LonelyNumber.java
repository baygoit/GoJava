//find the element in array that occurs 3 times

import java.util.Scanner;


public class LonelyNumber {

	public static void main(String[] args){
		findTheLonelyNumber(createArray());
	}
	
	public static int[] createArray(){
		Scanner input = new Scanner(System.in);
		System.out.println("Please set the array size");
		int size = input.nextInt();
		int[] array = new int[size];
		System.out.println("Please enter elemets of the array each on the separata line");
		for (int i = 0; i < size; i++)
			array[i] = input.nextInt();
		return array;
	}
	
	public static void findTheLonelyNumber(int[] array){
		for (int i = 0; i < array.length; i++){
			int count = 1;
			for (int j = i + 1; j < array.length; j++){
				if (array[i] == array[j]){
					count++;
				}
			}
			if (count == 3)
				System.out.println(array[i] + " is one of the lonely numbers");
		}
	}
}
