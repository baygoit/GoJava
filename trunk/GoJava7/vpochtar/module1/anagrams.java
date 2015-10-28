/*
 * На вход консольного приложения передается строка слов, разделенных пробелами. Твоя задача сделать из слов анаграммы ("задом наперед") при этом оставив порядок слов неизменными. Результат вывести в консоль.

Пример "мама мыла раму" => "амам алым умар"
 */

import java.io.IOException;
import java.util.Scanner;

public class anagrams {
	public static void main(String[] args) throws IOException{
		System.out.println("Please enter your words");
		String line = readLine();
		System.out.println(getLineWithAnagrams(line));
	}
	
	public static String readLine(){
		Scanner input = new Scanner(System.in);
		String line = input.nextLine();
		input.close();
		return line;
	}
	
	public static String makeAnagram(String word){
		//System.out.println(word);
		char[] array = word.toCharArray();
		for (int i = 0; i < array.length / 2; i++){
			//System.out.println(i);
			char tmp = array[i];
			array[i] = array[array.length - 1 - i];
			array[array.length - 1 - i] = tmp;
		}
		String result = new String(array);
		//System.out.println(result);
		return result;
	}
	
	public static String getLineWithAnagrams(String line){
		String lineWithAnagrams = "";
		char[] array = line.toCharArray();
		for (int position = 0; position < array.length; position++){
			String tmp = "";
			if ((array[position] >= 'a' && array[position] <= 'z') || (array[position] >= 'A' && array[position] <= 'Z')){
				while ((array[position] >= 'a' && array[position] <= 'z') || (array[position] >= 'A' && array[position] <= 'Z') && position < array.length - 1){
					tmp += array[position];
					position++;
				}
				lineWithAnagrams += makeAnagram(tmp);
			}
			lineWithAnagrams += array[position];
		}
		return lineWithAnagrams;
	}
}
