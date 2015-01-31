package mainkick;
import java.io.FileNotFoundException;

public class Category{
	public int categoryID;
	public String categoryName;
	public int[] projectsThatContain;
	Output out = new OutputConsole();
	
	public void showAllProjectInCategory(int i) throws FileNotFoundException{
		for (int j : Categories.listCatecories.get(i).projectsThatContain){
			showProjectInShort(j);
		}
	}
	
	public void showProjectInShort(int i) throws FileNotFoundException{
		out.print(Projects.listProject.get(i-1).projectID
				+ ", " + Projects.listProject.get(i).projectName
				+ ", " + Projects.listProject.get(i).shortDescription
				+ ", " + Projects.listProject.get(i).howMuchNeeded
				+ ", " + Projects.listProject.get(i).howMuchRemaining);
	}
	
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}
