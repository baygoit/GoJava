import java.util.Arrays;

public class DistanceSearcher {

	public static void main(String[] args) {

		int[] array;

		DistanceSearcher arraySort = new DistanceSearcher();

		array = new int[] { 1, 1, 1, 1, 1, 1, 1 };
		System.out.println("input                 " + Arrays.toString(array));
		arraySort.sort(array);
		System.out.println("-----------------------------------------");

		array = new int[] { 23, 45, 34, 12, 45, 4, 38, 56, 2, 49, 100 };
		System.out.println("input                 " + Arrays.toString(array));
		arraySort.sort(array);
		System.out.println("-----------------------------------------");

		array = new int[] { 1, 1, 2, 0, 1, 1, 4, 1 };
		System.out.println("input                 " + Arrays.toString(array));
		arraySort.sort(array);
		System.out.println("-----------------------------------------");

		array = new int[] { 1, 1, 2, 0, 1, 0, 4, 0 };
		System.out.println("input                 " + Arrays.toString(array));
		arraySort.sort(array);
		System.out.println("-----------------------------------------");

	}

	void sort(int[] inputArray) {

		int inpArrLen = inputArray.length;
		if (inpArrLen < 1) {
			System.out.println("the array have a length error");
			return;
		}
		int[] indexArr = new int[inpArrLen];
		int[] markArr = new int[inpArrLen];
		int[] sortedArr = new int[inpArrLen];
		int minVal = inputArray[0];
		int minInd = 0;

		for (int scanner = 0; scanner < inpArrLen; scanner++) {

			boolean minValCorrect = false;

			for (int inpArrInd = 0; inpArrInd < inpArrLen; inpArrInd++) {

				if (markArr[inpArrInd] != 0) {
					continue;
				}
				if (minValCorrect) {
					if (inputArray[inpArrInd] < minVal) {
						minVal = inputArray[inpArrInd];
						minInd = inpArrInd;
						continue;
					}
					continue;
				}
				minVal = inputArray[inpArrInd];
				minValCorrect = true;
				minInd = inpArrInd;
			}
			indexArr[scanner] = minInd;
			sortedArr[scanner] = minVal;
			markArr[minInd] = 1;
		}

		System.out.println("sorted array          "
				+ Arrays.toString(sortedArr));
		System.out
				.println("index of sorted array " + Arrays.toString(indexArr));

		int prevIndex = sortedArr[0];
		int currentIndex;
		for (currentIndex = 1; currentIndex < inpArrLen; currentIndex++) {
			if (sortedArr[currentIndex] != prevIndex) {
				break;
			}
		}
		if (currentIndex == 1) {

			int firstValue = indexArr[0];
			int currentPoint = sortedArr[1];
			int minDistance = Math.abs(indexArr[0] - indexArr[1]);
			int maxDistance = minDistance;
			int indMin = 1;
			int indMax = 1;

			for (currentIndex = 1; currentIndex < inpArrLen; currentIndex++) {

				if (sortedArr[currentIndex] != currentPoint) {
					break;
				}
				int currDist = Math.abs(indexArr[currentIndex] - firstValue);

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

			System.out.println("min distance " + minDistance + " between "
					+ inputArray[indexArr[0]] + "[" + indexArr[0] + "]"
					+ " and " + inputArray[indexArr[indMin]] + "["
					+ indexArr[indMin] + "]");
			System.out.println("max distance " + maxDistance + " between "
					+ inputArray[indexArr[0]] + "[" + indexArr[0] + "]"
					+ " and " + inputArray[indexArr[indMax]] + "["
					+ indexArr[indMax] + "]");
			return;
		}

		int minDistance = indexArr[1] - indexArr[0];

		int currentMinDist = minDistance;

		int minIndex = 1;
		for (int index = 1; index < currentIndex; index++) {

			currentMinDist = indexArr[index] - indexArr[index - 1];

			if (currentMinDist < minDistance) {
				minDistance = currentMinDist;
				minIndex = index;
			}
		}

		int maxDistance = indexArr[currentIndex - 1] - indexArr[0];

		System.out.println("min distance " + minDistance + " between "
				+ inputArray[indexArr[minIndex - 1]] + "["
				+ indexArr[minIndex - 1] + "]" + " and "
				+ inputArray[indexArr[minIndex]] + "[" + indexArr[minIndex]
				+ "]");

		System.out.println("max distance " + maxDistance + " between "
				+ inputArray[indexArr[0]] + "[" + indexArr[0] + "]" + " and "
				+ inputArray[indexArr[currentIndex - 1]] + "["
				+ indexArr[currentIndex - 1] + "]");

	}
}
