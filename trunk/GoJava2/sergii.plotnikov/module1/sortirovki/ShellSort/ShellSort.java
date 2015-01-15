package ua.com.goit.gojava.plotnikov.shellsort;

import java.util.Random;

public class ShellSort {

	public static int operations =0;
	
	public static void main(String[] args) {
		int size=10;
		int[] array = new int[size];
		
		fill(array, size);
		
		show(array, size);
		
		sort(array, size);
		
		show(array, size);
		System.out.print("\noperations: " + operations);
	}
	
	public static void sort(int[] array, int size){
		int i,j,k;
		int temp;
		for(k = size/2; k > 0; k /=2){
	        for(i = k; i < size; i++){
	            temp = array[i];
	            for(j = i; j>=k; j-=k){
	                if(temp < array[j-k]){
	                    array[j] = array[j-k];
	                    operations++;
	                }
	                else{
	                    break;
	                }
	            }
	            array[j] = temp;
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
