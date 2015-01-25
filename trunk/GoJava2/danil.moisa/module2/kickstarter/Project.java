package kickstarter;

import java.util.Scanner;

public class Project {

	private String title;
	private int money;
	private int collectedMoney;
	private String description;
	private int daysOff;
	private Scanner scan;

	public Project(String title, int price, String description, int collectedMoney, int daysOff) {
		this.title = title;
		this.money = price;
		this.description = description;
		this.collectedMoney = collectedMoney;
		this.daysOff = daysOff;

	}

	public static String getTitle(Project i) {
		return i.title;
	}

	public static int getMoney(Project i) {
		return i.money;
	}

	public static String getDescription(Project i) {
		return i.description;
	}
	
	public static int getCollectedMoney(Project i) {
		return i.collectedMoney;
	}
	
	public static int getDaysOff(Project i) {
		return i.daysOff;
	}
	
	public void addProject() {
		scan = new Scanner(System.in);
		System.out.println("Введите название Вашего проекта:");
		title = scan.nextLine();
		System.out.println("Чем будите удивлять? Опишите Ваш проект:");
		description = scan.nextLine();
		System.out.println("Сколько Вам нужно денег, что бы реализовать задуманое?");
		String sMoney = scan.nextLine();
		money = Integer.parseInt(sMoney);

	}
	public String toString(){
		return(title + "\n" 
				+description + "\n" 
				+ money+ "\n" 
				+ collectedMoney+ "\n" 
				+ daysOff);
	}	
}
