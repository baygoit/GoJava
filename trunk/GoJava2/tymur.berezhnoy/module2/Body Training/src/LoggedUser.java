
public class LoggedUser extends User implements DiaryManagmant {
	
	private Diary diary;
	
	@Override
	public void createDiary(int id, String name) {
		diary = new Diary();
		diary.setNameDiary(name);
	}
	
	public void showUserDiary() {
		System.out.println("**** List of user's diary ****");
		System.out.println("ID | NAME");
		System.out.print(diary.getId() + "    " + diary.getNameDiary());
	}
}