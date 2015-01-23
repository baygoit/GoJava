package myRealization;
import java.util.Scanner;

public class ConsoleScanner {
	private Scanner scan;
	
	public int readChoice(){
		scan = new Scanner(System.in);
		return scan.nextInt();
	}
	
}
