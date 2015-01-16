package ua.com.goit.gojava.voronov.HelloWorld;

import java.util.ArrayList;

public class HelloWorld {

	public static void main(String[] args) {
		System.out.println("Hello World");
		ArrayList<String> myList = new ArrayList<String>();
		myList.add("one");
		myList.add("two");
		myList.add(1,"middle");
		
		for(String s:myList)
		{
			System.out.println("=== "+s);
		}
		
		
		System.out.println(myList);
		
		
	}

}
