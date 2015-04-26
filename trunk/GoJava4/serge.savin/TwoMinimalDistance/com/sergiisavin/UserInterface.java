/*
 * Класс отвечает за пользовательский интерфейс.
 * Приглашение ввода данных
 * контроль входных данных
 * вывод подсказок и результата
 *  
 * 
 * 
 */

package com.sergiisavin;

import java.util.Arrays;
import java.util.IllegalFormatException;
import java.util.Scanner;

public class UserInterface {

	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
		String inputData = null;
		double[] numbers = null;
		
		do{
			
			System.out.print("Введите ряд чисел через один пробел (или exit для выхода из программы): ");
			inputData = scanner.nextLine();
			  
			
			//приводим к одному регистру и обрубаем пробелы с концов
			inputData = inputData.trim();
			inputData = inputData.toLowerCase();
			
			//сли пользователь ввёл exit - выход из программы
			if(inputData.equals("exit")){
				System.out.println("Пока!");
				System.exit(0);
			}
			
			//получаем массив елементов из введённой строки
			String[] elements = inputData.split(" ");
			
			//пытаемся преобразовать массив елементов в массив duble
			try{
				numbers = getNumbers(elements);
			}catch(NumberFormatException ex){
				System.out.println("Некорректные входные данные...");
				System.out.println("Введите целые или дробные числа через пробел (Например: 3 5 11.7 2e4 7): ");
				continue;
			}
			
			//Вычисление и вывод результата
			System.out.println("Расстояние между двумя минимальными елементами: " + DistanceFinder.findDistance(numbers));
			
		//пока пользователь не введёт exit	
		}while(true);
	}

	//преобразуем массив строк в массив double
	//в случае невозможности преобразования кидаем NumberFormatException
	//возвращаем массив double
	private static double[] getNumbers(String[] elements) {
		double[] numbers = new double[elements.length];
		for(int i = 0; i < elements.length; i++){
			numbers[i] = Double.parseDouble(elements[i]);
		}
		return numbers;
	}

}