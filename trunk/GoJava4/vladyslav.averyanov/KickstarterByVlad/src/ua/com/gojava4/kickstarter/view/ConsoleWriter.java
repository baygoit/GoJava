package ua.com.gojava4.kickstarter.view;

public class ConsoleWriter implements Writer {
	
	public void print (){
		print ("");
	}
	
	public void println(){
		println("");
	}
	
	public void print (String string) {
		System.out.print(string);
	}
	
	public void println(String string) {
		print(string + "\n");
	}

}
