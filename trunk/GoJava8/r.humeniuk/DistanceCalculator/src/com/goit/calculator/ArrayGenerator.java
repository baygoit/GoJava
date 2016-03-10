package com.goit.calculator;
import java.util.ArrayList;

public class ArrayGenerator {

	ArrayList<Integer> array = new ArrayList<Integer>();

	public ArrayGenerator(int dimension, int maximalValues) {
		for (int index = 0; index < dimension; index++) {
			array.add((int) (Math.random() * maximalValues));
		}
	}

	public ArrayList<Integer> getArray() {
		return array;
	}
}