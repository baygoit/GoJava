package com.sergiisavin.kickstarter.UserInterface;

public class RequestData {

	public int index;
	public String data;
	public String category;
	
	public RequestData(int index){
		this.index = index;
	}

	public RequestData(String data) {
		this.data = data;
	}
}
