package ua.scread.sort;

/**
 * Realization of insertion sort (or Exchange sorting).
 * @author ScreaD
 *
 */
public class InsertionSort extends SortingAlgorithm {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public <E extends Comparable> void sort(E[] array) {
		for(int i = 1; i < array.length; i++){
			E currentItemValue = array[i];
			int j = i - 1;
			//shift elements to right and find necessary cell
			while(j >= 0 && array[j].compareTo(currentItemValue) > 0){
				array[j + 1] = array[j];
				//move left
				j --;
			}
			array[j + 1] = currentItemValue;
		}
	}
	
	@Override
	public String toString(){
		return InsertionSort.class.getSimpleName();
	}
}