package ua.com.goit.gojava.plotnikov.insertionsort;

import java.util.Random;

public class InsertionSort {

	public static long operations =0;
	
	public static void main(String[] args) {
			
		int size=10;
		int[] array = new int[size];
		
		fill(array, size);
		
		show(array, size);
		
		insertion(array, size);
		
		show(array, size);
		System.out.print("\noperations: " + operations);
	}
	
	public static void insertion(int[] array, int size){
		for(int i = 1; i < array.length; i++){
			int temp = array[i];
			int prevPos = i-1;
				
			while(prevPos >= 0 && array[prevPos] > temp){
				array[prevPos+1] = array[prevPos];
				array[prevPos] = temp;
				prevPos--;
				operations++;
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