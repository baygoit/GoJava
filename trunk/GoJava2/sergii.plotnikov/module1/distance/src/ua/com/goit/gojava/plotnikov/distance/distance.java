package ua.com.goit.gojava.plotnikov.distance;
import java.io.*;

public class distance {

	public static void main(String[] args) throws IOException {
		
		int[] array = readArrayNumbers();
				
		int min1 = array[0];
		int min2 = array[1];
		int min1index=0;
		int min2index=1;
		
		if(min1>min2){
			int temp = min1;
			min1=min2;
			min2=temp;
			
			min1index=1;
			min2index=0;
		}
		
		for(int i = 0; i < array.length; i++){
			
			if(min1>array[i]){
				min2=min1;
				min2index=min1index;
				
				min1=array[i];
				min1index=i;
			}
			else if(min2>array[i]&&array[i]!=min1){
				min2=array[i];
				min2index=i;
			}
		}
		
		int distance = Math.abs(min1index-min2index);
		
		System.out.println("Наименьшие числа: " + min1 + " и " + min2 + ". Расстояние между ними - " + distance);
	}

	private static int[] readArrayNumbers() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
		int size;
	
		System.out.print("Сколько чисел будем вводить?");
		String s = reader.readLine();
		size = Integer.parseInt(s);
	
		int array[] = new int[size];
	
		for(int i = 0; i<size; i++){
			System.out.print("Введите " + (i+1) + "-е число: ");
			s = reader.readLine();
			array[i] = Integer.parseInt(s);
		}
		
		return array;
	}
}
