package gojava.Interface;

public interface Menu {
	
	abstract void categoriesMenu();

	abstract void categoryMenu(Object object);

	abstract void projectMenu(Object object);

	abstract void inProjectMenu(Object object, int choice);

}