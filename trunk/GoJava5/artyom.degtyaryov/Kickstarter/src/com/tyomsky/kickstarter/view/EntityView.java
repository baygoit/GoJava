package com.tyomsky.kickstarter.view;

import java.util.ArrayList;

import com.tyomsky.kickstarter.model.Entity;


public abstract class EntityView {

	protected static final int parentView = 0;
	protected Entity entity;
	protected ViewTypes viewType;
	protected ArrayList<EntityView> childViews = new ArrayList<>();
	protected ArrayList<String> layout = new ArrayList<>();
	
	public EntityView(Entity entity) {
		this.entity = entity;
	}

    protected abstract void prepareLayout();
	
	public void show(Output printer) {
		prepareLayout();
		printer.print(layout);
	}
	
	protected void fillMenu() {
		for (int index = 1; index < childViews.size(); index++) {
			layout.add(index + ") " + childViews.get(index).getEntityName());
		}
	}
	
	public EntityView getChildView(int i) {
		return childViews.get(i);
	}

	public void setParentView(EntityView view) {
		this.childViews.add(parentView, view);
	}

	public void setChildViews(ArrayList<EntityView> childViews) {
        if (this.childViews.isEmpty()){
            this.childViews.addAll(childViews);
        } else {
            EntityView exitView = this.childViews.get(0);
            this.childViews.clear();
            this.childViews.add(exitView);
            this.childViews.addAll(childViews);
        }
	}

	public int getId() {
		return this.entity.getId();
	}

	public String getEntityName() {
		return this.entity.getName();
	}

	public int getMenuVariants() {
		return childViews.size();
	}

	public ViewTypes getViewType() {
		return viewType;
	}
	
	

}
