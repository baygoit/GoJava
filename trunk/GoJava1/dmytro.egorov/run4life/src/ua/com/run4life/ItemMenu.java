package ua.com.run4life;

import java.util.ArrayList;
import java.util.List;

public class ItemMenu {
	private String nameMenu;
	private List<String> subMenu = new ArrayList<String>();
	
	public String getNameMenu() {
		return nameMenu;
	}
	
	public void setNameMenu(String nameMenu) {
		this.nameMenu = nameMenu;
	}

	public List<String> getSubMenu() {
		return subMenu;
	}

	public void addSubMenu(String subMenu) {
		this.subMenu.add(subMenu);
	}

	


}
