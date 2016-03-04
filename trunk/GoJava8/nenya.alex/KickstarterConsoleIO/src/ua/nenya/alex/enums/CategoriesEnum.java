package ua.nenya.alex.enums;

import ua.nenya.alex.project.GetNameInterface;

public enum CategoriesEnum implements GetNameInterface{
	MUSIC("Music"),
	FILMS("Films"),
	BOOKS("Books"),
	ART("Art"),
	GAMES("Games"),
	CREATE_PROJECT("Create a project");
	
	String name;

	private CategoriesEnum(String name) {
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
}
