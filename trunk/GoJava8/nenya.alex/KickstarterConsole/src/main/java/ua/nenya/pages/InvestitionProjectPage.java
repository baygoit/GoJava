package ua.nenya.pages;

import java.util.Arrays;
import java.util.List;

import ua.nenya.project.Project;
import ua.nenya.util.IO;
import ua.nenya.util.ListUtilits;
import ua.nenya.enums.PaymentSaleEnum;

public class InvestitionProjectPage {
	
	public boolean investInProject(Project project, IO io, ListUtilits listUtil) {
		boolean b = false;
		io.write("Enter your name: ");
		String name = io.readConsole();
		io.write("Enter a number of card: ");
		String card = io.readConsole();
		int index;
		List<PaymentSaleEnum> listOfSale = Arrays.asList(PaymentSaleEnum.values());
		while ((index = listUtil.choseIndexFromList(listOfSale, io)) != 0) {
			b = true;
			PaymentSaleEnum item = listOfSale.get(index-1);
			if (item == PaymentSaleEnum.ONE) {
				io.writeln(PaymentSaleEnum.ONE.getDescriptionOfAmount());
				investOneHundred(io, project);
				b = true;
			}
			if (item == PaymentSaleEnum.TWO) {
				investTwoHundreds(io, project);
				b = true;
			}
			if (item == PaymentSaleEnum.FIVE) {
				investFiveHundreds(io, project);
				b = true;
			}
			if (item == PaymentSaleEnum.ANY_AMOUNT) {
				investAnyAmount(io, project);
				b = true;
			}
		}
		return b;

	}

	private void investFiveHundreds(IO io, Project project) {
		io.write("Are you sure? (y/n): ");
		if (io.readConsole().equals("y")) {
			addInvestition(PaymentSaleEnum.FIVE.getAmount(), project);
			io.writeln("Your investition has added!");
			io.writeln("");
		}

	}

	private void investTwoHundreds(IO io, Project project) {
		io.write("Are you sure? (y/n): ");
		if (io.readConsole().equals("y")) {
			addInvestition(PaymentSaleEnum.TWO.getAmount(), project);
			io.writeln("Your investition has added!");
			io.writeln("");
		}
	}

	private void investOneHundred(IO io, Project project) {
		io.write("Are you sure? (y/n): ");
		if (io.readConsole().equals("y")) {
			addInvestition(PaymentSaleEnum.ONE.getAmount(), project);
			io.writeln("Your investition has added!");
			io.writeln("");
		}
	}

	private void investAnyAmount(IO io, Project project) {
		io.write("Enter the amount of investition: ");
		String amount = io.readConsole();
		if (isAmountValid(amount, io)) {
			io.write("Are you sure? (y/n): ");
			if (io.readConsole().equals("y")) {
				addInvestition(Integer.parseInt(amount), project);
				io.writeln("Your investition has added!");
				io.writeln("");
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
	
	private void addInvestition(int i, Project project) {
		project.setAvailableAmount(project.getAvailableAmount()+i);
	}
}
