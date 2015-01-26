package mainkick;
import java.io.FileNotFoundException;

public class Category{
	private int categoryID;
	private String categoryName;
	private int[] projectsThatContain;
	public static int counterCategory;

	public void showAllCatecories() throws FileNotFoundException{
		recordingCategoryFromBD(1);
		for (int i = 1; i <= counterCategory; i++){
			String[] categoryInString = recordingCategoryFromBD(i);
			categoryID = Integer.valueOf(categoryInString[0]);
			categoryName = categoryInString[1];
			System.out.println(categoryID + " " + categoryName);
		}
	}
	
	public String[] recordingCategoryFromBD(int projectID) throws FileNotFoundException{
		ReaderBD reader = new ReaderBD();
		String[] linesAsArray = reader.read("Categories.properties", "Category");
		String[] string = linesAsArray[projectID-1].split("\\[\\]");
		return string;
	}
	
	public void showCategory(int selectCategoryID) throws FileNotFoundException{
		stringConvertToCategory(selectCategoryID);
		Output out = new OutputConsole();
		out.print("categoryID = " + categoryID);
		out.print("categoryName: " + categoryName);
		out.print("projectsThatContain: " + projectsThatContain);
	}
	
	private int[] stringConvertToCategory(int selectProjectID) throws FileNotFoundException{
		String[] projectInString = recordingCategoryFromBD(selectProjectID);
		categoryID = Integer.valueOf(projectInString[0]);
		categoryName = projectInString[1];
		String[] string = projectInString[2].split(",");
		projectsThatContain = new int[string.length];
		for (int i = 0; i < string.length; i++){
			projectsThatContain[i] = Integer.valueOf(string[i]);
		}
		return projectsThatContain;
	}
	
	public void showAllProjectInCategory(int categoryNamber) throws FileNotFoundException{
		projectsThatContain = stringConvertToCategory(categoryNamber);
		Project pr = new Project();
		pr.showAllProjectInCategory(projectsThatContain);
	}
	
	public void addCategory(){
		//TODO
		counterCategory++;
	}
	
	public void deleteCategory(){
		//TODO
		counterCategory--;
	}
	
	
}
