package ua.com.goit.gojava.kickstarter;

public abstract class Menu {
	private IO io;

	public Menu(IO io) {
		this.io = io;
	}
	
	public void run() {
		while (true) { 
			ask();
			
			int menu = Integer.parseInt(io.read()); // переобразуем строку в число
			if (menu == 0) {  
				break; 
			}
			
			Object selected = choose(menu);
			if (selected == null) {  
				continue; 
			}
			
			Menu subMenu = nextMenu(selected);  
			if (subMenu != null) {
				subMenu.run();
			}
		}
	}

	abstract Menu nextMenu(Object selected);

	abstract Object choose(int menu);

	abstract void ask();
}
