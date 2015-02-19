package model;

import java.util.ArrayList;

public interface Categories {

	public abstract void writeAllCatecories();

	public abstract String getStringAllCatecories();

	public abstract String showAllProjectInCategory(int categoryId,	Projects projects);

	public abstract String showCatecoryName(int categoryId);

	public abstract int[] getKickCategories();

	public abstract int[] projectsContain(int categoryId);

	public abstract int getCounterCategory();

	public abstract void setCounterCategory(int counterCategory);

	public abstract ArrayList<Category> getListCatecories();

	public abstract void setListCatecories(ArrayList<Category> listCatecories);

}