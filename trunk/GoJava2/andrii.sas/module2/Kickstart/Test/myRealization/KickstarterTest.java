package myRealization;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class KickstarterTest {
	@Test
	public void dummy_stub(){
		Output out = new Output() {
			
			@Override
			public void println(String s) {
				//nothing
			}
		};
		Input in = new Input() {
			
			@Override
			public int readChoice() {
				return 0;
			}
		};
		
		Categories categories = new Categories();
		Projects projects = new Projects();
		Quote Quote = new Quote() {
			
			@Override
			public String generateQuote() {
				return "";
			}
		};
		Kickstart kickstart = new Kickstart(out, in, categories, projects, Quote);
		kickstart.buildMenu();
	}
	
	class FakeOutput implements Output{
		
		private List<String> list = new LinkedList<>();
		
		public List<String> getList() {
			return list;
		}

		@Override
		public void println(String s) {
			
			list.add(s + "\n");
		}

		
	}
	
	class FakeInput implements Input{
		private List<Integer> choices;
		public FakeInput(Integer... choices) {
			this.choices = new LinkedList<>(Arrays.asList(choices));
		}
		
		@Override
		public int readChoice() {
			return choices.remove(0);
		}
	}
	
	class StubQuote implements Quote {
		
		@Override
		public String generateQuote() {
			return "quote";
		}
	}
	
	@Test
	public void fake(){
		//given
		FakeOutput out = new FakeOutput();
		Input in = new FakeInput(1, 0, 0);			
		Categories categories = new Categories();
		Projects projects = new Projects();
		Quote Quote = new StubQuote();
		Category category1 = new Category("category1");
		Category category2 = new Category("category2");
		categories.addCategory(category1);
		categories.addCategory(category2);
		Kickstart kickstart = new Kickstart(out, in, categories, projects, Quote);
			
		//when
		kickstart.buildMenu();
		String storage = out.getList().toString();
			
		//then
		assertEquals("[quote\n" +
		              ", 1 - category1, 2 - category2\n" +
		              "What are you interested in? Pleace, make your choice:\n" +
		              ", You chose - category1\n" +
		              ", If you want to return press \"0\"\n" +
		              ", 1 - category1, 2 - category2\n" +
		              "What are you interested in? Pleace, make your choice:\n" +
		              ", Thanks for using our program, Goodbye!\n" +
		              "]", storage);
	}
	
	@Test
	public void shouldShowProject_whenItChosen(){
		//given
		FakeOutput out = new FakeOutput();
		Input in = new FakeInput(1, 1, 0, 0, 0);			
		Categories categories = new Categories();
		Projects projects = new Projects();
		Quote Quote = new StubQuote();
		Category category1 = new Category("category1");
		Category category2 = new Category("category2");
		categories.addCategory(category1);
		categories.addCategory(category2);
		Project project1 = new Project(category1);
		project1.setProject("name1", "description1", 1000, 200, 10, "history1", "videoLink1", "questions");
		projects.addProject(project1);
		Kickstart kickstart = new Kickstart(out, in, categories, projects, Quote);
		
		//when
		kickstart.buildMenu();
		String storage = out.getList().toString();
		
		//then
		assertEquals("[quote\n" +
					", 1 - category1, 2 - category2\n" +
					"What are you interested in? Pleace, make your choice:\n" +
					", You chose - category1\n" +
					", 1) Name - name1, Description - description1, Money we need - 1000, Money we have - 200, Days left - 10\n" +
					", If you want to return press \"0\"\n" +
					", --------------------------------------------------\n" +
					", You chose: Name - name1, Description - description1, Money we need - 1000, Money we have - 200, Days left - 10\n" +
					", history1\n" +
					", videoLink1\n" +
					", questions\n" +
					", --------------------------------------------------\n" +
					", Return - \"0\"\n" +
					", 1) Name - name1, Description - description1, Money we need - 1000, Money we have - 200, Days left - 10\n" +
					", If you want to return press \"0\"\n" +
					", 1 - category1, 2 - category2\n" +
					"What are you interested in? Pleace, make your choice:\n" +
					", Thanks for using our program, Goodbye!\n" +
					"]", storage);
	}
	
	@Test
	public void shouldDisplayError_whenNotExistingItemIsSelected(){
		//given
		FakeOutput out = new FakeOutput();
		Input in = new FakeInput(1, 1, 1, 0, 3, 0, 3, 0);			
		Categories categories = new Categories();
		Projects projects = new Projects();
		Quote Quote = new StubQuote();
		Category category1 = new Category("category1");
		Category category2 = new Category("category2");
		categories.addCategory(category1);
		categories.addCategory(category2);
		Project project1 = new Project(category1);
		project1.setProject("name1", "description1", 1000, 200, 10, "history1", "videoLink1", "questions");
		projects.addProject(project1);
		Kickstart kickstart = new Kickstart(out, in, categories, projects, Quote);
		
		//when
		kickstart.buildMenu();
		String storage = out.getList().toString();
		
		//then
		assertEquals("[quote\n" +
", 1 - category1, 2 - category2\n" +
"What are you interested in? Pleace, make your choice:\n" +
", You chose - category1\n" +
", 1) Name - name1, Description - description1, Money we need - 1000, Money we have - 200, Days left - 10\n" +
", If you want to return press \"0\"\n" +
", --------------------------------------------------\n" +
", You chose: Name - name1, Description - description1, Money we need - 1000, Money we have - 200, Days left - 10\n" +
", history1\n" +
", videoLink1\n" +
", questions\n" +
", --------------------------------------------------\n" +
", Return - \"0\"\n" +
", Error!! You must enter 0 \n" +
"Please, try again\n" +
", 1) Name - name1, Description - description1, Money we need - 1000, Money we have - 200, Days left - 10\n" +
", If you want to return press \"0\"\n" +
", Error!! There are no such project - Try again:\n" +
", 1 - category1, 2 - category2\n" +
"What are you interested in? Pleace, make your choice:\n" +
", Error!! There are no such category - Try again:\n" +
", Thanks for using our program, Goodbye!\n" +
"]", storage);
	}
	
}


