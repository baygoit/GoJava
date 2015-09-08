package belskii.artem.kickstarter.dao.category;

import java.util.HashMap;

public class CategoryDaoImplHardCoding implements CategoryDao {
	private HashMap<Integer, String> categoryes;

	public CategoryDaoImplHardCoding() {
		categoryes = new HashMap<Integer, String>();
		this.addCategory("Art");
		this.addCategory("Comics");
		this.addCategory("Crafts");
		this.addCategory("Dance");
		this.addCategory("Design");
		this.addCategory("Fashion");
		this.addCategory("Film & Video");
		this.addCategory("Food");
		this.addCategory("Games");
		this.addCategory("Journalism");
		this.addCategory("Music");
		this.addCategory("Photography");
		this.addCategory("Publishing");
		this.addCategory("Technology");
		this.addCategory("Theater");
	}

	public void addCategory(String categoryName) {
		int index = categoryes.size();
		categoryes.put(index, categoryName);
	}

	public HashMap<Integer,String> getCategoryList() {
		return categoryes;
	}

	public String getCategoryNameById(int id) {
		String answer;
		if (this.getCategoryList().containsKey(id)){		
			answer = this.getCategoryList().get(id);
		} else{
			answer = "-1";
		}
		return answer;
	}

	@Override
	public void initDemoDB() {
		// TODO Auto-generated method stub
		
	}
}
