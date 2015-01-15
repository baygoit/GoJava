package ua.com.goit.gojava.plotnikov.mergesort;

import java.util.Random;

public class MergeSort {
	
	public static int operations =0;
	public static void main(String[] args) {
		int size=10;
		int[] array = new int[size];
		
		fill(array, size);
		
		show(array, size);
		
		array=merge(array);
		
		show(array, size);

		System.out.print("\noperations: " + operations);
	}

		
	public static int[] merge(int[] array){
		if(array.length>1){
			int lengthA1 = array.length/2;
			int lengthA2 = array.length/2;
			
			if(array.length%2==1){
				lengthA2+=1;
			}
			
			int tempA1[] = new int[lengthA1];
			int tempA2[] = new int[lengthA2];
			
			for(int i =0; i<lengthA1; i++){
				tempA1[i] = array[i];
			}
			
			for(int i=lengthA1; i<array.length; i++){
				tempA2[i-lengthA1]=array[i];
			}
			
			tempA1 = merge(tempA1);
			tempA2 = merge(tempA2);
			
			int arrayIndex =0, indexA1=0, indexA2=0;
			
			while(tempA1.length != indexA1 && tempA2.length != indexA2){
				if(tempA1[indexA1]<tempA2[indexA2]){
					array[arrayIndex] = tempA1[indexA1];
					arrayIndex++;
					indexA1++;
					operations++;
				}
				else{
					array[arrayIndex] = tempA2[indexA2];
					arrayIndex++;
					indexA2++;
					operations++;
				}
			}
			
			while(tempA1.length != indexA1)
			{
				array[arrayIndex] = tempA1[indexA1];
				arrayIndex++;
				indexA1++;
				operations++;
			}
			while(tempA2.length != indexA2)
			{
				array[arrayIndex] = tempA2[indexA2];
				arrayIndex++;
				indexA2++;
				operations++;
			}
		}
		return array;
	}
	
	public static void fill(int[] array, int size){
		for(int i = 0; i<size; i++){
			Random ran = new Random();
			int x = ran.nextInt(size*10);
			array[i] = x;
		}
	}
	
	public static void show(int[] array, int size){
		for(int i = 0; i<size; i++){
			System.out.print(array[i] +" ");
		}
		System.out.println("");
	}
}