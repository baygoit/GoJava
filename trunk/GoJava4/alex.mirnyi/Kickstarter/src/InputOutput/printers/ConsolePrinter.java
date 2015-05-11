package InputOutput.printers;



public class ConsolePrinter implements Printer {
	
	@Override
	public void print(String string) {
		System.out.print(string);
	}
	
	@Override
	public void println(String string){
		System.out.print(string + "\n");
	}
	
}
