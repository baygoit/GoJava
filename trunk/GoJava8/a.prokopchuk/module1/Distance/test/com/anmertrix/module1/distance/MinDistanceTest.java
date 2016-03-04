package com.anmertrix.module1.distance;

import static org.junit.Assert.*;

import org.junit.Test;


public class MinDistanceTest {
	
	
	class FaceIO implements IO {

		private String message = new String();

		private String input = new String();
		
		public FaceIO(String input){
			this.input = new String(input);
		}
		
		@Override
		public String readConsole() {
			return input;
		}

		@Override
		public void print(String message) {
			this.message = message;
		}
		
		public String getMessages() {
			return message;
		}
	}
	@Test
	public void manyMinElements(){
		FaceIO io = new FaceIO("1 2 1 2 1");
		
		MinDistance annagama = new MinDistance(io);
		
		annagama.run();
		assertEquals("2 4 2", io.getMessages().toString());
	}
	
	@Test
	public void oneMinElements(){
		FaceIO io = new FaceIO("23 45 34 12 45 4 38 56 2 49 100");
		
		MinDistance annagama = new MinDistance(io);
		
		annagama.run();
		assertEquals("3", io.getMessages().toString());
	}
	
	@Test
	public void noneElements(){
		FaceIO io = new FaceIO("");
		
		MinDistance annagama = new MinDistance(io);
		
		annagama.run();
		assertEquals("", io.getMessages().toString());
	}
	
	@Test
	public void ifElementsNonNumber(){
		FaceIO io = new FaceIO("3 5f 5");
		
		MinDistance annagama = new MinDistance(io);
		
		annagama.run();
		assertEquals("1", io.getMessages().toString());
	}
	
	
}
