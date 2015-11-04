package ua.com.goit.gojava7.mergesort;

public class Application {
	public static void main(String[] args) {
		
		Console console = new Console();
		MergeSort mergeSort = new MergeSort();
		
		console.showMenuForUser();
		
		int[] arrayOfUserInputedNumbers = console.getInputedUserNumbers();
		System.out.print("User's inputed numbers:");
		console.print(arrayOfUserInputedNumbers);
		
		int[] sortedUserInputedNumbers = mergeSort.sort(arrayOfUserInputedNumbers);
		System.out.print("Sorted inputed numbers:");
		console.print(sortedUserInputedNumbers);
	
	}
}
