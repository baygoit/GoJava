package edu.sergii.tishenko.task4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Divide {

	public static void main(String[] args) {

		final String REG_EXP_CHECK ="^([0-9])+[\\/]{1}([0-9])+$";
		final long ACCURACY = 120;
		 
		Map<Long, Integer> divPositionsMap =  new HashMap<Long, Integer>();
		List<String> outputStingList= new LinkedList<String>();
				
		 String strInputLine; 
		 Scanner in = new Scanner(System.in);
		 
		 // Reading console
		 do{
			 System.out.println("Enter expresion: (xxx../xxx..)");
			 strInputLine = in.nextLine();
			 strInputLine = strInputLine.trim();	 
		 }while(!strInputLine.matches(REG_EXP_CHECK));
		
		 in.close();
		 
		 String[] strArr = strInputLine.split("/");
		 
		// Dividing
		 long divident = Long.parseLong(strArr[0]);
		 long divisor  = Long.parseLong(strArr[1]);
		 long remainder = divident % divisor;
		 long quotient;
		 
		 
		 quotient =divident / divisor;
		 outputStingList.add(divident + "|" + divisor );
		 outputStingList.add(Long.toString(quotient * divisor) + "|");
		 outputStingList.add("----");
		 
		 StringBuilder result = new StringBuilder();
		 result.append(Long.toString(quotient));
		 result.append(".");
		 

		 
		 int resultStartLength = result.length();
		 int iter = 0;
		 
		 
		 while(iter < ACCURACY || remainder == 0){
			 remainder = remainder * 10;
			 quotient = remainder / divisor;
			 outputStingList.add(new String(new char[iter + 1]).replace('\0', ' ') + Long.toString(remainder));
			 remainder = remainder % divisor;
			 
			
			 outputStingList.add(new String(new char[iter]).replace('\0', ' ') +  "-" + Long.toString(quotient * divisor));
			 outputStingList.add(new String(new char[iter + 1]).replace('\0', ' ') +  "----");
			 
			 
			 if(!divPositionsMap.containsKey(remainder)){
				 divPositionsMap.put(remainder, iter);
			 }else {

				 result.insert(resultStartLength +  (divPositionsMap.get(remainder)) , '(');
				 result.append(')');
				 break;
			 };
			 result.append(Long.toString(quotient ));
			 iter++;
		 }
		 
		 // Add result string to 2nd row.  
		outputStingList.set(1, outputStingList.get(1) + result);

		  
		for (Iterator iterator = outputStingList.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(":" + string);	
		} 
		 

		 System.out.println("res:" + result);
	}
}
