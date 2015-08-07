package belskii.artem.kickstarter;

import java.util.Scanner;

public class Input {
	public int read(){
		Scanner in = new Scanner(System.in);
		return in.nextInt();
	}
	
	public String nextLine(){
		Scanner in = new Scanner(System.in);
		String answer=in.nextLine();
		return answer;
	}

	public Long nextLong() {
		Scanner in = new Scanner(System.in);
		return in.nextLong();
	}
}
