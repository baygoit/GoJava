package ua.com.goit.gojava2.solo307.findDiffirenceOf2Mins; 

import java.util.Scanner;

public class DistanceAnalizator {
	
	public String scanLine(){
		System.out.println("please, enter a numbers, separated by spaces");
		return new String(new Scanner(System.in).nextLine());
	}
	
	public int [] parseNumbers(String [] inLine){
		int [] array = new int [inLine.length];
		for(int i = 0 ; i < array.length; i++){
			try{
				array[i] = Integer.parseInt(inLine[i]);
			}catch(NumberFormatException e){
				e.getMessage();
				System.out.println("Wrong data type");
				System.exit(0);
			}
		}
		return array;
	}
	
	public int [] findTwoMinIndexes(int [] numbers){
		final int ARRAY_BEGIN = numbers[0];
		int curentValue = ARRAY_BEGIN;
		int minIndex = 0;
		for(int i = 0; i < numbers.length; i++){
			if(numbers[i] < curentValue){
				curentValue = numbers[i];
				minIndex = i;
			}
		}
		curentValue = ARRAY_BEGIN;
		int minIndex2 = 0;
		for(int i = 0; i < numbers.length; i++){
			if((numbers[i] < curentValue) && (i != minIndex)){
				curentValue = numbers[i];
				minIndex2 = i;
			}
		}
		return new int[]{minIndex, minIndex2};
	}
	
	public static void main(String[] args){
		DistanceAnalizator distanceAnalizator = new DistanceAnalizator();
		String [] inLine = distanceAnalizator.scanLine().split(" ");
		int [] numbers = distanceAnalizator.parseNumbers(inLine);
		int [] minimals = distanceAnalizator.findTwoMinIndexes(numbers);
		final int FIRST_MINIMAL = minimals[0], LAST_MINIMAL = minimals[1];
		int distance = 0;
		if(FIRST_MINIMAL > LAST_MINIMAL) distance = FIRST_MINIMAL - LAST_MINIMAL;
		else distance = LAST_MINIMAL - FIRST_MINIMAL;
		System.out.println("Distance = " + distance);
	}
}
