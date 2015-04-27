import java.io.PrintStream;
import java.util.Scanner;


public class Delenie {

	private static final String EXIT = "q";
	
	
	public static void main(String[] args) {
		PrintStream out = System.out;
		Scanner in = new Scanner(System.in);
		
		out.println("для завершеня программы введите '" + EXIT + "'");
		
		while(true){
			out.print("Введите для деления 2 целых числа в формате 12/33:");
			String phrase = in.nextLine();
			
			if (phrase.equalsIgnoreCase(EXIT))
				System.exit(0);			
			
			String[] tokens = phrase.split("/");
			
			int n1 = 12;
			int n2 = 42;
			
			out.println(" "+n1 +" | " + n2);
			
		}
	}
}
