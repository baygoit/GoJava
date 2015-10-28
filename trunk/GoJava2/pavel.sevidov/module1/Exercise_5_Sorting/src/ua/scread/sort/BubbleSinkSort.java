package ua.scread.sort;

/**
 * Bubble sorting. Each min element sink from array's end to beginning.
 * @author ScreaD
 *
 */
public class BubbleSinkSort extends SortingAlgorithm {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public <E extends Comparable> void sort(E[] array) {
		for(int i = array.length - 1; i >= 0; i--){
			for(int j = array.length - 1; j >= array.length - i; j--){
				if(array[j].compareTo(array[j - 1]) < 0){
					swap(array, j, j - 1);
				}
			}
		}

	}
	@Override
	public String toString(){
		return BubbleSinkSort.class.getSimpleName();
	}
}