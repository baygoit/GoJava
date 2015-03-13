import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class GoITFirst {

	public static int one(String[] args){
		ArrayList<Integer> array = new ArrayList<Integer>();
		ArrayList<Integer> sorted;
		for (int i = 0; i < args.length; i++)
			array.add(i, Integer.parseInt(args[i]));
			
		sorted = new ArrayList<Integer>(array);
		Collections.sort(sorted);
			int min1 = sorted.get(0);
			int min2 = sorted.get(1);
		//Возвращаем разницу
		if (array.indexOf(min2)> array.indexOf(min1)){

		return array.indexOf(min2) - array.indexOf(min1);
		}
		else { 
			return array.indexOf(min1) - array.indexOf(min2);
			}
	}
	
	public static void main(String[] args) {
		/*Протестировано со следующими вводными данными
		 * 7 8 0 78 4 5 3 6 5 2
		 * 8 23  90 8 20 0 3 4 5 2
		 * 8 23 1 90 20 67 0 3 4 5 2
		 * */
		System.out.println(one(args));
	}
}
