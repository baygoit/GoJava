package com.goit.kickstarter.glmax.model;

import java.util.ArrayList;
import java.util.List;

import com.goit.kickstarter.glmax.controller.Position;
import com.goit.kickstarter.glmax.enteties.Category;
import com.goit.kickstarter.glmax.enteties.Entetie;
import com.goit.kickstarter.glmax.enteties.PaymentVariant;
import com.goit.kickstarter.glmax.enteties.Project;

public interface DataSource {

	ArrayList<Category> getCategoriesList();

	Entetie getSomeQuote();

	ArrayList<Project> getProjectsList(int categoryIndex);

	String getCategoryName(int categoryIndex);

	Project getProject(int category, int project);

	ArrayList<Integer> getChoisList(Position currentLevel, Integer integer);

	void persistData();

	PaymentVariant getpaymentVariants(Integer integer, Integer currentMenuObjectIndex);

	ArrayList<Entetie> getEntetiesList(Position next);

}
