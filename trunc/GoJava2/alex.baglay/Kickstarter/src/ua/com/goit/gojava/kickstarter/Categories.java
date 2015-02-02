package ua.com.goit.gojava.kickstarter;

public class Categories {

	private Category[] categories = new Category[10]; // ах вот оно откуда!! я захардкодил...
	private int count = 0;
	
	public void add(Category category) {
		categories[count] = category;
		count++; 
	}
	
	public String[] getCategories() {
		String[] result = new String[count];
		for (int index = 0; index < count; index++) {
			result[index] = String.valueOf(index) + " - " + categories[index].getName();
		}
		
		return result;
	}

	// тут меня смущает вот что - почему метод называется getName если он уже давно возвращает категорию? 
	// наверное это моя недоработка. Исправим! 
	// оставлять недоработки не хорошо, но они бубдут проскальзывать мимо вас регулярно. Важно, если заметили потом - исправить!
	// А еще хорошо бы пересмотреть все недавнее ваше апи на предмет подобных ошибок. если одна закралась, то 
	// Скорее  всего будут и другие
	public Category get(int index) { 
		// только что сделал автоматический рефакторинг, чтобы не искать все места где надо заменить. 
		//меньше руками делаешь - меньше ошибок 
		return categories[index];  
	}

	// так как мы инкапсулирорвали массив, то надо дать клиенту то, что он просит, а он просит количество категорий
	public int size() {
		// простите туплю :) счетчик уже есть
		return count;
	}

}
