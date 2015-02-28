package ua.com.goit.gojava.kickstarter;

import ua.com.goit.gojava.kickstarter.input.Reader;

public abstract class Menu {
	private Reader reader;

	public Menu(Reader reader) {
		this.reader = reader;
	}

	public void run() {
		while (true) {
			ask();

			int menu = reader.readInt();
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
