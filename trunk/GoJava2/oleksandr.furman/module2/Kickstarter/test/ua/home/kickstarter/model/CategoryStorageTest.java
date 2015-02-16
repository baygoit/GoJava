package ua.home.kickstarter.model;

import static org.junit.Assert.*;

import java.util.HashMap;
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
        assertEquals(categoryStorage.getSpecificContent(4), category);
    }
    
    @Test
    public void shouldReturnAddedCategories_whenGetCategories() {
        Map<Integer, Category> categories = new HashMap<Integer, Category>();
        categories.put(1, new Category("Games"));
        categories.put(2, new Category("Technology"));
        categories.put(3, new Category("Design"));
        Map<Integer, Category> categories2 = categoryStorage.getCategories();
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
