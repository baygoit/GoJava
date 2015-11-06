import java.util.Scanner;

public class ConsoleInspector {
	static Scanner sc = new Scanner(System.in);
	
	public static int getInt() {
		// OLEG why 2 lines? int a = sc.nextInt();? or even return sc.nextInt();
		int a;		
		// OLEG what will it be if an user type not int?
		a = sc.nextInt();		
		return a;
	}		
	
	public static void close() {
		sc.close();
	}
}
