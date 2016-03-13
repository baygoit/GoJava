package ua.nenya.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ua.nenya.enums.CreatingProjectMenuEnum;
import ua.nenya.project.Category;
import ua.nenya.project.Project;
import ua.nenya.util.IO;
import ua.nenya.util.ListUtilits;

public class CreatingProjectPage {
	
	public Project createProject(IO io, List<Category> categories, ListUtilits listUtil) {
		
		List<CreatingProjectMenuEnum> listOfProjectMenu = Arrays.asList(CreatingProjectMenuEnum.values());

		int index;
		String name = "";
		String description = "";
		int money = 0;
		int days = 0;
		Category newCategory = new Category("New Category");
		while ((index = listUtil.choseIndexFromList(listOfProjectMenu, io)) != 0) {
			CreatingProjectMenuEnum item = listOfProjectMenu.get(index-1);
			if (item == CreatingProjectMenuEnum.ENTER_NAME) {
				name = enterName(io);
				io.writeln("");
			}
			if (item == CreatingProjectMenuEnum.ENTER_DESCRIPTION) {
				description = enterDescription(io);
				io.writeln("");
			}
			if (item == CreatingProjectMenuEnum.ENTER_AMOUNT_OF_MONEY) {
				money = enterAmountMoney(io);
				io.writeln("");
			}
			if (item == CreatingProjectMenuEnum.ENTER_AMOUNT_OF_DAYS) {
				days = enterDaysNeeded(io);
				io.writeln("");
			}
			if (item == CreatingProjectMenuEnum.ENTER_CATEGORY) {
				newCategory = enterCategory(io, categories, listUtil);
				if(newCategory == null){
					index = 0;
				}
				io.writeln("");
			}
		}
		Project newProject = new Project(name, description, money, 0, days);
		newProject.setCategory(newCategory);
		return newProject;
	}

	private Category enterCategory(IO io, List<Category> categories, ListUtilits listUtil) {
		
		io.write("Choose one of categories: ");
		List<Category> newListOfCategories = new ArrayList<Category>();
		for (int i = 0; i < categories.size()-1; i++) {
			newListOfCategories.add(categories.get(i));
		}

		int newIndex = listUtil.choseIndexFromList(newListOfCategories, io);
		if(newIndex == 0 ){
			return null;
		}
		Category newCategory = newListOfCategories.get(newIndex -1);

		return newCategory;
	}

	private int enterDaysNeeded(IO io) {
		io.write("Enter amount of days needed: ");
		String days = io.readConsole();
		if(isAmountValid(days, io)){
			return Integer.parseInt(days);
		}else{
			return 0;
		}
	}

	private int enterAmountMoney(IO io) {
		io.write("Enter amount of monye needed: ");
		String money = io.readConsole();
		if(isAmountValid(money, io)){
			return Integer.parseInt(money);
		}else{
			return 0;
		}
	}

	private String enterDescription(IO io) {
		io.write("Enter project's description: ");
		return io.readConsole();
	}

	private String enterName(IO io) {
		io.write("Enter project's name: ");
		return io.readConsole();

	}
	
	private boolean isAmountValid(String amount, IO io) {
		int i = -1;
		try {
			i = Integer.parseInt(amount);
		} catch (NumberFormatException e) {
		}
		if (i < 0) {
			io.writeln("Wrong entering!");
			io.writeln("");
			return false;
		} else {
			return true;
		}
	}
}
