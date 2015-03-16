package edu.sergii.tishenko.task5;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class LonelyNumber {

	public static void main(String[] args) {
		// final String REG_EXP_CHECK ="^([0-9])+([,]{1}([0-9])+)*$";
		//
		//
		// Scanner in = new Scanner(System.in);
		//
		// do{
		// System.out.println("Enter numbers:");
		// strInputLine = in.nextLine();
		// strInputLine = strInputLine.trim();
		// }while(!strInputLine.matches(REG_EXP_CHECK));
		//
		// in.close();

//		String strInputLine = "2,3,4,3,7,2,3,4,4,2";
//		String strInputLine = "2, 3, 3, 5, 12, 2, 3, 2, 5, 5";
		String strInputLine = "1,1,3,5,3,3,13,4,4,4,1,5,5";
		
		
		String[] strArr = strInputLine.split(",");

		int[] intArr = new int[strArr.length];
		 
		for (int i = 0; i < strArr.length; i++) {
			intArr[i] = Integer.parseInt(strArr[i]);
		}
	       
		
		
	    int[] bitSum = new int[32];
	    for(int i = 0; i < 32; ++i) {
	        bitSum[i] = 0;
	    }
	       
	    
	    for(int i = 0; i < intArr.length; i++) {
	        
	    	int bitMask = 1;
	        for(int j = 31; j >= 0; j--) {
	        	
	            int bit = intArr[i] & bitMask;
	            if(bit != 0) {
	                bitSum[j] += 1;
	            }
	            bitMask = bitMask << 1;
	        }
	    }
	       
	    int result = 0;
	    for(int i = 0; i < 32; i++) {
	        result = result << 1;
	        result += bitSum[i] % 3;
	    }
	      
		System.out.println("result1:" + result);
	}
}
