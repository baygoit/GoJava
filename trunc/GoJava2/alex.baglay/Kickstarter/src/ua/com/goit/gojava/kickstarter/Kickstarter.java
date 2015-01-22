package ua.com.goit.gojava.kickstarter;

import java.util.Arrays;
import java.util.Scanner;

public class Kickstarter {

	private Categories categories;

	public Kickstarter(Categories categories) {
		this.categories = categories;
	}

	public static void main(String[] arguments) {		
		Category category1 = new Category("Photo");
		Category category2 = new Category("Video");
		Category category3 = new Category("Music");
		
		Categories categories = new Categories();
		
		categories.add(category1);
		categories.add(category2);
		categories.add(category3);
		
		Kickstarter application = new Kickstarter(categories);
		
		application.run();
	}


	private void run() {		
		QuoteGenerator generator = new QuoteGenerator();
		System.out.println(generator.nextQuote());
		
		System.out.println();
		System.out.println("¬ыберите категорию:");
		System.out.println(Arrays.toString(categories.getCategories()));
		
		// у нас осталось нерешенным часть истории что касаетс€ ввода категории, которую выбрал гость
		// давай ее реализуем
		// вывод сейчас такой 
		// ¬ыберите категорию:
		// [Photo, Video, Music]
		// надо бы номера по пор€дку вывести так же
		// [1 - Photo, 2 - Video, 3 - Music]
		// у нас консольное меню, потому будем заморачиватьс€ с циферками :)
		// с мышкой жить удобнее, мы потом немного переделаем все, чтобы фицерки убрать
		// —ейчас надо пон€ть, где нам сделать эти небольшие изменени€. Ќаверное в списке, потому как индекс это его компетенци€
		// немного промахнулись, начали с нул€. Ќу ладно, мы жеж программисты! ћы считаем с нул€ :)
		// дальше надо попросить пользовател€ чтобы он выбрал циферку
		Scanner scanner = new Scanner(System.in);
		int categoryIndex = scanner.nextInt();
		// дальше нам надо сказать пользователю, что он выбрал соответствующую категорию.
		String categoryName = categories.getName(categoryIndex);
		System.out.println("¬ы выбрали категорию: " + categoryName);
		// ¬се, готово!
		
	}
}
