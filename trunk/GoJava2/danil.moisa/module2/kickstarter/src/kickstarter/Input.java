package kickstarter;

import java.util.Scanner;

public class Input {
	private Scanner scan;

	public int read() {
		scan = new Scanner(System.in);
		return scan.nextInt();

	}

}
