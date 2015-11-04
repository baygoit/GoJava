package ua.com.goit.gojava7.mergesort;

public class Application {
	public static void main(String[] args) {
		
		Console console = new Console();
		MergeSort mergeSort = new MergeSort();
		
		console.start();
		
		int[] userInputedNumbers = console.getStorageOfUserNumbers();
		System.out.print("User's inputed numbers:");
		console.print(userInputedNumbers);
		
		int[] sortedUserInputedNumbers = mergeSort.sort(userInputedNumbers);
		System.out.print("Sorted inputed numbers:");
		console.print(sortedUserInputedNumbers);
	
	}
}
