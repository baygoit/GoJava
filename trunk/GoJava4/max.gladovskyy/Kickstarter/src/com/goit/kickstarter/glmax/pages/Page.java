package com.goit.kickstarter.glmax.pages;

import java.util.ArrayList;

import com.goit.kickstarter.glmax.enteties.Entetie;
import com.goit.kickstarter.glmax.view.Output;

public abstract class Page {

	protected static final int parentPage = 0;
	protected Entetie entetie;
	protected ArrayList<Page> relatedPages;
	protected ArrayList<String> formatedPage = new ArrayList<String>();

	
	public Page(Entetie entetie) {
		this.entetie = entetie;
		prepareFormatedPage();
	}
	
	abstract protected void prepareFormatedPage();
	
	public void show(Output printer) {
		printer.print(formatedPage);
	}
	
	protected void fillMenu() {
		for (int index = 1; index <= relatedPages.size(); index++) {
			formatedPage.add(index+") "+ relatedPages.get(index).getName());
		}
	}
	
	public Page getParentPage() {
		return relatedPages.get(parentPage);
	}

	public void setParentPage(Page page) {
		this.relatedPages.add(parentPage, page);
	}

	public void addChildPages(ArrayList<Page> childPages) {
		this.relatedPages.addAll(childPages);
	}

	public int getId() {
		return this.entetie.getId();
	}

	public String getName() {
		return this.entetie.getName();
	}

}
