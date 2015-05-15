package model;

import model.Category;

public class CategoryRepository {
	
	static{
		Category videoCategory = new Category("Video",
				"Any video you can imagine. Start from multibillionaire "
						+ "blockbasters and ending your home videos");
		Category audioCategory = new Category("Audio",
				"Any audio you can imagine. New DJ-set or special musical "
						+ "instrument - all of it here");
	}
}
