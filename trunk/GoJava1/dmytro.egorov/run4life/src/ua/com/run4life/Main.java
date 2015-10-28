package ua.com.run4life;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		Main app = new Main();

		ItemMenu itemMenu1 = new ItemMenu();
		itemMenu1.setNameMenu("Новости");
		ItemMenu itemMenu2 = new ItemMenu();
		itemMenu2.setNameMenu("Персональный план");
		itemMenu2.addSubMenu("Создать персональный план");
		itemMenu2.addSubMenu("Редактировать персональный план");
		ItemMenu itemMenu3 = new ItemMenu();
		itemMenu3.setNameMenu("Личные данные");

		Menu menu = new Menu();
		
		menu.addMenu(itemMenu1);
		menu.addMenu(itemMenu2);
		menu.addMenu(itemMenu3);
		
		Article article1 = new Article("Новость1",Date.valueOf("2015-02-02"),"Описание");
		Article article2 = new Article("Новость2",Date.valueOf("2015-02-03"),"Описание");
		News news = new News();
		news.addNews(article1);
		news.addNews(article2);
		UserData user1 = new UserData("Макс", "Пупкин", "maxpupkin@gmail.com",
				"madmax", 0, "Пользователь", 24, "male");

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		System.out.println("Выберите пункт меню");
		List<ItemMenu> itemsMenu = menu.getMenu();
		List<Article> articles = news.getArticle();
		for (ItemMenu item : itemsMenu) {
			System.out.print(item.getNameMenu() + " ");
		}
		String choice = reader.readLine();

		Boolean found = false;
		for (ItemMenu item : itemsMenu) {
			if (item.getNameMenu().contains(choice)) {
				switch (choice) {
				case "Новости": {
					if(news==null){
					System.out.println("Новостей нет");}
					else{
					 for(Article article: articles){
						 System.out.print(article.getName() + " ");
					 }
					}
					found=true;
					break;
				}
				case "Личные данные": {
					System.out.println(user1.getName());
					System.out.println(user1.getSurName());
					System.out.println(user1.getEmail());
					System.out.println(user1.getNickName());
					System.out.println(user1.getAge());
					System.out.println(user1.getSex());
					found=true;
					break;
				}
				case "Персональный план": {
					if (user1.getPersonalPlan() == null) {
						System.out.println("У вас еще нет персонального плана");
						System.out.println(item.getSubMenu());
					}
					found=true;
					break;
				}
				}
			}
		}
		if (!found){
			System.out.println("Такого пункта нет");
		}
	}
}
