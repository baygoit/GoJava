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
		 
		Map divPositionsMap =  new HashMap<Long, Integer>();
		List<String> resList= new LinkedList<String>();
				
		 String strInputLine; 
		 Scanner in = new Scanner(System.in);

		 do{
			 System.out.println("Enter expresion: (xxx../xxx..)");
			 strInputLine = in.nextLine();
			 strInputLine = strInputLine.trim();	 
		 }while(!strInputLine.matches(REG_EXP_CHECK));
		
		 in.close();
		 
		 String[] strArr = strInputLine.split("/");
		 
		 
		 long divident = Long.parseLong(strArr[0]);
		 long divisor  = Long.parseLong(strArr[1]);
		 long remainder = divident % divisor;
		 long quotient;
		 
		 
		 quotient =divident / divisor;
		 resList.add(divident + "|" + divisor );
		 resList.add(Long.toString(quotient * divisor) + "|");
		 resList.add("----");
		 
		 StringBuilder result = new StringBuilder();
		 result.append(Long.toString(quotient));
		 result.append(".");
		 

		 
		 int resultStartLength = result.length();
		 int iter = 0;
		 
		 
		 while(iter < ACCURACY || remainder == 0){
			 remainder = remainder * 10;
			 quotient = remainder / divisor;
			 resList.add(new String(new char[iter + 1]).replace('\0', ' ') + Long.toString(remainder));
			 remainder = remainder % divisor;
			 
			
			 resList.add(new String(new char[iter]).replace('\0', ' ') +  "-" + Long.toString(quotient * divisor));
			 resList.add(new String(new char[iter + 1]).replace('\0', ' ') +  "----");
			 
			 
			 if(!divPositionsMap.containsKey(remainder)){
				 divPositionsMap.put(remainder, iter);
			 }else {
//				 System.out.println("stop:" + divPositionsMap.get(remainder));
//				 System.out.println("step:" + iter);
				 
				 result.insert(resultStartLength +  ((Integer) (divPositionsMap.get(remainder))).intValue(), '(');
				 result.append(')');
				 break;
			 };
			 result.append(Long.toString(quotient ));
			 iter++;
		 }
		 
		resList.set(1, resList.get(1) + result);

		  
		for (Iterator iterator = resList.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println(":" + string);	
		} 
		 

		 System.out.println("res:" + result);
	}
}
