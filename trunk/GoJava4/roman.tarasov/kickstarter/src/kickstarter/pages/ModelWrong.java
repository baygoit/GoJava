package kickstarter.pages;

public class ModelWrong extends Model2{
	public void execute(String message) {
		if (message.equals("p")) {
			next(getSavedPage());
			return;
		}
	}
}
