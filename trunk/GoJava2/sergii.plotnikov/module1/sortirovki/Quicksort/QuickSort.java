package ua.com.goit.gojava.plotnikov.quicksort;

import java.util.Random;

public class QuickSort {

	public static int operations =0;
	
	public static void main(String[] args) {
		
		int size=100000;
		int[] array = new int[size];
		
		fill(array, size);
		
		show(array, size);
		
		sort(array);
		
		show(array, size);
		System.out.print("\noperations: " + operations);
	}
	
	public static void sort(int[] array){
		sort(array, 0, array.length-1);
	}
	
	public static void sort(int[] array, int start, int end){
		int i = start;
		int k = end;
		
		if(end-start>=1){
			int pivot=array[start];
			
			while(k>i){
				while (array[i] <= pivot && i <= end && k > i){
					i++;
				}
				while (array[k] > pivot && k >= start && k >= i){
					k--;
				}
				if(k>i){
					swap(array, i, k);
					operations++;
				}
			}
				swap(array, start, k);
				operations++;
				sort(array, start, k-1);
				sort(array, k+1, end);
		}		
		else{
			return;
		}
	}
	
	public static void swap(int array[], int index1, int index2){
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2]=temp;
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

	