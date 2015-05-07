package kickstarter;

public class LoginPage extends Page implements UserInterface{
	
	public Page getNextPage() {
final int ADMIN_CATEGORIES_CONTROL=1;
final int USER_CATEGORIES_VIEW=2;
		ui.display("////////////////////////");
		ui.display("// Login              //");
		ui.display("////////////////////////");
		ui.display("0- admin");
		ui.display("1- guest");
		while (true) {

			String fromUI =ui.inputString();
			if(fromUI.equals("0")){
							
				return pages[ADMIN_CATEGORIES_CONTROL];
			}
			if(fromUI.equals("1")){
			
				return pages[USER_CATEGORIES_VIEW];
				
			}
		}
	}



}
