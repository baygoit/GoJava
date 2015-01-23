package home.Kickstarter.Launch;
import home.Kickstarter.ContentManagement.ContentManager;
import home.Kickstarter.ContentManagement.QouteStorage;
import home.Kickstarter.Kickstarter.Kickstarter;

public class KickstarterLauncher {
	
	public static void main(String[] args) {
		ContentManager contentManager = new ContentManager(new QouteStorage());
		contentManager.createQoute("\"Sometimes when you innovate, you make mistakes.\n It is best to admit them quickly, and get on\n with improving your other innovations.\"", "Steve Jobs");
		Kickstarter kickstarter = new Kickstarter(contentManager.getStorage());
		kickstarter.printTitel();
		kickstarter.displayQoute();
	}
}