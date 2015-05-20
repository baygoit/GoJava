package kickstarter.pages;

public class ModelComment extends Model2{
public void execute(String message) {
		
		if (message.equals("p")) {
			next(DETAILED_PROJECT);
			return;
		}
		String[] array = message.split(":");
		if (array[0].equals("a") && array.length == 2) {
			// TODO
			projectComments.addComment(1, array[1]);// 1- user ID

			next(DETAILED_PROJECT);
			return;

		}
		if (array[0].equals("d") && array.length == 3) {
			try {
				projectComments.deleteComment(array[1], array[2]);
			} catch (NumberFormatException | NullPointerException e) {
				goToAndBack(ERROR_PAGE, COMMENT_PAGE);
				return;
			}
			next(DETAILED_PROJECT);
			return;
		}
		goToAndBack(ERROR_PAGE, COMMENT_PAGE);
		
	}
}
