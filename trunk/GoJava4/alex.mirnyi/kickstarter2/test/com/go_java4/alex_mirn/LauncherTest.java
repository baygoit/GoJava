package com.go_java4.alex_mirn;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.go_java4.alex_mirn.data.Category;
import com.go_java4.alex_mirn.data.Project;
import com.go_java4.alex_mirn.data.Quote;
import com.go_java4.alex_mirn.data_containers.FileRepository;
import com.go_java4.alex_mirn.data_containers.QuotesContainer;
import com.go_java4.alex_mirn.data_containers.Repository;
import com.go_java4.alex_mirn.data_containers.TestRepository;
import com.go_java4.alex_mirn.view.io.ConsoleIO;
import com.go_java4.alex_mirn.view.io.IO;
import com.go_java4.alex_mirn.view.pages.PageDispatcher;

public class LauncherTest {
	private Repository repository;
	
	@Before
	public void setup() throws IOException {
		repository = new TestRepository(new FakeRandom(0, 1));
	}
	public class FakeRandom extends Random {
		private List<Integer> numbers;
		public FakeRandom(Integer... numbers) {
			this.numbers = new LinkedList<Integer>(Arrays.asList(numbers));
		}
		
		@Override
		public int nextInt(int n) {
			return numbers.remove(0);
		}
	}

//	@Test
//	public void goBack_whenClick0() throws IOException{
//		Repository repository = new TestRepository(new Random());
//			
//		IO io = new IO() {
//			@Override
//			public void print(String string) {}
//				
//			@Override
//			public void println(String string){}
//				
//			@Override
//			public int readline() throws IOException{
//				return 0;
//			}
//		};
//		PageDispatcher pageDispatcher = new PageDispatcher(io, repository);
//		pageDispatcher.run();
//	}
	
	class FakeIO implements IO {
		public List<String> messages = new ArrayList<String>();
		private List<Integer> input = new ArrayList<Integer>();

		public FakeIO(Integer... input) {
			this.input = new ArrayList<Integer>(Arrays.asList(input));
		}

		@Override
		public void print(String message) {
			messages.add(message);			
		}

		@Override
		public void println(String string) {
			print(string + "\n");	
		}

		@Override
		public int readline() throws IOException {
			return input.remove(0);
		}
	}
	
	@Test
	public void work_whenFakeIO() throws IOException{
//		Repository repository = new TestRepository(new FakeRandom(0, 1));
			
		FakeIO io = new FakeIO(1, 0, 0);
		PageDispatcher pageDispatcher = new PageDispatcher(io, repository);
		pageDispatcher.run();
		System.out.println(io.messages.toString());
		assertEquals("[" + "Impossible is nothing" + "\n\n" +
"Please enter the number of the category you want to "
+ "choose or press \"0\" to leave the programm:" + "\n\n" +
", 1. Medicine" + "\n" +
"2. Music" + "\n\n" +
", ---------------" + "\n" + "]", io.messages.toString());
	}
	
//	@Test
//	public void mockito() throws IOException{
//		IO io = Mockito.mock(IO.class);
//		Repository repository = new TestRepository(new Random());
//		PageDispatcher pageDispatcher = new PageDispatcher(io, repository);
//
//		Mockito.when(io.readline()).thenReturn(1, 0, 0);
//		pageDispatcher.run();
//		Mockito.verify(io).println("Impossible is nothing");
//		Mockito.verify(io).println("[" + "Impossible is nothing" + "\n\n" +
//				"Please enter the number of the category you want to "
//				+ "choose or press \"0\" to leave the programm:" + "\n\n");
//		Mockito.verify(io).print(", 1. Medicine" + "\n" +
//				"2. Music" + "\n\n");
//		Mockito.verify(io).print(", ---------------" + "\n" + "]");
//	}
}
