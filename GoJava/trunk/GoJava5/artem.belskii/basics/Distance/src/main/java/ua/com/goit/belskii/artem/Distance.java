package ua.com.goit.belskii.artem;

import java.util.Arrays;

public class Distance {
	private int [] sortedList;
	public void sort(int [] list){
		sortedList = list.clone();
		Arrays.sort(sortedList);
	}
	
	public int findPosition(int[] list, int value) {
		int answer = -1;
		for (int i = 0; i < list.length; i++) {
			if (value == list[i]) {
				answer = i;
				break;
			}
		}
		return answer;
	}

	public int findDistance(int[] list) {
		this.sort(list);
		int min = sortedList[0];
		int min2 = sortedList[1];
		int minPosition = this.findPosition(list, min);
		int maxPosition = this.findPosition(list, min2);
		return maxPosition - minPosition;
	}

}
