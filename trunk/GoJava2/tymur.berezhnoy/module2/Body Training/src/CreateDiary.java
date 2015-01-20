
public class CreateDiary implements DiaryManagement {

	@Override
	public Diary createDiary(int id, String name) {
		Diary diary = new Diary();
		diary.setId(id);
		diary.setName(name);
		return diary;
	}
}
