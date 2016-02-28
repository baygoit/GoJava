package com.anmertrix.module1.annagama;

import org.junit.Test;

public class AnnagamaTest {
	
	@Test
	public void should_when(){
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
		//given
		Annagama annagama = new Annagama(io);
		//when
		
		annagama.run();
		//then
		
	}
}
