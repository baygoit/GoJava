package ua.nenya.service;

public interface CategoryService {

	boolean isCategoryExistById(Long categoryId);
	boolean isCategoryExistByName(String categoryName);

}
