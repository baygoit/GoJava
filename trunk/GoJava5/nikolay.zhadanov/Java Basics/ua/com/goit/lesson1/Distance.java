package ua.com.goit.lesson1;

/*
 * Lesson 1 - Task 2
 * Твоя задача создать консольное приложение, которое принимало бы на вход ряд чисел
 * и выводило расстояние между двумя наименьшими.
 * Например, дано ряд чисел: "23 45 34 12 45 4 38 56 2 49 100".
 * Наименьшие числа в нем 2 и 4. Расстояние между ними - 3. 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Distance {

	public static void main(String[] args)
	{
	    System.out.println("Distance is " + getDistance());
	}
	
	private static int[] getNumbers() throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String[] stringNums = reader.readLine().split(" ");
		
		int[] nums = new int[stringNums.length];
		
		for (int index = 0; index < stringNums.length; index++)
			nums[index] = Integer.parseInt(stringNums[index]);
		
		return nums;
	}
	
	private static int getDistance()
	{
		int[] numbers;
		
		try
		{
			numbers = getNumbers();
		}
		catch (Exception e)
		{
			System.out.println("Произошло исключение: " + e.getClass().getSimpleName());
			return 0;
		}
		
		int min1 = Integer.MAX_VALUE;
		int min2 = Integer.MAX_VALUE;
		int min1Index = 0;
		int min2Index = 0;
		
		for (int index = 0; index < numbers.length; index++)
		{
			if (min1 > numbers[index])
			{
				if (min2 > min1)
				{
					min2 = min1;
					min2Index = min1Index;
				}
				min1 = numbers[index];
				min1Index = index;
			}
			
			if (min2 > numbers[index] && min1Index != index)
			{
				min2 = numbers[index];
				min2Index = index;
			}
		}
				
		return Math.abs(min1Index - min2Index);
	}
}
