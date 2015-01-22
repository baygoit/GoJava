package home.BodyTraining.user;
import home.BodyTraining.diary.Diary;
import home.BodyTraining.diary.DiaryManager;

import java.util.List;
import java.util.Scanner;

public class LoggedUser {
	
	 DiaryManager diaryManager;
	
	public LoggedUser(DiaryManager diaryManager) {
		this.diaryManager = diaryManager;
	}
	
	public void createD(Scanner scanner) {
		System.out.print("Enter the name of diary: ");
		diaryManager.createDiary(scanner.nextLine());
	}
	
	public void myDiary() {
		System.out.println("\n******* My diary *******");
		List<Diary> diary = diaryManager.getArrayOfDiary();
		int i = 1;
		for(Diary d: diary) {
			System.out.println(i + " | " + d.getName());
			i++;
		}
	}
}