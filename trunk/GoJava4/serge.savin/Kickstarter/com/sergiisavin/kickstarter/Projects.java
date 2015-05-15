package com.sergiisavin.kickstarter;

public interface Projects {

	public abstract void add(Project project);

	public abstract int getSize();

	public abstract Project getProject(int index);

}