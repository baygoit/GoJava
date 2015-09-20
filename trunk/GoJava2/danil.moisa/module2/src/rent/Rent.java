package rent;

import java.util.Scanner;

//UserStory
// Я - юзер - хочу добавлять товар, что бы сдать в прокат:
//предложить добавить товар - создать позицию название\цена\залог - добавить в каталог
class Rent {
	private static Catalog catalog = new Catalog();
	private static Scanner scan;
//TO DO зациклить...
	public static void main(String[] args) {
		System.out.println("Welcome!!!\n"
				+ "If you rent something stuff, please press 1\n"
				+ "If search some stuff take for rent, please press 2");
		scan = new Scanner(System.in);
		int choice = scan.nextInt();
		switch (choice) {
		case (1):
			Item item = new Item(null, choice, null, false);
			item.addItem();
			break;
		case (2):
			ListItems.listItems();
			break;

		}
	}
}
