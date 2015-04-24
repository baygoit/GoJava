package ua.scread.sort;

/**
 * It's a class for sorting arrays.<i>(it's a context in state machine pattern)</i>
 * Each state of this class is a separate sorting method. Sorter has such states:
 * <b>BubblePopSort, BubbleSinkSort, DefaultSort, InsertionSort, MergeSort, QuickSort</b>
 * @author ScreaD
 * @see ua.scread.generator.ArrayGenerator
 * @version 1.0
 */
public class Sorter {
	private SortingAlgorithm defaultSorter;
	
	public Sorter(){
		defaultSorter = new QuickSort();
	}
	@SuppressWarnings("rawtypes")
	public <E extends Comparable> void sort(E[] array){
		defaultSorter.sort(array);
	}
	public SortingAlgorithm getSorter() {
		return defaultSorter;
	}

	public void setSorter(SortingAlgorithm sorter) {
		this.defaultSorter = sorter;
	}	
}