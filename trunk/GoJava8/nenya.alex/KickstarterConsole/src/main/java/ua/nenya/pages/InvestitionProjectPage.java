package ua.nenya.pages;


import java.util.List;

import ua.nenya.project.Project;
import ua.nenya.project.Reward;
import ua.nenya.util.IO;
import ua.nenya.util.ListUtilits;

public class InvestitionProjectPage {
	
	public void investInProject(Project project, IO io, ListUtilits listUtil) {
		io.write("Enter your name: ");
		String name = io.readConsole();
		io.write("Enter a number of card: ");
		String card = io.readConsole();
		int index;
		List<Reward> rewards = project.getRewards();
		while ((index = listUtil.choseIndexFromList(rewards, io)) != 0) {
			Reward item = rewards.get(index-1);
			if (item.getName().equals("Any amount")) {
				investAnyAmount(io, project);
			}else{
				if(investWithReward(item, io, project)){
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

	private boolean investWithReward(Reward item, IO io, Project project) {
		io.write("Are you sure? (y/n): ");
		if (io.readConsole().equals("y")) {
			if(addInvestition(item.getAmount(), project)){
			io.writeln("Your investition has added!");
			io.writeln("");
			return true;
			}
		}
		return false;
	}

	private void investAnyAmount(IO io, Project project) {
		io.write("Enter the amount of investition: ");
		String amount = io.readConsole();
		if (isAmountValid(amount, io)) {
			io.write("Are you sure? (y/n): ");
			if (io.readConsole().equals("y")) {
				if(addInvestition(Integer.parseInt(amount), project)){
				io.writeln("Your investition has added!");
				io.writeln("");
				}
			}
		}
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
	
	private boolean addInvestition(int amount, Project project) {
		int previousAmount = project.getAvailableAmount();
		project.setAvailableAmount(previousAmount+amount);
		int realAmount = project.getAvailableAmount();
		return realAmount ==  previousAmount + amount;
	}
}
