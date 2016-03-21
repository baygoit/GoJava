package categories;

import site.Page;
import site.StartPage;

public class ProgramStart {

	public static void main(String[] args) {

		MemoryCard mc = new MemoryCard();
		Category kickstarter = mc.loadBase();
		
		Page direction = new StartPage(kickstarter);
		direction.openPage();

	}

	

}
