package ua.com.goit.gojava7.kickstarter.domain;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Category{
    private String categoryName;
    private int    categoryId;

    public Category() {
    }

    public Category(String categoryName, int categoryId) {
        super();
        this.categoryName = categoryName;
        this.categoryId = categoryId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    @XmlAttribute
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    @XmlElement
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
