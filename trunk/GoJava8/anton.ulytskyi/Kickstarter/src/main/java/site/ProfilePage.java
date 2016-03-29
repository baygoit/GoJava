package site;

import categories.Kickstarter;
import categories.SqlDAO;

public class ProfilePage extends Page {

	int id;

	ProfilePage(int id, Kickstarter kickstarter) {
		super(kickstarter);
		this.id = id;
	}

	@Override
	public void openPage() {
		showVision();
		String userChoice = console.read();
		if (userChoice.equals(FIRST_CHOICE)) {
			invest();
			openPage();
		} else if (userChoice.equals(SECOND_CHOICE)) {
			ask();
			openPage();
		} else if (userChoice.equals(THIRD_CHOICE)) {
			direction = new ListPage(kickstarter);
			direction.openPage();
		} else if (userChoice.equals(PREVIOUS_PAGE)) {
			openPreviousPage();
		} else if (userChoice.equals(EXIT)) {
			exit();
		} else {
			openPage();
		}
	}

	private void ask() {
		console.write("Please, write down Your name:");
		String author = console.read();
		console.write("Input Your comment:");
		String comment = console.read();
		kickstarter.addComment(id, author, comment);
		console.write("Thank You for Your comment!");

		new SqlDAO().sendMassage(id, author, comment);

	}

	private void invest() {
		console.write("You need to know, how much we need for project:");
		console.write("5 USD - inspiration, 10 USD - hard work, 100 USD - success:");
		console.write("How much do You want to give for project?");
		String money = console.read();
		if (isInteger(money)) {
			int cash = Integer.parseInt(money);
			console.write("Are You shure You want to send " + money
					+ " USD for this profect (ID:" + id
					+ ")? 1 - yes, other buttom - no.");
			String deal = console.read();
			if (deal.equals(FIRST_CHOICE)) {
				console.write("Please, input number of Your card:");
				String card = console.read();
				if (checkSuccess(card)) {
					kickstarter.sendCash(id, cash);

					new SqlDAO().sendMoney(id, cash, card);

					console.write("The transaction was successful.");
					openPage();
				}
			}
		}
		console.write("The transaction was faild.");
		openPage();

	}

	private boolean checkSuccess(String card) {
		boolean check = false;
		int checkCount = 0;
		final int CARD_CONSTANT = 16;
		String cardChecking[] = card.split("");
		if (cardChecking.length == CARD_CONSTANT) {
			for (int index = 0; index < cardChecking.length; index++) {
				checkCount++;
			}
			if (checkCount == CARD_CONSTANT) {
				check = true;
			}
		}
		return check;
	}

	@Override
	void openPreviousPage() {
		direction = new ListPage(kickstarter);
		console.write(kickstarter.openCatalog(kickstarter.checkType(id)));
		direction.openPage();
	}

	@Override
	void showVision() {
		console.write(DECORATION);
		console.write(kickstarter.findProfile(id));
		console.write(DECORATION);
		console.write("Choose option:");
		console.write("1 - invest; 2 - ask question; 3 - go to list;");
		console.write("`p` - go to other projects; 0 - exit.");
		console.write(DECORATION);

	}

}
