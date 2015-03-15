package edu.sergii.tishenko.task6;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MergSort {

	public static void main(String[] args) {
		
		final List inParam = new LinkedList<Integer>(Arrays.asList(32,5,7,92,3,5,65,23,123,7,9));
		
		List res =  SortArray(inParam.subList(0, inParam.size() / 2),
				inParam.subList(inParam.size() / 2, inParam.size()));
		
		System.out.println("-----------------" );
		System.out.println("Result:" + res );


	}

	static List<Integer> SortArray(List<Integer> argList1, List<Integer> argList2) {
		
		System.out.println("step in: {" + argList1 + " , " + argList2 + "}" );
		
		List<Integer> resList1 = null;
		List<Integer> resList2 = null;
		List<Integer> resultList = new LinkedList<Integer>();

		if (argList1.size() > 1) {
			resList1 = SortArray(argList1.subList(0, argList1.size() / 2),
					             argList1.subList(argList1.size() / 2, argList1.size()));
		} else resList1 = argList1;

		
		if (argList2.size() > 1) {
			resList2 = SortArray(argList2.subList(0, argList2.size() / 2),
					argList2.subList(argList2.size() / 2, argList2.size()));
		} else resList2 = argList2;

		
		
		Iterator<Integer> iter1 = resList1.iterator();
		Iterator<Integer> iter2 = resList2.iterator();
		
		int val1 =0; 
		int val2 =0; 

		val1 = iter1.next();
		val2 = iter2.next();

		while(true){
			if (val1 < val2) {
				
				resultList.add(val1);

				if (iter1.hasNext()) {
					val1 = iter1.next();
				} else {
					while (iter2.hasNext()) {
						resultList.add(val2);
						val2 = iter2.next();
					}
					resultList.add(val2);
					break;
				}
			}
			else {
				resultList.add(val2);

				if (iter2.hasNext()) {
					val2 = iter2.next();
				} else {
					while (iter1.hasNext()) {
						resultList.add(val1);
						val1 = iter1.next();
					}
					resultList.add(val1);
					break;
				}
			}

		} ;
		
		System.out.println("step out: " + resultList+ "" );		

		return resultList;
	}

}
