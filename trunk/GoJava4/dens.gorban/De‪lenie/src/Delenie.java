import java.io.PrintStream;
import java.util.Scanner;


public class Delenie {

	private static final String EXIT = "q";
	
	
	public static void main(String[] args) {
		PrintStream out = System.out;
		Scanner in = new Scanner(System.in);
		
		out.println("To exit type '" + EXIT + "'");
		
		while(true){
			out.print("Please type formula in n1/n2 where n1 and n2 are numbers");
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
