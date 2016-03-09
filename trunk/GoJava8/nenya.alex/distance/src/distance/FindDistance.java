package distance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindDistance {

	public List<Integer> findDistances(List<Integer> list) {
		List<Integer> listOfIndexes = new ArrayList<>();
		List<Integer> distancesList = new ArrayList<>();

		if (list == null) {
			throw new NullPointerException();
		}
		if (list.size() == 0 || list.size() == 1) {
			distancesList.add(0);
			return distancesList;
		} else {

			MinElement minElement = findMinElement(list);

			if (isElementAlone(minElement, list)) {
				MinElement nextMinElement = findNextMinElement(minElement, list);
				distancesList.add(Math.abs(minElement.getIndex() - nextMinElement.getIndex()));
			} else {

				for (int i = 0; i < list.size(); i++) {
					if (list.get(i) == minElement.getItem()) {
						listOfIndexes.add(i);
					}
				}
				for (int i = 0; i < listOfIndexes.size() - 1; i++) {
					for (int j = i + 1; j < listOfIndexes.size(); j++) {
						distancesList.add(Math.abs(listOfIndexes.get(i) - listOfIndexes.get(j)));
					}
				}
			}

		}
		return distancesList;
	}

	private MinElement findNextMinElement(MinElement minElement, List<Integer> list) {
		int index = 0;
		List<Integer> helpList = new ArrayList<>(list);
		Collections.sort(helpList);
		int nextMin = helpList.get(1);
		for (int i = 0; i < list.size(); i++) {
			if (nextMin == list.get(i)) {
				index = i;
				break;
			}
		}
		return new MinElement(index, nextMin);
	}

	private boolean isElementAlone(MinElement minElement, List<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			if (minElement.getItem() == list.get(i) && minElement.getIndex() != i) {
				return false;
			}
		}
		return true;
	}

	public MinElement findMinElement(List<Integer> list) {
		int index = 0;
		int min = list.get(index);
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) < min) {
				min = list.get(i);
				index = i;
			}
		}
		return new MinElement(index, min);
	}

}
