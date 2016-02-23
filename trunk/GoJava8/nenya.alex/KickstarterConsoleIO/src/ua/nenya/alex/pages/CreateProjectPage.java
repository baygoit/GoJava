package ua.nenya.alex.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ua.nenya.alex.project.Category;
import ua.nenya.alex.project.Project;
import ua.nenya.alex.util.IO;
import ua.nenya.alex.util.ListUtilits;

public class CreateProjectPage {
	
	public Project createProject(IO io, List<Category> list, ListUtilits listUtil) {
		
		List<CreateProjectMenuEnum> listOfProjectMenu = Arrays.asList(CreateProjectMenuEnum.values());

		int index;
		String name = "";
		String description = "";
		int money = 0;
		int days = 0;
		Category category = new Category("New Category");
		while ((index = listUtil.choseIndexFromList(listOfProjectMenu, io)) != 0) {
			CreateProjectMenuEnum item = listOfProjectMenu.get(index-1);
			if (item == CreateProjectMenuEnum.ENTER_NAME) {
				name = enterName(io);
				io.writeEmpty();
			}
			if (item == CreateProjectMenuEnum.ENTER_DESCRIPTION) {
				description = enterDescription(io);
				io.writeEmpty();
			}
			if (item == CreateProjectMenuEnum.ENTER_AMOUNT_OF_MONEY) {
				money = enterAmountMoney(io);
				io.writeEmpty();
			}
			if (item == CreateProjectMenuEnum.ENTER_AMOUNT_OF_DAYS) {
				days = enterDaysNeeded(io);
				io.writeEmpty();
			}
			if (item == CreateProjectMenuEnum.ENTER_CATEGORY) {
				category = enterCategory(io, list, listUtil);
				io.writeEmpty();
			}
		}
		Project newProject = new Project(name, description, money, 0, days);
		newProject.setCategory(category);
		return newProject;
	}

	private Category enterCategory(IO io, List<Category> list, ListUtilits listUtil) {
		io.write("Choose one of categories: ");
		List<Category> newListOfCategories = new ArrayList<Category>();
		for (int i = 1; i < list.size(); i++) {
			newListOfCategories.add(list.get(i));
		}

		int newIndex = listUtil.choseIndexFromList(newListOfCategories, io);
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
			io.writeEmpty();
			return false;
		} else {
			return true;
		}
	}
}
