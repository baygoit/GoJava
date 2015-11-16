package ua.com.goit.gojava7.sort.sorting;

public interface SortingAlgoritm {
	void sort(int[] array);

	default String getName(){
		return this.getClass().getSimpleName();
	};
	
	
}
