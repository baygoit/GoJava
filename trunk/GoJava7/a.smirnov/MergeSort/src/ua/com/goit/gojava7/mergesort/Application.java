package ua.com.goit.gojava7.mergesort;

public class Application {
	public static void main(String[] args) {
		
		Console console = new Console();
		MergeSort mergeSort = new MergeSort();
		
		console.showMenuForUser();
		
		int[] arrayOfUserInputedNumbers = console.getInputedUserNumbers();
		console.printInputedArray(arrayOfUserInputedNumbers);
		
		int[] sortedUserInputedNumbers = mergeSort.sort(arrayOfUserInputedNumbers);
		console.printSortedArray(sortedUserInputedNumbers);
		
		console.closeScanner();
	
	}
}
