package rent;

import java.util.Scanner;

public class Item {
	private String title;
	private int price;
	private String description;
	private boolean isBusy;
	private Scanner scan;

	public Item(String title, int price, String description, boolean isBusy) {
		this.title = title;
		this.price = price;
		this.description = description;
		this.isBusy = isBusy;

	}

	public static String getTitle(Item i) {
		return i.title;
	}

	public static int getPrice(Item i) {
		return i.price;
	}

	public static String getDescription(Item i) {
		return i.description;
	}

	public void addItem() {
		scan = new Scanner(System.in);
		System.out.println("Что бы Вы хотели сдать в прокат?");
		title = scan.nextLine();
		System.out.println("Опишите Ваш товар:");
		title = scan.nextLine();
		System.out.println("Сколько будет стоит прокат на сутки, грн?");
		String sPrice = scan.nextLine();
		price = Integer.parseInt(sPrice);

	}

}
