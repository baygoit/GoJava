public class RotatedArrays {

	final static int FIRST_INDEX = 0;

    public static int binarySearch(int[] array, int target) {
    	if (array.length == 0){
    		return -1;
    	}
    	int lastIndex = array.length -1;
    	int middle = FIRST_INDEX + (lastIndex-FIRST_INDEX)/2;
    	if (array[middle] == target){
    		return middle;
    	}
    	int leftSearchRes = search(array, target, FIRST_INDEX, middle -1);
    	int rightSearchRes = search(array, target, middle+1, lastIndex); 
    	
    	if (leftSearchRes != -1 && target == array[leftSearchRes]){
    		return leftSearchRes;
    	} else if (rightSearchRes != -1 && target == array[rightSearchRes]) {
    		return rightSearchRes;
    	}
    	return -1;
  }
    public static int search(int[]array, int target, int firstIndex, int lastIndex){
    	
    	if (firstIndex > lastIndex){
    		return -1;
    	}
    	int middle = (firstIndex+lastIndex)/2;
    	if (target == array[middle]) {
    		return middle;
    	} else if (target == array[firstIndex]){
    		return firstIndex;
    	} else if (middle != 0 && target == array[middle-1]) {
    		return middle-1;
    	}else if (target < array[middle]){
    		return search(array, target, firstIndex, middle-1);
    	} else if (target > array[middle]){
    		return search(array, target, middle+1, lastIndex);
    	} else {
    		return -1; 
    	}
    }
   }
