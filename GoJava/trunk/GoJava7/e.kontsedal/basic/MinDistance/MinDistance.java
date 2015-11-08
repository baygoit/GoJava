import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class MinDistance {

	public static void main(String[] args) throws IOException {
		int[] randomArray = creatingRandomArray();
		
		try {
			TreeSet<Integer> indexesOfMinimalNumbers = creatingSetOfIndexes(randomArray);	
			printIndexesOfMinimalNumbers(indexesOfMinimalNumbers);
			printDistances(indexesOfMinimalNumbers);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("\nOnly one element in array!");
		}
	}

	public static void printDistances(TreeSet<Integer> indexesOfMinimalNumbers) {
		Integer[] index = indexesOfMinimalNumbers.toArray(new Integer[indexesOfMinimalNumbers.size()]);
		System.out.print("\nDistance(s): ");
		for (int i = 0; i < index.length - 1; i++) {
			for (int j = i + 1; j < index.length; j++) {
				System.out.print(index[j] - index[i] + " ");
			}
		}
	}

	public static void printIndexesOfMinimalNumbers(TreeSet<Integer> indexesOfMinimalNumbers) {
		System.out.print("\nIndexes of min numbers: ");
		for (Integer index : indexesOfMinimalNumbers) {
			System.out.print(index + " ");
		}
	}

	public static TreeSet<Integer> creatingSetOfIndexes(int[] randomArray) {
		
		int firstMinimalNumber, secondMinimalNumber, indexOfMinElement;
		TreeSet<Integer> set = new TreeSet<Integer>();

		if (randomArray[0] < randomArray[1]) {
			firstMinimalNumber = randomArray[0];
			secondMinimalNumber = randomArray[1];
			indexOfMinElement = 0;
		} else {
			firstMinimalNumber = randomArray[1];
			secondMinimalNumber = randomArray[0];
			indexOfMinElement = 1;
		}

		for (int i = 2; i < randomArray.length; i++) {
			if (firstMinimalNumber > randomArray[i] && secondMinimalNumber > randomArray[i]) {
				secondMinimalNumber = firstMinimalNumber;
				firstMinimalNumber = randomArray[i];
				indexOfMinElement = i;
			} else if (secondMinimalNumber > randomArray[i]) {
				secondMinimalNumber = randomArray[i];
			}
		}

		if (firstMinimalNumber == secondMinimalNumber) {
			for (int i = 0; i < randomArray.length; i++) {
				if (randomArray[i] == firstMinimalNumber)
					set.add(i);
			}
		} else {
			set.add(indexOfMinElement);
			for (int i = 0; i < randomArray.length; i++) {
				if (randomArray[i] == secondMinimalNumber)
					set.add(i);
			}
		}
		return set;
	}

	public static int[] creatingRandomArray() throws IOException {
		System.out.println("The number of numbers \n");

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int[] numbers = new int[Integer.parseInt(reader.readLine())];
		System.out.print("Random array of " + numbers.length + ": ");

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = (int) (Math.random() * 100);
			System.out.print(numbers[i] + " ");
		}
		return numbers;
	}

}
