public class Test {

	public static void main(String[] args) {
		LoggedUser loggedUser = new LoggedUser();
		loggedUser.setDiary(new CreateDiary().createDiary(1, "T"));
		loggedUser.showMyDiary();
	}
}