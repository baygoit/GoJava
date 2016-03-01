package com.anmertrix.module1.annagama;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class AnnagamaRunTest {
	 @Test
     public void newAnnagamaTest() {
          assertNotNull(new Annagama(new ConsoleIO()));
     }
	 
	 @Test
	 public void mockNewAnnagamaTest() {
		 Annagama annagama = mock(Annagama.class);
		 annagama.run();
		 verify(annagama).run();
		 
	 }
	 
}
