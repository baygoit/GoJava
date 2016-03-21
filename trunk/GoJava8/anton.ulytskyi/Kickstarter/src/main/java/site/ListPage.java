package site;


import categories.Category;

public class ListPage extends Page {

	ListPage(Category kickstarter) {
		super(kickstarter);
		
	}

	@Override
	public void openPage() {
		showVision();

		String userChoice = console.read();

		if (isInteger(userChoice) && Integer.parseInt(userChoice) != 0) {

			int numberChoice = Integer.parseInt(userChoice);

			if (numberChoice <= kickstarter.category.size()) {

				direction = new ProfilePage(numberChoice, kickstarter);
				direction.openPage();
			}

		} else if (userChoice.equals(EXIT)) {
			exit();
		} else if (userChoice.equals(PREVIOUS_PAGE)) {
			openPreviousPage();
		} 
			openPage();
		}
	

	@Override
	void openPreviousPage() {
		direction = new CategoryPage(kickstarter);
		direction.openPage();
		
	}

	@Override
	void showVision() {
		
		console.write(DECORATION);
		console.write("Please, chose ID of question:");
		console.write("previous page - `p`;");
		console.write("exit - `0`;");
		console.write(DECORATION);
		
	}

}
