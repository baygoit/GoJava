package com.goit.pages;

public final class ConsolePagePath {
	private static ConsolePagePath instance = null;
	private int numberCategory;
	private int numberProject;

	private ConsolePagePath() {
	}

	public static ConsolePagePath getInstance() {
		if (instance == null)
            instance = new ConsolePagePath();
		return instance;
	}

	public int getNumberCategory() {
		return numberCategory;
	}

	public void setNumberCategory(int numberCategory) {
		this.numberCategory = numberCategory;
	}

	public int getNumberProject() {
		return numberProject;
	}

	public void setNumberProject(int numberProject) {
		this.numberProject = numberProject;
	}

	// private static class PathHolder(){
	// private static final ConsolePagePath instance = new ConsolePagePath();
	// }
	//
	// public static ConsolePagePath getInstance(){
	// return PathHolder.instance;
	// }
}
