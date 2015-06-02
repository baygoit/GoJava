package com.goit.kickstarter.glmax.pages;

import java.util.ArrayList;

import com.goit.kickstarter.glmax.view.Output;

public abstract class Page {
	
	private int id;
	private Page parentPage;
	private ArrayList<Page> childPages;
	
	

	abstract public void show(Output printer);

	public Page getParentPage() {
		return parentPage;
	}

	public void setParentPage(Page parentPage) {
		this.parentPage = parentPage;
	}

	public ArrayList<Page> getChildPages() {
		return childPages;
	}
	
	public Page getChildPage(int index) {
		return childPages.get(index - 1);
	}

	public void setChildPages(ArrayList<Page> childPages) {
		this.childPages = childPages;
	}
	
	public int getPageId() {
		return this.id;
	}
	
}
