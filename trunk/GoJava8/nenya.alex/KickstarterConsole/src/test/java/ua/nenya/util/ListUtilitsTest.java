package ua.nenya.util;


import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import ua.nenya.project.Category;
import ua.nenya.util.IO;
import ua.nenya.util.ListUtilits;

public class ListUtilitsTest {

	private IO mockIo;
	private List<Category> list = new ArrayList<>();
	
	
	@Before
	public void init() {
		mockIo = mock(IO.class);
		Category musicCategory = new Category();
		musicCategory.setName("Music");
		Category filmsCategory = new Category();
		filmsCategory.setName("Films");
		list.add(musicCategory);
		list.add(filmsCategory);
	}
	
	@Test
	public void listUtilitsTestOutOfRange1() {
		when(mockIo.readConsole()).thenReturn("12").thenReturn("0");
		new ListUtilits().choseIndexFromList(list, mockIo);
		InOrder order = inOrder(mockIo);
		order.verify(mockIo).writeln("Number is out of range! Try again!");
	}
	
	@Test
	public void listUtilitsTestOutOfRange2() {
		when(mockIo.readConsole()).thenReturn("-12").thenReturn("0");
		new ListUtilits().choseIndexFromList(list, mockIo);
		InOrder order = inOrder(mockIo);
		order.verify(mockIo).writeln("Number is out of range! Try again!");
	}

	@Test
	public void listUtilitsTestWrongEntering() {
		when(mockIo.readConsole()).thenReturn("zxc").thenReturn("0");
		new ListUtilits().choseIndexFromList(list, mockIo);
		InOrder order = inOrder(mockIo);
		order.verify(mockIo).writeln("Wrong entering!!! Try again!");
	}
	
	@Test
	public void listUtilitsTest3() {
		when(mockIo.readConsole()).thenReturn("1").thenReturn("0");
		assertSame(1, new ListUtilits().choseIndexFromList(list, mockIo));
		
	}

}
