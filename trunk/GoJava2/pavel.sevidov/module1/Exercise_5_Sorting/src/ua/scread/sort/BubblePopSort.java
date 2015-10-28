package ua.scread.sort;


/**
 * Bubble sorting. Each max element pops up from array's beginning to end.
 * @author ScreaD
 */
public class BubblePopSort extends SortingAlgorithm {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public <E extends Comparable> void sort(E[] array) {
		for(int i = 0; i < array.length - 1; i++){
			for(int j = 0; j < array.length - 1 - i; j++){
				if(array[j].compareTo(array[j+1]) > 0){
					swap(array, j, j + 1);
				}
			}
		}
	}
	
	@Override
	public String toString(){
		return BubblePopSort.class.getSimpleName();
	}
}
