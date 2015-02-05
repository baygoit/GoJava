package ua.com.goit.gojava.kickstarter;

// для этого весь класс тоже должен быть абстрактным
public abstract class Menu {
	private IO io;

	public Menu(IO io) {
		this.io = io;
	}
	
	// для начала я скопирую все меню вот сюда
	// и выделю те строки, которые не являются частью меню, а будут отличаться в разных пунктах меню
	
	public void run() {
		while (true) { // цикл
			ask();
			// о тут зависим от io - а занчит его надо передать извне
			int menu = io.read(); // читаем номер меню
			if (menu == 0) {  // если 0 - выходим
				break; 
			}
			
			Object selected = choose(menu);
			if (selected == null) { // если нет ничего, начинаем с начала 
				continue; 
			}
			
			Menu subMenu = nextMenu(selected);  // Вызываем следующее меню
			if (subMenu != null) { // Если у нас нет подменю, то идем дальше иначе покажем его
				subMenu.run();
			}
		}
	}

	// эти три метода будут наполняться разным контентом в зависимости от того, с каким менбю мы работаем
	// для категорий реализация будет одна, для проектов другая, для конкретного проекта - третья
	// Мы можем сделать их интерфейсом и передавать в класс меню - тогда это будет шаблон strategy
	// но мы можем сделать их абстрактными и в наследниках переопределять - тогда это будет templte method
	// попробуем что-то новое! Полиморфизм с абстрактным классом
	abstract Menu nextMenu(Object selected);

	abstract Object choose(int menu);

	abstract void ask();
}
