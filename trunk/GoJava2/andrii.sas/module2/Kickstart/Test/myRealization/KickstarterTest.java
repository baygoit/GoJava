package myRealization;

import static org.junit.Assert.*;

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
			
			list.add(s);
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
		assertEquals("[quote, 1 - category1, 2 - category2\n"
				+ "What are you interested in? Pleace, make your choice:,"
				+ " You chose - category1, If you want to return press \"0\", 1 - category1, 2 - category2\n"
				+ "What are you interested in? Pleace, make your choice:, Thanks for using our program, Goodbye!]", storage);
	}
	
}


