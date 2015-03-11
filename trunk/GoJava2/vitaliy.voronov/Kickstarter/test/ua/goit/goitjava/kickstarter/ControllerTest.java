package ua.goit.goitjava.kickstarter;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import ua.goit.goitjava.kickstarter.Controller.Controller;
import ua.goit.goitjava.kickstarter.DB.CategoriesDAO;
import ua.goit.goitjava.kickstarter.model.Category;

public class ControllerTest {
	
	
	@Test
	public void test1(){
		CategoriesDAO cat = mock(CategoriesDAO.class);
		Controller controller = new Controller(cat, null, null);
		
		List<Category> list = new ArrayList<Category>();
		list.add(new Category("name1", 1));
		list.add(new Category("name2", 2));
		
		Mockito.when(cat.getAllCategories()).thenReturn(list);
		
		Assert.assertEquals("name1\nname2\n", controller.getCategoriesString());
		
	}
	
//	@Test
//	public void test2(){
//		CategoriesDAO cat = mock(CategoriesDAO.class);
//		Controller controller = mock(Controller.class);
//		
//		List<Category> list = new ArrayList<Category>();
//		list.add(new Category("name1", 1));
//		list.add(new Category("name2", 2));
//		
//		when(cat.getAllCategories()).thenReturn(list);
//		
//		controller.getCategoriesString();
//		
//		verify(controller).getCategoriesString();
//		
//	}
	

}
