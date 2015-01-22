package home.BodyTraining.diary;
import java.util.ArrayList;
import java.util.List;

public class DiaryStorage {
	private List<Diary> listOfDiary = new ArrayList<Diary>();
	
	public void addDiaryToStorage(Diary diary){
		listOfDiary.add(diary);				
	}
	
	public List<Diary> getListOfDiary() {
		return listOfDiary;
	}
}
