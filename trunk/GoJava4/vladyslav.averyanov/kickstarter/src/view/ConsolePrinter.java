package view;

public class ConsolePrinter implements Printer {
	
	static void print (String s) {
		System.out.print(s);
	}
	
	static void println (String s) {
		print(s + "/n");
	}

}
