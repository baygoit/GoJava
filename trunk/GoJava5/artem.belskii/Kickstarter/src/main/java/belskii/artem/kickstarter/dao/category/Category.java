package belskii.artem.kickstarter.dao.category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="CATEGORY")
public class Category {
	@Id
	@Column (name="ID")
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int categoryId;
	@Column (name="TITLE")
	private String categoryName;

	public Category() {}
	public Category(int id, String name) {
		this.setCategoryId(id);
		this.setCategoryName(name);
	}
	public Category(String name) {
		this.setCategoryName(name);
	}	
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


}
