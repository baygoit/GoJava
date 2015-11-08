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
	
	public static Integer getCorrectInt(Integer limitation) {
		Integer a = null;
		try {		
			a =  sc.nextInt();
			} catch (Exception e) {
				System.out.println("Ohhh no.. It is not a number :(");
				System.exit(0);
			} 
	
		if(a >= limitation) {
			System.out.println("Ohhh no.. It is a bad number :(");
			System.exit(0);
		}
		return a;
	}	
}
