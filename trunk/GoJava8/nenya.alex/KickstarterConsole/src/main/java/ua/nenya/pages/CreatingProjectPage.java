package ua.nenya.pages;


import java.util.Arrays;
import java.util.List;

import ua.nenya.project.Category;
import ua.nenya.project.Project;
import ua.nenya.util.IO;
import ua.nenya.util.ListUtilits;
import ua.nenya.enums.CreatingProjectMenuEnum;

public class CreatingProjectPage {

	public void createProject(IO io, List<Category> categories, ListUtilits listUtil) {

		List<CreatingProjectMenuEnum> listOfProjectMenu = Arrays.asList(CreatingProjectMenuEnum.values());

		int index;
		String name = "";
		String description = "";
		int money = 0;
		int days = 0;
		Category chosenCategory = enterCategory(io, categories, listUtil);
		if (chosenCategory == null) {
			io.writeln("You've not chosen category!");
			return;
		} else {
			while ((index = listUtil.choseIndexFromList(listOfProjectMenu, io)) != 0) {
				CreatingProjectMenuEnum item = listOfProjectMenu.get(index - 1);
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

			}
			chosenCategory.getProjects().add( new Project(name, description, money, 0, days));
		}

	}

	private Category enterCategory(IO io, List<Category> categories, ListUtilits listUtil) {

		int index = listUtil.choseIndexFromList(categories, io);
		if(index != 0){
			return categories.get(index - 1);
		}else{
		return null;
		}
	}

	private int enterDaysNeeded(IO io) {
		io.write("Enter amount of days needed: ");
		String days = io.readConsole();
		if (isAmountValid(days, io)) {
			return Integer.parseInt(days);
		} else {
			return 0;
		}
	}

	private int enterAmountMoney(IO io) {
		io.write("Enter amount of monye needed: ");
		String money = io.readConsole();
		if (isAmountValid(money, io)) {
			return Integer.parseInt(money);
		} else {
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
