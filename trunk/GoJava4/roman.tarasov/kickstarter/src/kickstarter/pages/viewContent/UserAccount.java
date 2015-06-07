package kickstarter.pages.viewContent;

public class UserAccount extends PageView {

	@Override
	public String getHeader() {
		StringBuilder header = new StringBuilder();
		header.append("\n============================");
		header.append("\n|       User Account       |");
		header.append("\n============================");
		header.append("\n");
		header.append("\ncurrent user: ");
		if(idao.getUserService().getUserStatus()!=null){
			header.append(idao.getUserService().getUserStatus().getName());
		}
		header.append("\n------------------------");
		header.append("\nOptions: <p>- previous page  \n<user:guest> - login and password");
		return header.toString();
	}

}
