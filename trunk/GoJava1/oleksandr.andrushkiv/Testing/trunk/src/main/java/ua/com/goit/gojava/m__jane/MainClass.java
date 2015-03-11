package ua.com.goit.gojava.m__jane;

import javax.xml.bind.JAXBException;

import ua.com.goit.gojava.m__jane.model.Category;
import ua.com.goit.gojava.m__jane.model.Profile;
import ua.com.goit.gojava.m__jane.model.Quiz;
import ua.com.goit.gojava.m__jane.model.User;
import ua.com.goit.gojava.m__jane.model.question.Question;
import ua.com.goit.gojava.m__jane.utils.DataBuilder;
import ua.com.goit.gojava.m__jane.utils.DataLoader;

public class MainClass {

	public static void main(String[] args) throws JAXBException {

		// LoggerForTrain loggerForTrain = new LoggerForTrain();
		// loggerForTrain.doSmth();

		DataLoader dataLoader = DataBuilder.getInstance().getDataLoader();

		for (User user : dataLoader.getUserList()) {
			System.out.println(user);

			for (Profile profile : user.getProfileList()) {
				System.out.println("	profile=" + profile);

				for (Quiz quiz : profile.getQuizList()) {
					System.out.println("		Quiz=" + quiz);

					for (Category category : quiz.getCategoryList()) {
						System.out.println("			Category=" + category);

						for (Question question : category.getQuestionList()) {
							System.out.println("				question=" + question);
						}
					}
				}
			}

			System.out.println("\n");
		}

		/*
		 * for (Category category : dataLoader.getCategoryList()) {
		 * System.out.println(category); }
		 * 
		 * for (Question question : dataLoader.getQuestionList()) {
		 * System.out.println(question); }
		 */
		/*
		 * ProfileService profileService = new ProfileServiceImpl();
		 * 
		 * for (Profile profile : profileService.getProfileList()) {
		 * 
		 * System.out.println(profile);
		 * 
		 * for (Category category : profile .getQuestionCategoryList()) {
		 * System.out.println("	Category=" + category);
		 * 
		 * for (Question question : category.getQuestionList()) {
		 * System.out.println("		question=" + question); } }
		 * System.out.println("\n"); }
		 */

	}

	/*
	 * private static QuestionService questionService = new
	 * QuestionServiceImpl(); private static ProfileService profileService = new
	 * ProfileServiceImpl();
	 * 
	 * public static void main(String[] args) {
	 * 
	 * System.out.println("User story 1 - press 1 | User story 2 - press 2");
	 * Scanner scanIn = new Scanner(System.in); int choice =
	 * Integer.parseInt(scanIn.nextLine());
	 * 
	 * if (choice == 1) { printAllProfiles(); } else if (choice == 2) {
	 * askAndPrintQuestionsOfOneProfile(scanIn); } else {
	 * System.out.println("Wrong choice"); }
	 * 
	 * }
	 * 
	 * 
	 * private static void printAllProfiles() { for (Profile profile :
	 * profileService.getProfileList()) { System.out.println(profile); } }
	 * 
	 * private static void askAndPrintQuestionsOfOneProfile(Scanner scanIn) {
	 * 
	 * //яке призначення методу getProfileCount() для бізнес логіки? //ось я
	 * його використовую
	 * System.out.println("Enter number the question from 1 to " +
	 * profileService.getProfileCount()); Profile profile =
	 * profileService.getProfile(Integer.parseInt(scanIn.nextLine().trim())); if
	 * (profile == null) { System.out.println("Not found such profile"); } else
	 * { List<Question> list = questionService.getQuestionList(profile); for
	 * (Question question : list) { System.out.println(question); } }
	 * 
	 * }
	 */
}
