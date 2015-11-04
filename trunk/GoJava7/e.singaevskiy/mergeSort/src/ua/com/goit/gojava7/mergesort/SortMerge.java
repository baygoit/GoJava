package ua.com.goit.gojava7.mergesort;

public class SortMerge {

	public static void sort(int[] originalArray) {
		int[] sortingHelpArray = new int[originalArray.length];
		split(originalArray, sortingHelpArray, 0, originalArray.length - 1);
	}

	private static void split(int[] originalArray, int[] sortingHelpArray, int firstIndex, int lastIndex) {

		if (lastIndex > firstIndex) {
			int midIndex = (lastIndex + firstIndex) / 2;

			split(originalArray, sortingHelpArray, firstIndex, midIndex);
			split(originalArray, sortingHelpArray, midIndex + 1, lastIndex);
			copyArrayContents(originalArray, sortingHelpArray, firstIndex, lastIndex);
			sortAndMerge(originalArray, sortingHelpArray, firstIndex, midIndex, lastIndex);
			
		}
		
	}
	
	private static void copyArrayContents(int[] originalArray, int[] sortingHelpArray, int firstIndex, int lastIndex){
        for (int i = firstIndex; i <= lastIndex; i++){
            sortingHelpArray[i] = originalArray[i];
        }
	}

	private static void sortAndMerge(int[] originalArray, int[] sortingHelpArray, int firstIndex, int midIndex, int lastIndex){
		 
        int leftArrayIndex = firstIndex;
        int rightArrayIndex = midIndex + 1;
        int originalArrayindex = firstIndex;
        
        while (leftArrayIndex <= midIndex && rightArrayIndex <= lastIndex){
            if (sortingHelpArray[leftArrayIndex] <= sortingHelpArray[rightArrayIndex]){
                originalArray[originalArrayindex++] = sortingHelpArray[leftArrayIndex++];
            }
            else{
                originalArray[originalArrayindex++] = sortingHelpArray[rightArrayIndex++];
            }
        }
               
        while (leftArrayIndex <= midIndex){
            originalArray[originalArrayindex++] = sortingHelpArray[leftArrayIndex++];
        }
    }
	
}
