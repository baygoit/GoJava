package economicalEfficiency;

import java.util.Scanner;

public class Worker {
	double pay;
	double efficiency = 1;
	
	Worker(){
		Scanner sc = new Scanner(System.in);
		System.out.println("set worker's pay");
		pay = Double.valueOf(sc.nextLine());
	
	}

}
