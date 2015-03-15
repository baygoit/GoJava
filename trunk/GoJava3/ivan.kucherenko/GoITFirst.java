import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class GoITFirst {

	public static int one(String[] args){
		ArrayList<Integer> array = new ArrayList<Integer>();
		ArrayList<Integer> sorted;
		for (String i : args)
			array.add(Integer.parseInt(i));
			
		sorted = new ArrayList<Integer>(array);
		Collections.sort(sorted);
			int index1 = array.indexOf(sorted.get(0));
			int index2 = 0;
			
			for (int i = 0; i < array.size(); i++){
				if (array.get(i) == sorted.get(1) && i != index1){
					index2 = i;
					break;
				}
			}
		//Возвращаем разницу
		return Math.abs(index1 - index2);
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
