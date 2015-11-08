package homework1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * // OLEG very usefull :) Don't we know the name of the file? What if we rename it once?
 * MergeSort.java
 * 
 * // OLEG git knows. Why we need this?
 * @author Anton Smirnov
 * // OLEG what is this about?
 * @version 03.11.2015
 * // OLEG why?
 * @java 7
 * // OLEG why?
 * @category homework1
 *
 */
 // OLEG Why we need this comment at all? Do we have some convension or requirements for this comment?

public class MergeSort {
	public static void main(String[] args) {

		// OLEG why we need this comment? We still testing?
		// Testing
		// OLEG Ok, we start program. And it's running. And never ends?
		// OLEG why startPROGRAM? why no startSorting()? or just start()? or sort()? Ah, we do not sort, we get numbers from STDIN, sort and print all of them back to STDOUT.... Good luck with name :)
		new MergeSort().startProgram();
	}

	public void startProgram() {
		// OLEG why it user numbers? Does it makes sense where we get these number in startProgram() below?
		int[] userNumbers = setupUserNumbers();

		// OLEG we need this comment? really? Can we get name for method so we can avoid comment for 1 line method?
		// Printing into console user's inserted numbers
		printInsertedNumbers(userNumbers);

		// OLEG ok, it looks like we wanna comment each line of java code... :)
		// Sorting user's inserted numbers
		int[] sortedNumbers = sortMerge(userNumbers);

		// OLEG ok printSortedNumbers we can not know that  we "Printing into console sorted numbers". Let's add console to name of method :)
		// Printing into console sorted numbers
		printSortedNumbers(sortedNumbers);
	}

	// OLEG ok, 1 line - 1 comment. 1 method - 1 comment. Why?
	// Setup input data by User
	// OLEG setup... I think getNumbersFromUser() can be better. Setup is not associated with user input for me
	private int[] setupUserNumbers() {
		// OLEG where is comment? I thought we wanna comment for each line? Inaccurate...
		// OLEG this " + "... Why?
		// OLEG this instruction variable - why we need it at all? here? local? why not inline?
		String instruction = "Please insert integer numbers " + "(not more than 20 numbers) separated by spaces: ";
		System.out.println(instruction);

		// OLEG I dislike an infinite loops. But ok, may be it's pesonal. Just you have to be sure it will ends.
		while (true) {
			try {
				Scanner in = new Scanner(System.in);
				// OLEG temp? Can it be named more concret? userInputedString? Open your mind
				String tempText = in.nextLine();
				// OLEG text? text associated with String. Not with array of String. Think about another name/
				String[] inputUserText = tempText.split(" ");
				// OLEG ok, now i see why in startProgram() we use the name userNumbers. Here it's userNumber. But not there.
				int[] userNumbers = new int[inputUserText.length];

				for (int barrier = 0; barrier < inputUserText.length; barrier++) {
					userNumbers[barrier] = Integer.parseInt(inputUserText[barrier]);
				}

				// OLEG wait. we do something, and after this check some precondition? why? length should be checked before
				// OLEG we can check size on inputUserText instead of userNumbers
				if (userNumbers.length > 20 || userNumbers.length == 0) {
					// OLEG bad. please, never throw Exception or RuntimeException. Did we add this to our code convension? No? Ok, let's discuss and add.
					throw new Exception();
				} else {
					// OLEG ok, user at least have CTRL+C to try to stop our application if he too bored to understand how to input number 
					return userNumbers;
				}
			} catch (Exception e) {
				// OLEG ok, monkey test will show us, that this error message is not enouph. Usually user wanna know more about what exactly error was, were and how to fix it.
				System.out.println("User inserted wrong value. " 
									+ "Please try again." 
									// OLEG System.lineSeparator()? Why?
									// OLEG And this tabs or staces....
									// OLEG Do you know the joke http://kotorov.ru/anek.php?1601? The same instructions again and again. Be more concrete. On 3rd time user will hate you for the same message.
									+ System.lineSeparator() + instruction);
			}
		}
	}

		// OLEG ah, nice, comment for method again.
		// Dividing user storage of numbers on two halves and sorting its
		// OLEG check our code convention. UserNumbers is a name for class, not variable.
		// OLEG why not just sort()?
		private int[] sortMerge(int[] UserNumbers) {
			if (UserNumbers.length < 2) {
				return UserNumbers;
			}
			int middleOfArrayLength = UserNumbers.length / 2;
	
			// OLEG we can avoid Arrays.copy at all, I think. Not sure. Bot ok.
			// OLEG Just too many actions for 1 line
			return merge(sortMerge(Arrays.copyOfRange(UserNumbers, 0, middleOfArrayLength)),
					sortMerge(Arrays.copyOfRange(UserNumbers, middleOfArrayLength, UserNumbers.length)));
		}
	
		// OLEG ok, i get it
		// Merging two sorted arrays in one general
		private int[] merge(int[] firstArray, int[] secondArray) {
	
			int indexOfFirstArray = 0, indexOfSecondArray = 0;
			// OLEG do we use a lot of memory? again and again? can we avoid this? I don't know now
			int[] result = new int[firstArray.length + secondArray.length];
	
			// OLEG Ok, i should think about more, but i am tired as code reviewer. next time
			for (int barrier = 0; barrier < result.length; barrier++) {
				if (indexOfSecondArray < secondArray.length && indexOfFirstArray < firstArray.length) {
					if (firstArray[indexOfFirstArray] > secondArray[indexOfSecondArray]) {
						result[barrier] = secondArray[indexOfSecondArray++];
					} else {
						result[barrier] = firstArray[indexOfFirstArray++];
					}
				} else if (indexOfSecondArray < secondArray.length) {
					result[barrier] = secondArray[indexOfSecondArray++];
				} else {
					result[barrier] = firstArray[indexOfFirstArray++];
				}
			}
			return result;
		}

	// OLEG nice
	// Printing into console user's inserted numbers
	private void printInsertedNumbers(int[] userNumbers) {
		System.out.println("User's inserted numbers: " + Arrays.toString(userNumbers));
	}

	// OLEG nice
	// Printing into console user's sorted numbers
	// OLEG Previous method was almost the same. Just different message. And 1 line method. I don't know.
	// OLEG these method names printInsertedNumbers() printSortedNumbers()
	// OLEG And these local variable names userNumbers, sortedNumbers
	private void printSortedNumbers(int[] sortedNumbers) {
		System.out.println("User's sorted numbers: " + Arrays.toString(sortedNumbers));
	}

}
