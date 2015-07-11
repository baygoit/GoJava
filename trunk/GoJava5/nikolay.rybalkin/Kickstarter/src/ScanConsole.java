import java.util.Scanner;


public class ScanConsole {

	public static int consoleScan(int number){

		Scanner scaner = new Scanner(System.in);

		try {
			scaner.hasNextInt();
			number = scaner.nextInt();
		} catch (Exception e) {
			System.out.println("You entered is not a number!");
		}
		return number;
	}
}
