package accountant;

import java.util.Scanner;

public class Menu {
	public void ask(){
		System.out.println("¬ыберите операцию:\n 1- расход \n 2- доход \n 3- и того ");
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		switch (a){
			case (1):
				RecordList.addList();
			break;
			case (2):
				
			break;
		}
	}
}
