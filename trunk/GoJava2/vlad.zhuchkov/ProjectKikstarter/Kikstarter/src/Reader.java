import java.util.Scanner;

public class Reader implements Input {
	Printer printer;

	public Reader(Printer pr){
	this.printer = 	pr;
	}
	private Scanner sc = new Scanner(System.in);
	@Override
	public int readInt() {
		int input = 0;
		try {
			input = Integer.valueOf(sc.nextLine());
		} catch (NumberFormatException e) {
			printer.print("invalid input. Only integer");
			input = readInt();
		}
		
		return input;
	}
	
	
}
