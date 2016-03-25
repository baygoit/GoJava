package usermanager;

import java.util.Scanner;

public class ConsoleManager implements InputOutput {

	public void write(String information) {
		System.out.println(information);
	}

	public String read() {

		Scanner sc = new Scanner(System.in);
		String information = sc.nextLine();

		return information;

	}
}
