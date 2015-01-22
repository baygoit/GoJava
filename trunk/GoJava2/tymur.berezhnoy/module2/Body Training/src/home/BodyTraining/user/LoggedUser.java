package home.BodyTraining.user;
import home.BodyTraining.diary.Diary;
import home.BodyTraining.diary.DiaryManager;

import java.util.List;

public class LoggedUser {
	
	private DiaryManager diaryManager;
	
	public LoggedUser(DiaryManager diaryManager) {
		this.diaryManager = diaryManager;
	}
	
	public void createDiary(String name) {
		diaryManager.createDiary(name);
	}
	
	public void myDiary() {
		System.out.println("******* My diary *******");
		List<Diary> diary = diaryManager.getArrayOfDiary();
		int i = 1;
		for(Diary d: diary) {
			System.out.println(i + " | " + d.getName());
			i++;
		}
	}
}