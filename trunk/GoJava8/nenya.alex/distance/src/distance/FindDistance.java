package distance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindDistance {

	public static void main(String[] args) throws NumberFormatException, IOException {
		FindDistance fd = new FindDistance();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new ArrayList<>();
		String str;

		System.out.println("Enter the numbers");
		while (!(str = reader.readLine()).isEmpty()) {
			if (fd.isValid(str)) {
				list.add(Integer.parseInt(str));
			}

		}
		MinElement minElement = fd.findMinElement(list);

		if (fd.isElementAlone(minElement, list)) {
			MinElement nextMinElement = fd.findNextMinElement(minElement, list);
			System.out.println("distance = " + Math.abs(minElement.getIndex() - nextMinElement.getIndex()));
		} else {
			List<Integer> listOfDistatce = fd.findDistances(minElement, list);
			System.out.println("List of distances is " + listOfDistatce);
		}

	}

	private List<Integer> findDistances(MinElement minElement, List<Integer> list) {
		List<Integer> listOfIndexes = new ArrayList<>();
		List<Integer> listOfDistances = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == minElement.getItem()) {
				listOfIndexes.add(i);
			}
		}
		for (int i = 0; i < listOfIndexes.size() - 1; i++) {
			for (int j = i + 1; j < listOfIndexes.size(); j++) {
				listOfDistances.add(Math.abs(listOfIndexes.get(i) - listOfIndexes.get(j)));
			}
		}
		return listOfDistances;
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

	private MinElement findMinElement(List<Integer> list) {
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

	private boolean isValid(String str) {
		boolean b = false;
		try {
			Integer.parseInt(str);
			b = true;
		} catch (NumberFormatException e) {
			System.out.println("Wrong entering! Try again!");
		}

		return b;

	}
}
