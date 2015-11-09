package ua.com.goit.gojava7.kickstarter.console;
import java.util.Scanner;

public class ConsoleInspector {
	private Scanner sc = new Scanner(System.in);	
	
	public Integer getCorrectInt(Integer limitation) {
		Integer a = null;
		try {		
			a =  sc.nextInt();
			} catch (Exception e) {
				System.out.println("Ohhh no.. It is not a number :(");
				System.exit(0);
			} 
	
		if(a > limitation) {
			System.out.println("Ohhh no.. It is a bad number :(");
			System.exit(0);
		}
		return a;
	}	
	
	public void close() {
		sc.close();
	}
}
