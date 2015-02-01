package mainkick;
import java.io.FileNotFoundException;

public class Category{
	public int categoryID;
	public String categoryName;
	public int[] projectsThatContain;
	Output out = new OutputConsole();
	
	public String showAllProjectInCategory(int i) throws FileNotFoundException{
		String s = "";
		for (int j : Categories.listCatecories.get(i).projectsThatContain){
			s += showProjectInShort(j) + "\n";
		}
		return s.substring(0, s.length() - 1);
	}
	
	public String showProjectInShort(int i) throws FileNotFoundException{
		i -= 1;
		String s = Projects.listProject.get(i).projectID
				+ ", " + Projects.listProject.get(i).projectName
				+ ", " + Projects.listProject.get(i).shortDescription
				+ ", " + Projects.listProject.get(i).howMuchNeeded
				+ ", " + Projects.listProject.get(i).howMuchRemaining;
		return s;		
	}
	
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}
