package ua.nenya.alex.pages;

import java.util.Arrays;
import java.util.List;

import ua.nenya.alex.project.Project;
import ua.nenya.alex.util.IO;
import ua.nenya.alex.util.ListUtilits;

public class InvestProjectPage {
	
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
			if (item == PaymentSaleEnum.THREE) {
				investThreeHundreds(io, project);
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
			project.addInvestition(PaymentSaleEnum.FIVE.getAmount());
			io.writeln("Your investition has added!");
			io.writeEmpty();
		}

	}

	private void investThreeHundreds(IO io, Project project) {
		io.write("Are you sure? (y/n): ");
		if (io.readConsole().equals("y")) {
			project.addInvestition(PaymentSaleEnum.THREE.getAmount());
			io.writeln("Your investition has added!");
			io.writeEmpty();
		}

	}

	private void investTwoHundreds(IO io, Project project) {
		io.write("Are you sure? (y/n): ");
		if (io.readConsole().equals("y")) {
			project.addInvestition(PaymentSaleEnum.TWO.getAmount());
			io.writeln("Your investition has added!");
			io.writeEmpty();
		}
	}

	private void investOneHundred(IO io, Project project) {
		io.write("Are you sure? (y/n): ");
		if (io.readConsole().equals("y")) {
			project.addInvestition(PaymentSaleEnum.ONE.getAmount());
			io.writeln("Your investition has added!");
			io.writeEmpty();
		}
	}

	private void investAnyAmount(IO io, Project project) {
		io.write("Enter the amount of investition: ");
		String amount = io.readConsole();
		if (isAmountValid(amount, io)) {
			io.write("Are you sure? (y/n): ");
			if (io.readConsole().equals("y")) {
				project.addInvestition(Integer.parseInt(amount));
				io.writeln("Your investition has added!");
				io.writeEmpty();
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
			io.writeEmpty();
			return false;
		} else {
			return true;
		}
	}
}
