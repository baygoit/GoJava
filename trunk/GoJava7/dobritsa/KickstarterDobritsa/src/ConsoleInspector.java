import java.util.List;
import java.util.Scanner;

public class ConsoleInspector {
	private static Scanner sc = new Scanner(System.in);
	
	public static Integer getInt() {
		//int a;		
		//a = sc.nextInt();				
		try {		
		return sc.nextInt();
		}  catch (Exception e) {
			//Error ref = new Error(); 
			//System.out.println("What does it mean? This is not good");
	        throw new Error();
        }		
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
