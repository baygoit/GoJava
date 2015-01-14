package ua.scread.sort;

/**
 * Array's sorting with merge.
 * @author ScreaD
 *
 */
public class MergeSort extends SortingAlgorithm {
	@SuppressWarnings("rawtypes")
	private Comparable[] workArray;
	
	
	@SuppressWarnings("rawtypes")
	@Override
	public <E extends Comparable> void sort(E[] array) {
		workArray = new Comparable[array.length];
		mergeSort(array, workArray, 0, array.length - 1);
	}
	
	@SuppressWarnings("rawtypes")
	private <E extends Comparable> void mergeSort(E[] array, 
			E[] workArray, int leftIndex, int rightIndex){
		if(leftIndex >= rightIndex){
			return;
		} else {
			int middle = leftIndex +  (rightIndex - leftIndex) / 2;
			//sort left part
			mergeSort(array, workArray, leftIndex, middle);
			//sort right part
			mergeSort(array, workArray, middle + 1, rightIndex);
			//merge parts
			merge(array, workArray, leftIndex, middle, rightIndex);
		}
	}
	
	//stably merge array[leftIndex .. middle] with 
	//a[middle+1 ..rightIndex] using workArray[leftIndex .. rightIndex]
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private <E extends Comparable> void merge(E[] array, E[] workArray, int leftIndex,
			int middleIndex, int rightIndex){
		//copy to workArray
		for(int i = 0; i <= rightIndex; i ++ ){
			workArray[i] = array[i];
		}
		int i = leftIndex;
		int j = middleIndex + 1;
		for(int k = leftIndex; k <= rightIndex; k++){
			//if there is no elements in left part
			if(i > middleIndex)
				array[k] = (E)  workArray[j++];
			//if there is no elements in right part
			else if(j > rightIndex)
				array[k] = (E) workArray[i++];
			else if(workArray[i].compareTo(workArray[j]) < 0)
				array[k] = (E) workArray[i++];
			else
				array[k] = (E) workArray[j++];
		}
	}
	
	@Override
	public String toString(){
		return MergeSort.class.getSimpleName();
	}
}
