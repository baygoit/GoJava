package ua.com.goit.gojava.kickstarter;

public class Categories {

	// Мы создали пока массив размером в 10 элементов и будем все хранить там. 
	// конечно же у нас будет ошибка, если мы переполним массив, но пока нам так ок
	// если что-то надо сделать дополнительное, то пишем TODO и потом исправляем (не слишком откладывая)
	private Category[] categories = new Category[10];
	
	// так же нам понадобится индекс по массиву. Где есть массив - всегда есть индекс
	// так как тут будет конфликт, то наверное надо назвать переменную как-то иначе
	private int count = 0;
	
	public void add(Category category) {
		categories[count] = category;
		count++; // индекс увеличиваем, потому как следующая категория должна быть в новой позиции и не перетирать старую запись
	}
	
	// но немой список категорий наверное нам не пригодится. Надо как-то получать информацию о категориях. Как? 
	public String[] getCategories() {
		String[] result = new String[count];
		// возвращать будем имена категорий, потому что их потом нам надо будет вывести на экран
		for (int index = 0; index < count; index++) {
			result[index] = categories[index].getName();
		}
		
		return result;
	}

}
