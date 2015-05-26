package ua.com.goit.gojava.kickstarter.view;

public class ConsolePrinter implements Printer {

    public void print(String s) {
	System.out.print(s);
    }

    public void println(String s) {
	print(s + "\n");
    }
    
    public void printError(String s) {
	System.err.println(s);
    }

}
