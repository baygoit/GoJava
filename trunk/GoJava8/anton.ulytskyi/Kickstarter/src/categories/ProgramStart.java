package categories;

import site.Page;
import site.StartPage;

public class ProgramStart {

	public static void main(String[] args) {

		MemoryCard mc = new MemoryCard();
		Category kickstarter = mc.loadBase();
		
		//SqlDAO dao = new SqlDAO();
		//Category kickstarter = dao.loadBase();
		//dao.sendMassage(1, "Jimbo", "Hello");
		
		Page direction = new StartPage(kickstarter);
		direction.openPage();

	}

	

}
