package com.anmertrix.dao.memory;

import java.util.List;

import com.anmertrix.Category;
import com.anmertrix.Project;
import com.anmertrix.dao.CategoryDao;


public class CategoryDaoMemory implements CategoryDao {
	
	public CategoryDaoMemory() {
		categories.add(new Category("Sport"));
		categories.add(new Category("IT"));
		categories.add(new Category("Medicine"));
		categories.add(new Category("Photo"));
		categories.add(new Category("Music"));
		categories.add(new Category("Video"));
		
		Project project1 = new Project();
		project1.setProjectData("Cube soccer ball", "Test description", 5000, 1000, 12, "Test history");
		categories.get(0).setProject(project1);

		Project project2 = new Project();
		project2.setProjectData("La Liga Weekly Podcast", "Test description", 8000, 300, 22, "Test history");
		categories.get(0).setProject(project2);

		Project project3 = new Project();
		project3.setProjectData("Author’s vocabulary", "Test description", 7000, 200, 25, "Test history");
		categories.get(1).setProject(project3);

		Project project4 = new Project();
		project4.setProjectData("Reporter camera", "Test description", 4000, 500, 5, "Test history");
		categories.get(1).setProject(project4);

		Project project5 = new Project();
		project5.setProjectData("Yes Cart", "Test description", 6500, 10, 9, "Test history");
		categories.get(2).setProject(project5);

		Project project6 = new Project();
		project5.setProjectData("ARoglyph", "Test description", 5600, 100, 11, "Test history");
		categories.get(2).setProject(project6);

		Project project7 = new Project();
		project7.setProjectData("Start Control", "Test description", 8000, 300, 15, "Test history");
		categories.get(3).setProject(project7);

		Project project8 = new Project();
		project8.setProjectData("OldStyleRacing", "Test description", 5000, 400, 11, "Test history");
		categories.get(3).setProject(project8);

		Project project9 = new Project();
		project9.setProjectData("Poughkeepsie", "Test description", 5000, 400, 11, "Test history");
		categories.get(4).setProject(project9);

		Project project10 = new Project();
		project10.setProjectData("Photobook", "Test description", 5000, 400, 11, "Test history");
		categories.get(4).setProject(project10);

		Project project11 = new Project();
		project11.setProjectData("Portraits & Stories", "Test description", 5000, 400, 11, "Test history");
		categories.get(5).setProject(project11);

		Project project12 = new Project();
		project12.setProjectData("Alzheimer", "Test description", 5000, 400, 11, "Test history");
		categories.get(5).setProject(project12);
	}

	@Override
	public Category getCategory(int index) {
		return categories.get(index - 1);
	}

	@Override
	public List<Category> getCategories() {
		return categories;
	}

}
