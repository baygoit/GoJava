package ua.scread.sort;

import java.util.Arrays;

/**
 * This class uses Arrays.sort.
 * @author ScreaD
 *
 */
public class DefaultSort extends SortingAlgorithm {
	
	@SuppressWarnings("rawtypes")
	@Override
	public <E extends Comparable> void sort(E[] array) {
		Arrays.sort(array);
	}
	
	@Override
	public String toString(){
		return DefaultSort.class.getSimpleName();
	}
}
