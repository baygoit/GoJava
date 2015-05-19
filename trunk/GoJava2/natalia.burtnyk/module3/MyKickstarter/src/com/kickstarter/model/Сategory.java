package com.kickstarter.model;

public class Сategory {
	
    private String name;
    private int id;
    
    public Сategory(String name) {
       this.name = name;
    }
    
    public Сategory (int id,String name) {
    	 this.name = name;
    	 this.id = id;
    }
	
    public String getName(){
       return name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	} 
}
