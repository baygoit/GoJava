

import java.util.Scanner;

public class ConsoleInspector {

	public static int getInt() {
		int a;
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		sc.close();
		return a;
	}

	
}
