package com.kickstarter.model;

public class Сategory {
	
    private String name;
    private int id;
    
    public Сategory(int id) {
       this.id = id;
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
