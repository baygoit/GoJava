public class RotatedArrays {

	//{4,5,6,7,8,9,10,11,1,2,3}
	final static int FIRST_INDEX = 0;

    public static int binarySearch(int[] array, int target) {
    	if (array.length == 0){
    		return -1;
    	}
    	int lastIndex = array.length -1;
    	int midle = FIRST_INDEX + (lastIndex-FIRST_INDEX)/2;
    	if (array[midle] == target){
    		return midle;
    	}
    	int leftSearchRes = search(array, target, FIRST_INDEX, midle -1);
    	int rightSearchRes = search(array, target, midle+1, lastIndex); 
    	
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
    	int midle = (firstIndex+lastIndex)/2;
    	if (target == array[midle]) {
    		return midle;
    	} else if (target == array[firstIndex]){
    		return firstIndex;
    	} else if (midle != 0 && target == array[midle-1]) {
    		return midle-1;
    	}else if (target < array[midle]){
    		return search(array, target, firstIndex, midle-1);
    	} else if (target > array[midle]){
    		return search(array, target, midle+1, lastIndex);
    	} else {
    		return -1; 
    	}
    }
   }
