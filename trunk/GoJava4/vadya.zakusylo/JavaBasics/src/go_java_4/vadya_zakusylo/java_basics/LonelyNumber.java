package go_java_4.vadya_zakusylo.java_basics;

import java.util.LinkedList;

public class LonelyNumber {

	public int findLonelyNumber(int[] array) {
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		int lonelyNumber = 0;
		int index = 0;
		for (int value : array) {
			linkedList.add(index, value);
		}
//		linkedList.sort(array);
		return lonelyNumber;
	}
	
	
}
