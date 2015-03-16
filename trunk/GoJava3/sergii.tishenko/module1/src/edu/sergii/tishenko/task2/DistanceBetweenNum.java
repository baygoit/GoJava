package edu.sergii.tishenko.task2;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.regex.Pattern;

public class DistanceBetweenNum {

	public static void main(String[] args) {

		final String REG_EXP_CHECK ="^([0-9])+([\\s]{1}([0-9])+)*$";
		 
		 String strInputLine; 
		 Scanner in = new Scanner(System.in);

		 do{
			 System.out.println("Enter numbers:");
			 strInputLine = in.nextLine();
			 strInputLine = strInputLine.trim();	 
		 }while(!strInputLine.matches(REG_EXP_CHECK));
		
		 in.close();
		 
//	    strInputLine = "1 5 23 45 34 12 45 4 38 56 2 49 100";
		
		String[] strArr = strInputLine.split(" ");
		if (strArr.length < 2)
			throw new IllegalArgumentException();

		showDistanceByMap(strArr);
		showDistanceWithoutMap(strArr);

	}
	
	
	// Distance between number using collections/generics
	//
	private static void showDistanceByMap(String[] strArr) {

		Map<Integer, Integer> inputMap = new HashMap<>();

		for (int i = 0; i < strArr.length; i++) {

			inputMap.put(i, Integer.parseInt(strArr[i]));
		}

		Map<Integer, Integer> sortedMap = sortByComparator(inputMap);

		sortedMap.putAll(inputMap);
		System.out.println(sortedMap);

		Iterator<Entry<Integer, Integer>> iter = sortedMap.entrySet()
				.iterator();
		Entry<Integer, Integer> entry0 = iter.next();
		Entry<Integer, Integer> entry1 = iter.next();

		System.out.println("Distance (by map) = "
				+ (entry1.getKey() - entry0.getKey()));

	}

	private static Map<Integer, Integer> sortByComparator(
			Map<Integer, Integer> unsortMap) {

		List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(
				unsortMap.entrySet());

		// Sort list with comparator, to compare the Map values
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
			public int compare(Map.Entry<Integer, Integer> o1,
					Map.Entry<Integer, Integer> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		// Convert sorted map back to a Map
		Map<Integer, Integer> sortedMap = new LinkedHashMap<Integer, Integer>();
		for (Iterator<Map.Entry<Integer, Integer>> it = list.iterator(); it
				.hasNext();) {
			Map.Entry<Integer, Integer> entry = it.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		return sortedMap;
	}

	
	
	// Distance between number without using collections 
	private static void showDistanceWithoutMap(String[] strArr) {
	
	//	position0, value0  - first minimum element
	//	position1, value1  - second minimum element 
	//  value0 <= value1		
		int position0, value0;
		int position1, value1;
		int iterValue;
		int[] intArray = pasrseIntArray(strArr);
		
		
		

		
		if (intArray[0] < intArray[1]){

			position0 = 0;
			value0 = intArray[0];

			position1 = 1;
			value1 = intArray[1];
		} else {
			position0 = 1;
			value0 = intArray[1];

			position1 = 0;
			value1 = intArray[0];
		}

		
		for (int i = 2; i < intArray.length; i++) {

			iterValue =intArray[i];

			if (iterValue < value1) {

				if (iterValue < value0) {

					position1 = position0;
					value1 = value0;

					position0 = i;
					value0 = iterValue;
				} else {
					position1 = i;
					value1 = iterValue;
				}

			}
		}
		
		System.out.println("Distance (without map) = "
				+ (position1 - position0 ));

	}

	private static int[] pasrseIntArray(String[] strArr) {
		
		int[] result = new int[strArr.length];

		for (int i = 0; i < strArr.length; i++) {
			result[i] = Integer.parseInt(strArr[i]);
		}
		
		return result;
	}
	
}
