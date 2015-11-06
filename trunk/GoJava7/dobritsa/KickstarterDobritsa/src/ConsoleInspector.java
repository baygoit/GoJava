import java.util.List;
import java.util.Scanner;

public class ConsoleInspector {
	private static Scanner sc = new Scanner(System.in);
	
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
	
	public static Integer waitCorrectChoice(List<Integer> list) {
		Integer number = getInt();
		for (Integer i : list) {
			if(i == number) {
				return number;
			}
		}		
		return waitCorrectChoice(list);
	}	
}
