package launcher;
import home.BodyTraining.diary.DiaryManager;
import home.BodyTraining.diary.DiaryStorage;
import home.BodyTraining.user.LoggedUser;

import java.util.Scanner;

public class BodyTraining {
	
	public static void main(String[] args) {
		LoggedUser loggedUser = new LoggedUser(new DiaryManager(new DiaryStorage()));
		loggedUser.createD(new Scanner(System.in));
		loggedUser.createD(new Scanner(System.in));
		loggedUser.createD(new Scanner(System.in));
		loggedUser.myDiary();
	}
}