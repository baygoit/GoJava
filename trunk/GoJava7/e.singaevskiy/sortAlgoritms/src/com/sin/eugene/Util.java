package com.sin.eugene;

import java.util.Random;

public class Util {

	private Util(){}
	
 	public static void swap(int[] array, int i, int j) {
		int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    
 	public static int[] randomArray(int size) {
		int[] array = new int[size];
		Random rnd = new Random();
		
		for (int i = 0; i < array.length; i++) {
			array[i] = rnd.nextInt(size);
		}

		return array;
    }

}
