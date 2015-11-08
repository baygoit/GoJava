package goit.nz.kickstartermvc.output;

public class ConsoleOutput implements Output {
	
	public void write(String str) {
		System.out.println(str);
	}
}
