package com.kickstarter.filerun.components.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import com.kickstarter.filerun.components.FilePaymentSystem;
import com.kickstarter.util.UserConsoleInputReader;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class FilePaymentSystemTest {

	@Mock
	UserConsoleInputReader uinp;
 

	
	
	
	@Test
	public void acceptKindOfPaymentTest() {
		FilePaymentSystem fps = new FilePaymentSystem();
		UserConsoleInputReader userInp = mock(UserConsoleInputReader.class);
     	when(userInp.readInput()).thenReturn(500);
		assertEquals(fps.acceptKindOfPayment(), 500);
	}

}
