import java.util.Scanner;

public class ConsoleInspector {
	static Scanner sc = new Scanner(System.in);
	public static int getInt() {
		int a;		
		a = sc.nextInt();		
		return a;
	}		
	
	public static void close() {
		sc.close();
	}
}
