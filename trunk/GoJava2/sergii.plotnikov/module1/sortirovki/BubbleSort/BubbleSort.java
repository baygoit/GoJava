package ua.com.goit.gojava.plotnikov.bubblesort;

import java.util.Random;

public class BubbleSort {

	public static long operations =0;
	
	public static void main(String[] args){
		
		int size=10;
		int[] array = new int[size];
		
		fill(array, size);
		
		show(array, size);
		
		bubble(array, size);

		show(array, size);
		System.out.print("\noperations: " + operations);
	}
	
	public static void bubble(int[] array, int size){
		boolean swapped = true;
		
		while(swapped){
			swapped = false;
			
			for(int i = 0; i < array.length - 1; i++){
				
				if(array[i] > array[i + 1]){
					swapped = true;
					
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					operations++;
				}
			}
		}
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


