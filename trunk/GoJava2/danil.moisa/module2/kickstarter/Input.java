package kickstarter;

import java.util.Scanner;

public class Input {
	private Scanner scan;

	public void choiceCategory(){
		while (true){
		scan = new Scanner(System.in);
		int i = scan.nextInt();
		if (i == 1){
			System.out.println("••• Вы выбрали Спорт!");
		} else{
			if (i == 2){
				System.out.println("••• Вы выбрали Музыку!");
			} else{
				if (i == 3){
					System.out.println("••• Вы выбрали Технику!");
				} else {
					System.out.println("Такой категории не существует! Выберите, пожалуйста, другую из выше перечисленных!");
				}
			}
		}
	}
	}
}
