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

    int firstIndex = 0;
    int lastIndex = array.length -1;
    if (firstIndex > lastIndex)
    {
      return -1;
    }
    int middle = firstIndex + (lastIndex - firstIndex) / 2;
    while (true){
      if (firstIndex == lastIndex && array[firstIndex] != target){
        return -1;
      } else if (middle == 0 && array[firstIndex] != target 
          && array[lastIndex] != target){
        return -1;
      } else if (target == array[firstIndex]){
        return firstIndex;
      } else if (target == array[lastIndex]){
        return lastIndex;
      } else if (target == array[middle]){
        return middle;
      } else if (target <= array[middle - 1] && target > array[firstIndex]){
        lastIndex = middle -1;
      } else if (array[firstIndex]> array[middle-1] && target < array[middle]){
        lastIndex = middle -1;
      } else {
        firstIndex = middle + 1;
      }
      middle = firstIndex + (lastIndex - firstIndex) / 2;
    }
  }
}
