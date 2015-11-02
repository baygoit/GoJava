package go.it.dobritsa;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

public class LonelyNumber extends go.it.main.LonelyNumber{

	public static void main(String[] args) {
		List<Integer> myArray1 = Arrays.asList(2, 3, 2, 4, 3, 7, 2, 3, 4, 4);
		System.out.println("The lonely integer number in array " + myArray1.toString() + " = " +myFindLonely(myArray1));
		
		List<Integer> myArray2 = Arrays.asList(1, 3, 2, 4, 3, 2, 2, 3, 4, 4);
		System.out.println("The lonely integer number in array " + myArray2.toString() + " = " +myFindLonely(myArray2));
	
		List<Integer> myArray3 = Arrays.asList(3, 2, 4, 3, 2, 2, 3, 4, 4, 8);
		System.out.println("The lonely integer number in array " + myArray3.toString() + " = " +myFindLonely(myArray3));
	
		List<Integer> myArray4 = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4, 5, 5);
		System.out.println("The lonely integer number in array " + myArray4.toString() + " = " +myFindLonely(myArray4));
	
	}
	
	public static Integer myFindLonely(List<Integer> array) {
		Collections.sort(array);
		if (!array.get(0).equals(array.get(1))) {
			return array.get(0);
		}
		else {
			for (int i = 1; i <array.size()-1; i++) {
				if (!array.get(i).equals(array.get(i-1)) & !array.get(i).equals(array.get(i+1))) {
					return array.get(i);
				}
			}
			if (!array.get(array.size()-2).equals(array.get(array.size()-1))) {
				return array.get(array.size()-1);
			}
			System.out.println("The array " + array + " does not correspond to the task");
			
			System.exit(0);		
		}	
		return null;
	}

	@Override
	public Integer findLonely(List<Integer> array, int repeatCount) {
		
		return myFindLonely(array);
	}

}
