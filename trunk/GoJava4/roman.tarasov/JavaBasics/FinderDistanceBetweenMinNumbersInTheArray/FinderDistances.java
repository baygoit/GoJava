import java.util.Arrays;

public class FinderDistances {
	int[] index;
	int[] markers;
	int[] sorted;
	int[] arrayToWork;
	int sizeOfArrayToWork;
	int minDistance;
	int maxDistance;
	int toFirstResultOfMinDist;
	int toSecondResultOfMinDist;
	int toFirstResultOfMaxDist;
	int toSecondResultOfMaxDist;
	int countDuplicates;

	public static void main(String[] args) {
		FinderDistances finder = new FinderDistances();
		finder.testFinder(finder);
	}

	public void testFinder(FinderDistances finder) {
		arrayToWork = new int[] { 0, 1, 1, 0, 1, 0 };
		System.out.println("input                 "
				+ Arrays.toString(arrayToWork));
		finder.startWorker();
		System.out.println("-----------------------------------------");

		arrayToWork = new int[] { 23, 45, 34, 12, 45, 4, 38, 56, 2, 49, 100 };
		System.out.println("input                 "
				+ Arrays.toString(arrayToWork));
		finder.startWorker();
		System.out.println("-----------------------------------------");

		arrayToWork = new int[] { 1, 1, 2, 0, 1, 1, 4, 1 };
		System.out.println("input                 "
				+ Arrays.toString(arrayToWork));
		finder.startWorker();
		System.out.println("-----------------------------------------");

		arrayToWork = new int[] { 1, 1, 2, 0, 1, 0, 4, 0 };
		System.out.println("input                 "
				+ Arrays.toString(arrayToWork));
		finder.startWorker();
		System.out.println("-----------------------------------------");
	}

	void validateArrayToWork() {

	}

	void makeSortedAndIndexes() {
		final int MARKED = 1;
		final int POINTER_TO_FIRST_ELEMENT = 0;
		int minimalInArrayToWork = arrayToWork[POINTER_TO_FIRST_ELEMENT];
		int whereMinimal = 0;

		for (int pointer = POINTER_TO_FIRST_ELEMENT; pointer < sizeOfArrayToWork; pointer++) {
			boolean minFinded = false;
			for (int whereDoSort = POINTER_TO_FIRST_ELEMENT; whereDoSort < sizeOfArrayToWork; whereDoSort++) {
				if (markers[whereDoSort] == MARKED) {
					continue;
				}
				if (minFinded) {
					if (arrayToWork[whereDoSort] < minimalInArrayToWork) {
						minimalInArrayToWork = arrayToWork[whereDoSort];
						whereMinimal = whereDoSort;
						continue;
					}
					continue;
				}
				minimalInArrayToWork = arrayToWork[whereDoSort];
				minFinded = true;
				whereMinimal = whereDoSort;
			}
			index[pointer] = whereMinimal;
			sorted[pointer] = minimalInArrayToWork;
			markers[whereMinimal] = MARKED;
		}
	}

	int countDuplicatesOfFirstSortedElement() {
		final int POINTER_TO_FIRST_ELEMENT = 0;
		final int POINTER_TO_SECOND_ELEMENT = 1;
		int firstSortedElement = sorted[POINTER_TO_FIRST_ELEMENT];
		int counter;
		for (counter = POINTER_TO_SECOND_ELEMENT; counter < sizeOfArrayToWork; counter++) {
			if (sorted[counter] != firstSortedElement) {
				break;
			}
		}
		return counter;
	}

	void doForSecondDuplicatedElements() {
		final int POINTER_TO_FIRST_ELEMENT = 0;
		final int POINTER_TO_SECOND_ELEMENT = 1;

		int firstIndexedElement = index[POINTER_TO_FIRST_ELEMENT];
		int secondSortedElement = sorted[POINTER_TO_SECOND_ELEMENT];

		minDistance = Math.abs(index[POINTER_TO_FIRST_ELEMENT]
				- index[POINTER_TO_SECOND_ELEMENT]);
		maxDistance = minDistance;
		int toFirstResult = POINTER_TO_SECOND_ELEMENT;
		int toSecondResult = POINTER_TO_SECOND_ELEMENT;

		for (int currentPointerToElem = POINTER_TO_SECOND_ELEMENT; currentPointerToElem < sizeOfArrayToWork; currentPointerToElem++) {

			if (sorted[currentPointerToElem] != secondSortedElement) {

				break;
			}

			int obtainedDistance = Math.abs(index[currentPointerToElem]
					- firstIndexedElement);

			if (obtainedDistance < minDistance) {
				minDistance = obtainedDistance;
				toFirstResult = currentPointerToElem;
			}
			if (obtainedDistance > maxDistance) {
				maxDistance = obtainedDistance;
				toSecondResult = currentPointerToElem;
			}
		}
		toFirstResultOfMinDist = firstIndexedElement;
		toSecondResultOfMinDist = index[toFirstResult];
		toFirstResultOfMaxDist = firstIndexedElement;
		toSecondResultOfMaxDist = index[toSecondResult];
	}

	void showResult() {
		System.out.println("min distance " + minDistance + " between "
				+ arrayToWork[toFirstResultOfMinDist] + "["
				+ toFirstResultOfMinDist + "]" + " and "
				+ arrayToWork[toSecondResultOfMinDist] + "["
				+ toSecondResultOfMinDist + "]");

		System.out.println("max distance " + maxDistance + " between "
				+ arrayToWork[toFirstResultOfMaxDist] + "["
				+ toFirstResultOfMaxDist + "]" + " and "
				+ arrayToWork[toSecondResultOfMaxDist] + "["
				+ toSecondResultOfMaxDist + "]");
	}

	void startWorker() {

		sizeOfArrayToWork = arrayToWork.length;
		index = new int[sizeOfArrayToWork];
		markers = new int[sizeOfArrayToWork];
		sorted = new int[sizeOfArrayToWork];

		validateArrayToWork();
		makeSortedAndIndexes();

		System.out.println("sorted array          " + Arrays.toString(sorted));
		System.out.println("index of sorted array " + Arrays.toString(index));

		int countDuplicates = countDuplicatesOfFirstSortedElement();

		if (countDuplicates == 1) {
			doForSecondDuplicatedElements();
			showResult();
			return;
		}
		doForFirstDuplicatedSortedElements();
		showResult();
	}

	void doForFirstDuplicatedSortedElements() {
		final int POINTER_TO_FIRST_ELEMENT = 0;
		final int POINTER_TO_SECOND_ELEMENT = 1;
		minDistance = index[POINTER_TO_SECOND_ELEMENT]
				- index[POINTER_TO_FIRST_ELEMENT];
		int obtainedDistance = minDistance;
		int currentPointerToSecondResult = POINTER_TO_SECOND_ELEMENT;
		for (int currentPointerToElem = POINTER_TO_SECOND_ELEMENT; currentPointerToElem < countDuplicates; currentPointerToElem++) {

			obtainedDistance = index[currentPointerToElem]
					- index[currentPointerToElem - 1];

			if (obtainedDistance < minDistance) {
				minDistance = obtainedDistance;
				currentPointerToSecondResult = currentPointerToElem;
			}
		}
		toFirstResultOfMinDist = index[currentPointerToSecondResult - 1];
		toSecondResultOfMinDist = index[currentPointerToSecondResult];
		maxDistance = index[countDuplicates - 1] - index[0];
		toFirstResultOfMaxDist = index[0];
		toSecondResultOfMaxDist = index[countDuplicates - 1];
	}
}
