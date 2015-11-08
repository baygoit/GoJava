package com.sin.eugene;

public class Distance {
	
	private Distance() {
		
	}
	
	public static void printDistance(int[] numbers, int numberOfMinPositions) {
		
		int[] sortedIndexes = getSortedIndexes(numbers);
	    printSortedArray(numbers, sortedIndexes);
	    printIndexesAndDistance(numbers, sortedIndexes, numberOfMinPositions);
		
	}

	private static void printIndexesAndDistance(int[] numbers, int[] sortedIndexes, int numberOfMinPositions) {
		StringBuilder messageIndexes = new StringBuilder("Indexes of minimal numbers: ");
	    StringBuilder messageDistance = new StringBuilder("Distance between minimal indexes: ");
	    
	    for (int i = 0; i < numbers.length; i++) {		
			if (i <= numberOfMinPositions-1 
					|| numbers[sortedIndexes[i-1]] == numbers[sortedIndexes[i]]) {
				messageIndexes.append(i > 0 ? ", " : "");
				messageIndexes.append(sortedIndexes[i]);
				
				if (i > 0) {
					messageDistance.append(i > 1 ? ", " : "");
					if (sortedIndexes[0] > sortedIndexes[i]) {
						messageDistance.append(sortedIndexes[0] - sortedIndexes[i]);
					} else {
						messageDistance.append(sortedIndexes[i] - sortedIndexes[0]);
					}
				}
				
			} else {
				break;
			}
		}
	    System.out.println(messageIndexes);
	    System.out.println(messageDistance);
	}
	
	private static int[] getSortedIndexes(int[] numbers){
		int[] sortedIndexes = new int[numbers.length];
		for (int i = 0; i < sortedIndexes.length; i++) {
			sortedIndexes[i] = i;
		}
		
	    for(int i = 0 ; i < numbers.length ; i++){

    		int firstIndex = sortedIndexes[i];    	
	    	
	    	for(int j = i+1 ; j < numbers.length ; j++){	            

	            int currentIndex = sortedIndexes[j];
	            
				if( numbers[firstIndex] > numbers[currentIndex] ){
	                int tmpIndex = firstIndex;
	                sortedIndexes[i] = currentIndex;
	                sortedIndexes[j] = tmpIndex;
	                firstIndex = currentIndex;
	            }
	        }
	    }
	    
		return sortedIndexes;
	}

	private static void printSortedArray(int[] numbers, int[] sortedIndexes) {
		System.out.print("Sorted array: [");
	    for (int i = 0; i < sortedIndexes.length; i++) {
	    	System.out.print(i > 0 ? ", " : "");
	    	System.out.print(numbers[sortedIndexes[i]]);
		}
	    System.out.println("]");
	}
	
}
