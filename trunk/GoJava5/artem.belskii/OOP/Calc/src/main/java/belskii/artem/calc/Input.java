package belskii.artem.calc;


import java.io.Console;
import java.util.Scanner;

public class Input {
	private String method= "console";
	Input(String method){
		this.setMethod(method);
	}
	Input(){}
	public void setMethod(String method){
		method=this.method;
	}
	public String getMethod(){
		return method;
	}
	
	public void write(String message){
		System.out.println(message);
	}

	public String read(){
		Scanner consoleIn = new Scanner(System.in);
		System.out.println("Put expression in format x +(or -) y:");
		String input = consoleIn.nextLine();
		return input.toUpperCase();
		
	}
}
