package site;

import categories.Kickstarter;

public class CategoryPage extends Page {
	CategoryPage(Kickstarter kickstarter) {
		super(kickstarter);
	}

	@Override
	public void openPage() {
		showVision();

		String userChoice = console.read();
		direction = new ListPage(kickstarter);

		if (userChoice.equals(FIRST_CHOICE)) {
			console.write(PARADOX + ":");
			console.write(DECORATION);
			console.write(kickstarter.openCatalog(PARADOX));
			direction.openPage();

		} else if (userChoice.equals(SECOND_CHOICE)) {
			console.write(SOPHISM + ":");
			console.write(DECORATION);
			console.write((kickstarter.openCatalog(SOPHISM)));
			direction.openPage();

		} else if (userChoice.equals(THIRD_CHOICE)) {
			console.write(APORIA + ":");
			console.write(DECORATION);
			console.write((kickstarter.openCatalog(APORIA)));
			direction.openPage();

		} else if (userChoice.equals(PREVIOUS_PAGE)) {
			openPreviousPage();

		} else if (userChoice.equals(EXIT)) {
			exit();

		} else {
			openPage();
		}

	}

	@Override
	void openPreviousPage() {
		direction = new StartPage(kickstarter);
		direction.openPage();

	}

	@Override
	void showVision() {

		console.write(DECORATION);
		console.write("Please, choose category:");
		console.write(DECORATION);
		console.write("1. Paradox is a statement that apparently contradicts itself and yet might be true.");
		console.write("2. Sophism is a specious argument for displaying ingenuity in reasoning or for deceiving someone.;");
		console.write("3. Aporia is a philosophical puzzle or a seemingly insoluble impasse in an inquiry;");
		console.write(DECORATION);
		console.write("p. Go to the previous page.");
		console.write("0. Exit");
		console.write(DECORATION);

	}

}
