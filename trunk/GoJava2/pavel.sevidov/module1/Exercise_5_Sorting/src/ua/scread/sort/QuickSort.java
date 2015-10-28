package ua.scread.sort;

/**
 * Recursive sorting using the method of bisection.
 * @author ScreaD
 *
 */
public class QuickSort extends SortingAlgorithm {
	
	@SuppressWarnings("rawtypes")
	@Override
	public <E extends Comparable> void sort(E[] array) {
		quickSort(array, 0, array.length - 1);
	}
	
	@SuppressWarnings("rawtypes")
	private <E extends Comparable> void quickSort(E[] array, int left, int right){
		if(left >= right)
			return;
		//if array has already been sorted then last element is max of array
		//we need to swap last pivot element with random from [left, right]
		swap(array, right, (int) Math.random()*(right + 1) + left);
		int pivotIndex = partition(array, left, right);
		quickSort(array, left, pivotIndex - 1);
		quickSort(array, pivotIndex + 1, right);
	}
	/**
	 * @param array - array which must be sorted.
	 * @param left - index of left element.
	 * @param right - index of right element.
	 * @return index of pivot element between two sorted sub arrays.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private <E extends Comparable> int partition(E[] array, int left, int right){
		int leftIndex = left - 1;
		//structure of array: [ { <= pivot} {> pivot}  {pivot} ]
		for(int rightIndex = left; rightIndex < right + 1; rightIndex ++) {
			//if next element in right part <= pivot
			if(array[rightIndex].compareTo(array[right]) <= 0){
				swap(array, rightIndex, leftIndex + 1);
				//expand left sub array
				leftIndex ++;
			}
		}
		return leftIndex;
	}
	
	@Override
	public String toString(){
		return QuickSort.class.getSimpleName();
	}
}