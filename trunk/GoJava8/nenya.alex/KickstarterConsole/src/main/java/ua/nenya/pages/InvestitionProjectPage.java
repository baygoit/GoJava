package ua.nenya.pages;


import java.util.List;

import ua.nenya.dao.CategoryDao;
import ua.nenya.main.DaoInitilizer;
import ua.nenya.project.Project;
import ua.nenya.project.Reward;
import ua.nenya.util.IO;
import ua.nenya.util.ListUtilits;

public class InvestitionProjectPage {
	private Project project;
	private IO io;
	private DaoInitilizer initilizer;
	
	public void investInProject(DaoInitilizer initilizer, Project project, IO io, ListUtilits listUtil) {
		this.project = project;
		this.io = io;
		this.initilizer = initilizer;
		io.write("Enter your name: ");
		String name = io.readConsole();
		io.write("Enter a number of card: ");
		String card = io.readConsole();
		int index;
		CategoryDao categoryDao= initilizer.getCategoryDao();
		List<Reward> rewards = categoryDao.initRewards(project);
		while ((index = listUtil.choseIndexFromList(rewards, io)) != 0) {
			Reward item = rewards.get(index-1);
			if (item.getName().equals("Any amount")) {
				investAnyAmount();
			}else{
				if(investWithReward(item)){
					for(int i = 0; i < rewards.size(); i++){
						if(rewards.get(i).equals(item)){
							rewards.remove(i);
							break;
						}
					}
				}
			}
			
		}

	}

	private boolean investWithReward(Reward item) {
		io.write("Are you sure? (y/n): ");
		if (io.readConsole().equals("y")) {
			CategoryDao categoryDao = initilizer.getCategoryDao();
			categoryDao.writeIvestmentInProject(project, item.getAmount());
			io.writeln("Your investition has added!");
			io.writeln("");
			return true;
		}else{
		return false;
		}
	}

	private void investAnyAmount() {
		io.write("Enter the amount of investition: ");
		String amount = io.readConsole();
		if (isAmountValid(amount)) {
			io.write("Are you sure? (y/n): ");
			if (io.readConsole().equals("y")) {
				CategoryDao categoryDao = initilizer.getCategoryDao();
				categoryDao.writeIvestmentInProject(project, Integer.parseInt(amount));
				io.writeln("Your investition has added!");
				io.writeln("");
			}

		}
	}

	private boolean isAmountValid(String amount) {
		int i = -1;
		try {
			i = Integer.parseInt(amount);
		} catch (NumberFormatException e) {
			e.getStackTrace();
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
