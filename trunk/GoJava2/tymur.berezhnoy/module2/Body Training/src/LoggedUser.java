public class LoggedUser {
	
	private Diary diary;
	
	public void setDiary(Diary d) {
		diary = d;
	}
		
	public void showMyDiary() {
		System.out.print(diary.getId() + " " + diary.getName());
	}
}