package lonelynumber;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LonelyNumber {

	public List<Integer> getLonelyNumber(int[] inputedNumbers, ConsolePrinter consolePrinter) {
		int[] userNumbers = inputedNumbers;
		List<Integer> result = new ArrayList<>();
		
		Set<Integer> uniqueNumbers = findsAllUniqueNumbers(userNumbers);
		findLonelyNumber(uniqueNumbers, inputedNumbers, result);
		return result;
	}
	
	private void findLonelyNumber(Set<Integer> uniqueNumbers, int[] userInputedNumbers, 
			List<Integer> result) {
		
		for (int unigueNumber : uniqueNumbers) {
			
			int amountOfDuplicates = 0;
			for (int number : userInputedNumbers) {
				if (unigueNumber == number) {
					amountOfDuplicates ++;
				}
			}

			if (amountOfDuplicates == 3) {
				result.add(unigueNumber);
			}
		}
	}
	
	private HashSet<Integer> findsAllUniqueNumbers(int[] inputedNumbers) {
		HashSet<Integer> uniqueNumbers = new HashSet<>();
		for (Integer number : inputedNumbers) {
			uniqueNumbers.add(number);
		}
		return uniqueNumbers;
	}
}
