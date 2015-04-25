import java.io.*;
import java.util.*;


public class TwoMinDistanceClass {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new ArrayList<Integer>();
		int aval,apos,bval,bpos;
		String temp;
		
		System.out.println("Enter integers pressing Enter after each. When finish press Enter after blank field");
		
		while(true) {
			temp = reader.readLine();
			if (temp.equals("")) break;
			list.add(Integer.parseInt(temp));
		}
		
		aval=list.get(0);
		bval=list.get(1);
		apos=0;
		bpos=1;
		
		for (int i=1; i<list.size(); i++) {
			if (list.get(i)<aval) {
				bval = aval;
				bpos = apos;
				aval = list.get(i);
				apos = i;
			} else if (list.get(i)>=aval && list.get(i)<bval) {
				bval = list.get(i);
				bpos = i;
			}
		}
		
		System.out.println("Distance is: "+Math.abs(apos-bpos));

	}

}
