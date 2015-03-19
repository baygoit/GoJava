package ua.goit.alg;

/*You have a sorted array of N length which was rotated, e.g. [4, 5, 6, 7, 8, 9, 10, 1, 2, 3].
*Rotated means that we move first M numbers to the end.
*You need to find index of target number using binary search.
*In case there is no such number in array, return -1;
*All numbers in array are unique.
*Use TDD approach.
*
*0<=N
*0<=M<=N
*/

public class RotatedArrays {
	
	//The primary method
  public static int binarySearch(int[] array, int target){
    	
    return dividionAndSearch(target, array, 0, array.length-1);
  }
  
  private static int dividionAndSearch(int target, int[] array, int firstIndex, 
  int lastIndex){
    if (firstIndex > lastIndex){
      return -1;
     }
     int middle = firstIndex + (lastIndex - firstIndex) / 2;
         
     if (firstIndex == lastIndex && array[firstIndex] != target){
       return -1;
     } else if (target == array[firstIndex]){
       return firstIndex;
     } else if (target == array[lastIndex]){
       return lastIndex;
     } else if (target == array[middle]){
       return middle;
     } else if (target <= array[middle - 1] && target > array[firstIndex]){
       return dividionAndSearch(target, array, firstIndex, middle - 1);
     } else if (array[firstIndex]> array[middle-1] && target < array[middle]){
       return dividionAndSearch(target, array, firstIndex, middle - 1);
     } else {
       return dividionAndSearch(target, array, middle + 1, lastIndex);
    }
   }
  }
