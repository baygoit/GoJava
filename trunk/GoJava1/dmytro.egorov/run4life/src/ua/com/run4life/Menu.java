package ua.com.run4life;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	private List<ItemMenu> menu = new ArrayList<ItemMenu>();

	public List<ItemMenu> getMenu() {
		return menu;
	}

	public void addMenu(ItemMenu itemMenu) {
		this.menu.add(itemMenu);
	}
	
}
