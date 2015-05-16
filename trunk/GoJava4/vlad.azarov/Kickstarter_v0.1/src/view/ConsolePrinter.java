package view;

public class ConsolePrinter implements Printer {

    public void print(String s) {
	System.out.print(s);
    }

    public void println(String s) {
	print(s + "\n");
    }

}
