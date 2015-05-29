package kickstarter.printer;

public class ConsolePrinter implements Printer {

    public void print(String s) {
	System.out.print(s);
    }

    public void println(String s) {
	System.out.println(s);
    }
    
    public void printError(String s) {
	System.err.println(s);
    }

    public void print(int num) {
	System.out.print(num);
    }
    
    public void println(int num) {
	System.out.println(num);
    }


}
