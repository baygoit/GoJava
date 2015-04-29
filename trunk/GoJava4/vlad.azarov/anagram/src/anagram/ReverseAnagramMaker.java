package anagram;

import java.io.IOException;
import java.util.Scanner;

/*На вход консольного приложения передается строка слов,
 * разделенных пробелами. Твоя задача сделать из слов анаграммы
 * ("задом наперед") при этом оставив порядок слов неизменными.
 * Результат вывести в консоль.
 * Пример "мама мыла раму" => "амам алым умар"*/

public class ReverseAnagramMaker {

	private static String inputText;
	
	public static void main(String[] args) throws IOException {
		
		ReverseAnagramMaker text = new ReverseAnagramMaker();
		
		text.setInputTextFromConsole();
		ReverseAnagramMaker.toReverseText(getInputText());
		
		String result = toReverseText(inputText);
		System.out.println(result);
	}
	
	
	public static String getInputText() {
		return inputText;
	}
	
	public void setInputTextFromConsole() {
		System.out.println("Enter some text: ");
		Scanner scan = new Scanner(System.in);
		scan.close();
		inputText = scan.nextLine();
	}
	
	public static String toReverseText(String text) {
		StringBuilder newString = new StringBuilder();
		StringBuilder tempString = new StringBuilder();
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == ' ') {
				newString.append(tempString.reverse()).append(" ");
				tempString.delete(0, tempString.length());
			} else {
				tempString.append(text.charAt(i));
			}
		}
		newString.append(tempString.reverse());
		return newString.toString();
	}
}
