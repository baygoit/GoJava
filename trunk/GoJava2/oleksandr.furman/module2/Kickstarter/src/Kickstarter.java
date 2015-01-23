import java.util.ArrayList;
import java.util.Random;

public class Kickstarter {
	public void process() {
		quotations();
		conteiner();
	}

	ArrayList<String> categories;
	ArrayList<String> game1;
	ArrayList<String> game2;
	ArrayList<String> game3;
	ArrayList<String> technology1;
	ArrayList<String> technology2;
	ArrayList<String> technology3;

	public Kickstarter() {
		categories = new ArrayList<String>();
		game1 = new ArrayList<String>();
		game2 = new ArrayList<String>();
		game3 = new ArrayList<String>();
		technology1 = new ArrayList<String>();
		technology2 = new ArrayList<String>();
		technology3 = new ArrayList<String>();
	}

	private void quotations() {
		ArrayList<String> quotations = new ArrayList<String>();
		quotations
				.add("Нельзя же сказать человеку: «Ты можешь творить. Так давай, твори». Гораздо вернее подождать, пока он сам не скажет: "
						+ "«Я могу творить, и я буду творить, хотите вы этого или нет». (c) Айзек Азимов");
		quotations
				.add("Я не хочу создавать что-то для того, чтобы мне платили. Я хочу, чтобы мне платили за то, что я что-то создаю. (c) Леонард Коэн");
		quotations.add("Ключ к открытию вашей мечты – это, в первую очередь, творчество. (c) Зак Эфрон");
		Random ran = new Random();
		System.out.println(quotations.get(ran.nextInt(quotations.size())));
		System.out.println();
	}

	private void conteiner() {
		categories.add("1 - Игры");
		categories.add("2 - Технологии");

		game1.add("1 - Space Cadets: Away Missions");
		game1.add("A cooperative game, the 3rd title in the Space Cadets line. Explore UFOs, acquire alien technology and fight hordes of hostile aliens!");
		game1.add("40000");
		game1.add("69587");
		game1.add("28");
		game1.add("тут будет история проекта");
		game1.add("тут будут линки на видео");
		game1.add("тут будут вопросы и ответы");

		game2.add("2 - Epic PvP: Fantasy");
		game2.add("Make a character by choosing a Class Deck, a Race Deck, and shuffling them together. Then battle in this fast-paced card game.");
		game2.add("15000");
		game2.add("54987");
		game2.add("32");
		game2.add("тут будет история проекта");
		game2.add("тут будут линки на видео");
		game2.add("тут будут вопросы и ответы");

		game3.add("3 - BaneBeasts: Mighty Monsters");
		game3.add("Grab the mightiest of monsters, from dragons and demons to rat beasts and orc wyverns, for your tabletop fantasy armies!");
		game3.add("11940");
		game3.add("5000");
		game3.add("17");
		game3.add("тут будет история проекта");
		game3.add("тут будут линки на видео");
		game3.add("тут будут вопросы и ответы");

		technology1.add("1 - sdf");
		technology1.add("cvb");
		technology1.add("356");
		technology1.add("324");
		technology1.add("234");
		technology1.add("тут будет история проекта");
		technology1.add("тут будут линки на видео");
		technology1.add("тут будут вопросы и ответы");

		technology2.add("2 - sdf");
		technology2.add("cvb");
		technology2.add("345");
		technology2.add("789");
		technology2.add("678");
		technology2.add("тут будет история проекта");
		technology2.add("тут будут линки на видео");
		technology2.add("тут будут вопросы и ответы");

		technology3.add("3 - sdf");
		technology3.add("cvb");
		technology3.add("63458");
		technology3.add("34");
		technology3.add("234");
		technology3.add("тут будет история проекта");
		technology3.add("тут будут линки на видео");
		technology3.add("тут будут вопросы и ответы");
	}

	void projectsDescription(ArrayList<String> project) {
		System.out.println("Название проекта: " + project.get(0));
		System.out.println("Описание проекта: " + project.get(1));
		System.out.println("Сумма необходимая для сбора: $" + Integer.parseInt(project.get(2)));
		System.out.println("Собранная сумма: $" + Integer.parseInt(project.get(3)));
		System.out.println("Дни до конца сбора средств: " + Integer.parseInt(project.get(4)));
		System.out.println();
	}

	void projectsFullDescription(ArrayList<String> project) {
		System.out.println("Название проекта: " + project.get(0));
		System.out.println("Описание проекта: " + project.get(1));
		System.out.println("Сумма необходимая для сбора: $" + Integer.parseInt(project.get(2)));
		System.out.println("Собранная сумма: $" + Integer.parseInt(project.get(3)));
		System.out.println("Дни до окончания сбора средств: " + Integer.parseInt(project.get(4)));
		System.out.println("История проекта: " + project.get(5));
		System.out.println("Линк на видео с демо: " + project.get(6));
		System.out.println("Вопросы/ответы: " + project.get(7));
		System.out.println("0 - Выход");
	}
}
