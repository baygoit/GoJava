import java.util.Scanner;

public class Anagrams {

	public static String changeString(String input) {
		String[] arrStr = input.split(" ");

		StringBuilder newString = new StringBuilder("");
		
		for (int i = 0; i < arrStr.length; i++) {
			StringBuilder str = new StringBuilder(arrStr[i]);
			newString.append(str.reverse());
			if (i < arrStr.length-1) 
				newString.append(" ");
		}

		return newString.toString();
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println("Insert your string of words separated by space:");
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		scan.close();
		String changedString = changeString(input);
		
		System.out.println(changedString);


	}

}
