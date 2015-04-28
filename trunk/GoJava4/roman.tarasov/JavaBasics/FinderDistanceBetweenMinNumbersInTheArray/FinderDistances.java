import java.util.Arrays;

public class FinderDistances {

	public static void main(String[] args) {

		int[] array;

		FinderDistances finder = new FinderDistances();
		try {
			array = new int[] { 1, 1, 2, 0};
			System.out.println("input                 "
					+ Arrays.toString(array));
			finder.work(array);
			System.out.println("-----------------------------------------");

			array = new int[] { 23, 45, 34, 12, 45, 4, 38, 56, 2, 49, 100 };
			System.out.println("input                 "
					+ Arrays.toString(array));
			finder.work(array);
			System.out.println("-----------------------------------------");

			array = new int[] { 1, 1, 2, 0, 1, 1, 4, 1 };
			System.out.println("input                 "
					+ Arrays.toString(array));
			finder.work(array);
			System.out.println("-----------------------------------------");

			array = new int[] { 1, 1, 2, 0, 1, 0, 4, 0 };
			System.out.println("input                 "
					+ Arrays.toString(array));
			finder.work(array);
			System.out.println("-----------------------------------------");

		} catch (Exception e) {
			System.out.println(e);

		}

	}

	void arrayValidate(int[] original) throws Exception {
		int originalLen = original.length;
		System.out.println(originalLen);
		if (originalLen <= 0) {
			throw new Exception("length of array should be greater than 0");

		}

	}

	void work(int[] pieceOfWork) throws Exception {

		arrayValidate(pieceOfWork);
		int sizeOfPieceOfWork = pieceOfWork.length;
		final int MARKED = 1;
		int[] indexesOfSorted = new int[sizeOfPieceOfWork];
		int[] markers =  new int[sizeOfPieceOfWork];
		int[] sorted =   new int[sizeOfPieceOfWork];
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

		System.out.println("sorted array          " + Arrays.toString(sorted));
		System.out
				.println("index of sorted array " + Arrays.toString(indexesOfSorted));

		int prevIndex = sorted[0];
		int currentIndex;
		for (currentIndex = 1; currentIndex < sizeOfPieceOfWork; currentIndex++) {
			if (sorted[currentIndex] != prevIndex) {
				break;
			}
		}
		if (currentIndex == 1) {

			int firstValue = indexesOfSorted[0];
			int currentPoint = sorted[1];
			int minDistance = Math.abs(indexesOfSorted[0] - indexesOfSorted[1]);
			int maxDistance = minDistance;
			int indMin = 1;
			int indMax = 1;

			for (currentIndex = 1; currentIndex < sizeOfPieceOfWork; currentIndex++) {

				if (sorted[currentIndex] != currentPoint) {
					break;
				}
				int currDist = Math.abs(indexesOfSorted[currentIndex] - firstValue);

				if (currDist < minDistance) {
					minDistance = currDist;
					indMin = currentIndex;
				}
				if (currDist > maxDistance) {
					maxDistance = currDist;
					indMax = currentIndex;
				}
			}
			currentIndex--;

			System.out
					.println("min distance " + minDistance + " between "
							+ pieceOfWork[indexesOfSorted[0]] + "[" + indexesOfSorted[0] + "]"
							+ " and " + pieceOfWork[indexesOfSorted[indMin]] + "["
							+ indexesOfSorted[indMin] + "]");
			System.out
					.println("max distance " + maxDistance + " between "
							+ pieceOfWork[indexesOfSorted[0]] + "[" + indexesOfSorted[0] + "]"
							+ " and " + pieceOfWork[indexesOfSorted[indMax]] + "["
							+ indexesOfSorted[indMax] + "]");
			return;
		}

		int minDistance = indexesOfSorted[1] - indexesOfSorted[0];

		int currentMinDist = minDistance;

		int minIndex = 1;
		for (int index = 1; index < currentIndex; index++) {

			currentMinDist = indexesOfSorted[index] - indexesOfSorted[index - 1];

			if (currentMinDist < minDistance) {
				minDistance = currentMinDist;
				minIndex = index;
			}
		}

		int maxDistance = indexesOfSorted[currentIndex - 1] - indexesOfSorted[0];

		System.out
				.println("min distance " + minDistance + " between "
						+ pieceOfWork[indexesOfSorted[minIndex - 1]] + "["
						+ indexesOfSorted[minIndex - 1] + "]" + " and "
						+ pieceOfWork[indexesOfSorted[minIndex]] + "["
						+ indexesOfSorted[minIndex] + "]");

		System.out.println("max distance " + maxDistance + " between "
				+ pieceOfWork[indexesOfSorted[0]] + "[" + indexesOfSorted[0] + "]" + " and "
				+ pieceOfWork[indexesOfSorted[currentIndex - 1]] + "["
				+ indexesOfSorted[currentIndex - 1] + "]");

	}
}
