package ua.com.scread.kickstarter;

import java.util.ArrayList;
import java.util.List;

public class Categories {

	private List<Category> categories;

	public Categories() {
		categories = new ArrayList<Category>();
	}
		
	public void add(Category category) {
		categories.add(category);	
	}
	
	
	public String[] getStringCategories() {
		String[] result = new String[categories.size()];
		for (int i = 0; i < categories.size(); i++) {
			result[i] = String.valueOf(i+1) + " - " + categories.get(i).getName();
		}
		return result;
	}
	
	public List<Category> getCategories() {
		return categories;
	}

	public Category getCategory(int index) {
		return categories.get(index);
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((categories == null) ? 0 : categories.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Categories other = (Categories) obj;
        if (categories == null) {
            if (other.categories != null)
                return false;
        } else if (!categories.equals(other.categories))
            return false;
        return true;
    }

}
