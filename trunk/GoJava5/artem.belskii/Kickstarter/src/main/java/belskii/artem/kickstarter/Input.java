package belskii.artem.kickstarter;

import java.util.Scanner;

public class Input {
	private Scanner in = new Scanner(System.in);
	public int read(){
		return in.nextInt();
	}
	
	public String nextLine(){
		String newLine=this.in.nextLine();
		System.out.println("return: "+newLine);
		return newLine;
	}
	

}
