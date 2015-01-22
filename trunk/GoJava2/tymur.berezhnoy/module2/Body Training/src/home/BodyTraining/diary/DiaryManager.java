package home.BodyTraining.diary;
import java.util.List;
public class DiaryManager implements DiaryManagment{
	
	private Diary diary;
	private DiaryStorage diaryStorage;
	
	public DiaryManager(DiaryStorage diaryStorage) {
		this.diaryStorage = diaryStorage;
	}
	
	@Override
	public void createDiary(String name) {
		diary = new Diary(name);
		diaryStorage.addDiaryToStorage(diary);
	}
	
	@Override
	public List<Diary> getArrayOfDiary() {
		return diaryStorage.getListOfDiary();
	}
}
