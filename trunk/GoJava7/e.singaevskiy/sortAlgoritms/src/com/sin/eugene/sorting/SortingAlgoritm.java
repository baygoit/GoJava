package com.sin.eugene.sorting;

public interface SortingAlgoritm {
	void sort(int[] array);

	default String getName(){
		return this.getClass().getSimpleName();
	};
	
	
}
