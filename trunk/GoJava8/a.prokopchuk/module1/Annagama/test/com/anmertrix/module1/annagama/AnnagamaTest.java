package com.anmertrix.module1.annagama;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnnagamaTest {
	
	@Test
	public void stub_and_dummy(){
		IO io = new IO(){

			@Override
			public String readConsole() {
				return "test";
			}

			@Override
			public void print(String message) {
				// do nothink
			}
		};
		
		Annagama annagama = new Annagama(io);
		annagama.run();
		
	}
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
	public void face(){
		FaceIO io = new FaceIO("test1 test2 test3");
		//given
		Annagama annagama = new Annagama(io);
		//when
		
		annagama.run();
		//then
		assertEquals("1tset 2tset 3tset", io.getMessages().toString());
	}
}
