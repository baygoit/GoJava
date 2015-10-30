package com.gmail.grezi.v;
/*
 * Task 7: Implement any method of array's sorting.
 * This program implement method Quick sort of array. 
 */
import java.util.Random;

public class MergeSort {

	public static void main(String[] args) {
				// TODO Auto-generated method stub
int[] numbers=new int[7];

numbers=generateRandomArray(numbers);
mergeSort(numbers);
for(int i:numbers) {
	System.out.print(i+" ");
}
		
		
	}
static void merge(int[] leftPart, int[] rightPart, int[] numbers){
	int leftPartLength=leftPart.length;
	int rightPartLength=rightPart.length;
	int i=0, j=0, k=0;
	
	for(;i<leftPartLength&&j<rightPartLength;){
		if(leftPart[i]<=rightPart[j]) {
			numbers[k]=leftPart[i];
			i++;
		}else{
			numbers[k]=rightPart[j];
			j++;
		}
		k++;
	}
	for(;i<leftPartLength;i++){
		numbers[k]=leftPart[i];
		k++;
	}
	for(;j<rightPartLength;j++){
		numbers[k]=rightPart[j];
		k++;
	}
}
	static void mergeSort(int[] numbers){
	int quantityNumbers=numbers.length;
	int middleElementNumber=0;
	int[] leftPart, rightPart;
	
	if(quantityNumbers<2){
		return; 
	}
	middleElementNumber=(int)quantityNumbers/2;
	leftPart=new int[middleElementNumber];
	rightPart=new int[quantityNumbers-middleElementNumber];
	
	for(int i=0;i<=middleElementNumber-1;i++){
		leftPart[i]=numbers[i];
	}
		
	for(int j=middleElementNumber;j<quantityNumbers;j++){
		rightPart[j-middleElementNumber]=numbers[j];
	}
	
	mergeSort(leftPart);
	mergeSort(rightPart);
	merge(leftPart, rightPart, numbers);
	
	}
	
	public static int[] generateRandomArray(int[] emptyArray) {
		Random rn = new Random();
		int[] fullArray = new int[emptyArray.length];
		
		for (int i = 0; i < emptyArray.length; i++) {
			fullArray[i] = rn.nextInt(10);
			System.out.print(fullArray[i] + " ");
		}
		System.out.println();
		return fullArray;
	}

}
