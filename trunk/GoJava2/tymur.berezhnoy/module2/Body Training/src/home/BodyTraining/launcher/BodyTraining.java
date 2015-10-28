package home.BodyTraining.launcher;
import home.BodyTraining.diary.DiaryManager;
import home.BodyTraining.diary.DiaryStorage;
import home.BodyTraining.user.LoggedUser;

public class BodyTraining {
	
	public static void main(String[] args) {
		LoggedUser loggedUser = new LoggedUser(new DiaryManager(new DiaryStorage()));
		loggedUser.createDiary("Fitnes");
		loggedUser.createDiary("Body fitnes");
		loggedUser.createDiary("Pilates");
		loggedUser.myDiary();
	}
}