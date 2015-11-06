import java.util.Scanner;

public class ConsoleInspector {
	static Scanner sc = new Scanner(System.in);
	public static int getInt() {
		int a;
		//Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		//sc.close();
		return a;
	}	
	
	
	public static void close() {
		sc.close();
	}
}
