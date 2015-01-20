public class LoggedUser {
	
	Diary diary = new CreateDiary().createDiary(1, "First Diary");
	public void showMyDiary() {
		System.out.print(diary.getId() + " " + diary.getName());
	}
}