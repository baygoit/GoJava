import java.util.ArrayList;

public class Сategory {
    private ArrayList categories = new ArrayList();

    public Сategory() {
        categories.add("Food");
        categories.add("Music");
        categories.add("Education");
      }
	
    public void showCategories() {
        for(int i = 0; i < categories.size(); i++){
          System.out.println((i + 1) + ". " + categories.get(i));
        }
    }
}