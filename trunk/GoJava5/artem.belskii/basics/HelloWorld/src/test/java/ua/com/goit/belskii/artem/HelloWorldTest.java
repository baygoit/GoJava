package ua.com.goit.belskii.artem;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HelloWorldTest {
	private HelloWorld hello;

	@Before
	public void setUp() {
		hello = new HelloWorld();
		hello.setName("World");
	}

	@Test
	public void testName() {
		assertEquals("World", hello.getName());
	}

	@Test
	public void testMessage() {
		assertEquals("Hello, World!", hello.sayHello());
	}

}