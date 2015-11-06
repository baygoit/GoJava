import java.util.List;
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
