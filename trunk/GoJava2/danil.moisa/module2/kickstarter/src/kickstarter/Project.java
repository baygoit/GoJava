package kickstarter;

//import java.util.Scanner;

public class Project {
	private Faq faq = new Faq();
	private int idNumber;
	private String title;
	private int money;
	private int collectedMoney;
	private String description;
	private int daysOff;
	private String urlVideo;
	private String history;
	//private Scanner scan;

	public Project(int idNumber, String title, int price, String description,
			int collectedMoney, int daysOff, String urlVideo, String history, Faq faq) {
		this.idNumber = idNumber;
		this.title = title;
		this.money = price;
		this.description = description;
		this.collectedMoney = collectedMoney;
		this.daysOff = daysOff;
		this.urlVideo = urlVideo;
		this.history = history;

	}


/*	public void addProject() {
		scan = new Scanner(System.in);
		System.out.println("Введите название Вашего проекта:");
		title = scan.nextLine();
		System.out.println("Чем будите удивлять? Опишите Ваш проект:");
		description = scan.nextLine();
		System.out
				.println("Сколько Вам нужно денег, что бы реализовать задуманое?");
		String sMoney = scan.nextLine();
		money = Integer.parseInt(sMoney);

	}*/
	public int getId() {
		return idNumber;
	}
	
	public String getTitle() {
		return title;
	}
	public String toString() {
		return (title + "\n" + "Полное описание проекта: " + description + "\n"
				+ "Необходимо собрать: " + money + "грн" + "\n"
				+ "Мы уже собрали: " + collectedMoney + "грн" + "\n"
				+ "Осталось дней до закрытия: " + daysOff + "\n");
	}

	public String allToString() {
		return (title + "\n" + "Полное описание проекта: " + description + "\n"
				+ "Необходимо собрать: " + money + "грн" + "\n"
				+ "Мы уже собрали: " + collectedMoney + "грн" + "\n"
				+ "Осталось дней до закрытия: " + daysOff + "\n" + "••••• Дополнительная информация: " + "\n" + "Демо видео проекта: "
				+ urlVideo + "\n" + "История нашего проекта: " + "\n" + history
				+ "\n" + "FAQ: " + faq.faq + "\n");
	}


}
