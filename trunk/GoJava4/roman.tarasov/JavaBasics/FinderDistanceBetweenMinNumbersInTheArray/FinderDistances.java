import java.util.Arrays;

public class FinderDistances {
	int[] indexesOfSorted;
	int[] markers;
	int[] sorted;
	int[] pieceOfWork;
	int sizeOfPieceOfWork;
	long minDistance;
	long maxDistance;
	int pointerToMin;
	int pointerToMax;

	public static void main(String[] args) {
		FinderDistances finder = new FinderDistances();
		finder.testFinder(finder);
	}

	public void testFinder(FinderDistances finder) {
		pieceOfWork = new int[] { 1, 1, 1, 1 };
		System.out.println("input                 "
				+ Arrays.toString(pieceOfWork));
		finder.startWorker();
		System.out.println("-----------------------------------------");

		pieceOfWork = new int[] { 23, 45, 34, 12, 45, 4, 38, 56, 2, 49, 100 };
		System.out.println("input                 "
				+ Arrays.toString(pieceOfWork));
		finder.startWorker();
		System.out.println("-----------------------------------------");

		pieceOfWork = new int[] { 1, 1, 2, 0, 1, 1, 4, 1 };
		System.out.println("input                 "
				+ Arrays.toString(pieceOfWork));
		finder.startWorker();
		System.out.println("-----------------------------------------");

		pieceOfWork = new int[] { 1, 1, 2, 0, 1, 0, 4, 0 };
		System.out.println("input                 "
				+ Arrays.toString(pieceOfWork));
		finder.startWorker();
		System.out.println("-----------------------------------------");
	}

	void validateThePieceOfWork() {

	}

	void makeSortedAndIndexes() {
		final int MARKED = 1;
		int minimalInPieceOfWork = pieceOfWork[0];
		int whereMinimal = 0;

		for (int whereDoIndexes = 0; whereDoIndexes < sizeOfPieceOfWork; whereDoIndexes++) {
			boolean minFinded = false;
			for (int whereDoSort = 0; whereDoSort < sizeOfPieceOfWork; whereDoSort++) {
				if (markers[whereDoSort] == MARKED) {
					continue;
				}
				if (minFinded) {
					if (pieceOfWork[whereDoSort] < minimalInPieceOfWork) {
						minimalInPieceOfWork = pieceOfWork[whereDoSort];
						whereMinimal = whereDoSort;
						continue;
					}
					continue;
				}
				minimalInPieceOfWork = pieceOfWork[whereDoSort];
				minFinded = true;
				whereMinimal = whereDoSort;
			}
			indexesOfSorted[whereDoIndexes] = whereMinimal;
			sorted[whereDoIndexes] = minimalInPieceOfWork;
			markers[whereMinimal] = MARKED;
		}
	}

	int countDuplicatesOfFirstElementInSorted() {
		int firstElement = sorted[0];
		int counter;
		for (counter = 1; counter < sizeOfPieceOfWork; counter++) {
			if (sorted[counter] != firstElement) {
				break;
			}
		}
		return counter;
	}

	void searchMinMaxDistanceFirstAndLotDuplicates() {
		int firstElement = indexesOfSorted[0];
		int secondElement = sorted[1];
		minDistance = Math.abs(indexesOfSorted[0] - indexesOfSorted[1]);
		maxDistance = minDistance;
		pointerToMin = 1;
		pointerToMax = 1;

		for (int pointerToElem = 1; pointerToElem < sizeOfPieceOfWork; pointerToElem++) {

			if (sorted[pointerToElem] != secondElement) {
				break;
			}
			long searchedDistance = Math.abs(indexesOfSorted[pointerToElem]
					- firstElement);

			if (searchedDistance < minDistance) {
				minDistance = searchedDistance;
				pointerToMin = pointerToElem;
			}
			if (searchedDistance > maxDistance) {
				maxDistance = searchedDistance;
				pointerToMax = pointerToElem;
			}
		}
	}

	void showResult() {
		System.out.println("min distance " + minDistance + " between "
				+ pieceOfWork[indexesOfSorted[0]] + "[" + indexesOfSorted[0]
				+ "]" + " and " + pieceOfWork[indexesOfSorted[pointerToMin]]
				+ "[" + indexesOfSorted[pointerToMin] + "]");
		System.out.println("max distance " + maxDistance + " between "
				+ pieceOfWork[indexesOfSorted[0]] + "[" + indexesOfSorted[0]
				+ "]" + " and " + pieceOfWork[indexesOfSorted[pointerToMax]]
				+ "[" + indexesOfSorted[pointerToMax] + "]");
	}

	void startWorker() {
		sizeOfPieceOfWork = pieceOfWork.length;
		indexesOfSorted = new int[sizeOfPieceOfWork];
		markers = new int[sizeOfPieceOfWork];
		sorted = new int[sizeOfPieceOfWork];

		validateThePieceOfWork();
		makeSortedAndIndexes();

		System.out.println("sorted array          " + Arrays.toString(sorted));
		System.out.println("index of sorted array "
				+ Arrays.toString(indexesOfSorted));

		int countDuplicates = countDuplicatesOfFirstElementInSorted();
		int currentIndex = countDuplicates;

		if (currentIndex == 1) {
			searchMinMaxDistanceFirstAndLotDuplicates();
			showResult();
			return;
		}

		int minDistance = indexesOfSorted[1] - indexesOfSorted[0];

		int currentMinDist = minDistance;

		int minIndex = 1;
		for (int index = 1; index < currentIndex; index++) {

			currentMinDist = indexesOfSorted[index]
					- indexesOfSorted[index - 1];

			if (currentMinDist < minDistance) {
				minDistance = currentMinDist;
				minIndex = index;
			}
		}

		int maxDistance = indexesOfSorted[currentIndex - 1]
				- indexesOfSorted[0];
		showResult();
		/*
		System.out.println("min distance " + minDistance + " between "
				+ pieceOfWork[indexesOfSorted[minIndex - 1]] + "["
				+ indexesOfSorted[minIndex - 1] + "]" + " and "
				+ pieceOfWork[indexesOfSorted[minIndex]] + "["
				+ indexesOfSorted[minIndex] + "]");

		System.out.println("max distance " + maxDistance + " between "
				+ pieceOfWork[indexesOfSorted[0]] + "[" + indexesOfSorted[0]
				+ "]" + " and "
				+ pieceOfWork[indexesOfSorted[currentIndex - 1]] + "["
				+ indexesOfSorted[currentIndex - 1] + "]");
		*/
	}
}
// currentIndex--;
/*
 * System.out.println("min distance " + minDistance + " between " +
 * pieceOfWork[indexesOfSorted[0]] + "[" + indexesOfSorted[0] + "]" + " and " +
 * pieceOfWork[indexesOfSorted[indMin]] + "[" + indexesOfSorted[indMin] + "]");
 * System.out.println("max distance " + maxDistance + " between " +
 * pieceOfWork[indexesOfSorted[0]] + "[" + indexesOfSorted[0] + "]" + " and " +
 * pieceOfWork[indexesOfSorted[indMax]] + "[" + indexesOfSorted[indMax] + "]");
 */