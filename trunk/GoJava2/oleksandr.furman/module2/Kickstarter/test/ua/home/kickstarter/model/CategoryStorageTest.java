package ua.home.kickstarter.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import ua.home.kickstarter.content.Category;


public class CategoryStorageTest {
    CategoryStorage categoryStorage = new CategoryStorage();

    @Test 
    public void shouldBeInitedCategories_whenCreateCategoryStorage() {
        assertEquals(3, categoryStorage.size());
    }
    
    @Test
    public void shouldChangeSize_whenAddNewCategory() {
        assertEquals(3, categoryStorage.size());
        Category category = new Category("FakeCategory");
        categoryStorage.add(category);
        assertEquals(4, categoryStorage.size());
    } 
    
    @Test 
    public void shouldBeCategory_whenGetCategory() {
        Category category = new Category("FakeCategory");
        categoryStorage.add(category);
        assertEquals(categoryStorage.getSpecificContent(3), category);
    }
    
    @Test
    public void shouldReturnAddedCategories_whenGetCategories() {
        List<Category> categories = new ArrayList<Category>();
        categories.add(new Category("Games"));
        categories.add(new Category("Technology"));
        categories.add(new Category("Design"));
        List<Category> categories2 = categoryStorage.getCategories();
        for(int key = 1; key < categories.size(); key++) {    
            assertEquals(categories2.get(key).getName(), 
                    categories.get(key).getName());
        }
    }
 
    @Test
    public void shouldReturnCategory_whenGetCategory() {
        assertEquals("1 - Games\n"
                    + "2 - Technology\n"
                    + "3 - Design\n", categoryStorage.getContent());
    }

}
