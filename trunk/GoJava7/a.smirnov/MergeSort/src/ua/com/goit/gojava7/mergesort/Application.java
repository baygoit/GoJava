package ua.com.goit.gojava7.mergesort;

public class Application {
	public static void main(String[] args) {
		
		Console console = new Console();
		MergeSort mergeSort = new MergeSort();
		
		// Eugene: From here I can't understand, what happens in 'start' method
		console.start();
		
		// Eugene: Maybe 'userArray' sounds a bit better. But nevermind
		// Eugene: 'getStorage' sounds like it will return some Storage, not array
		int[] userInputedNumbers = console.getStorageOfUserNumbers();
		// Eugene: if you make output using 'Console' class, why here you use SOP?
		System.out.print("User's inputed numbers:");
		console.print(userInputedNumbers);
		
		int[] sortedUserInputedNumbers = mergeSort.sort(userInputedNumbers);
		System.out.print("Sorted inputed numbers:");
		console.print(sortedUserInputedNumbers);
	
	}
}
