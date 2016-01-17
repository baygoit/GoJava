package ua.com.goit.gojava7.kickstarter.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.com.goit.gojava7.kickstarter.dao.CategoryDao;
import ua.com.goit.gojava7.kickstarter.dto.CategoryDto;
import ua.com.goit.gojava7.kickstarter.model.Category;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryService {

    private static final Logger log = LoggerFactory.getLogger(CategoryService.class);

    @Autowired
    private CategoryDao categoryDao;

    public CategoryDto get(Long categoryId) {
        log.info("<CategoryDto> get({})...", categoryId);

        Category category = categoryDao.get(categoryId);

        return constuctCategoryDto(category);
    }

    public List<CategoryDto> getAll() {
        log.info("<categoriesDto> getAll()...");

        List<CategoryDto> categoriesDto = new ArrayList<>();

        for(Category category : categoryDao.getAll()) {
            categoriesDto.add(constuctCategoryDto(category));
        }

        return categoriesDto;
    }

    private CategoryDto constuctCategoryDto(Category category) {
        log.info("<CategoryDto> constuctCategoryDto({})...", category);

        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryId(category.getCategoryId());
        categoryDto.setName(category.getName());

        //categoryDto.setProjects(category.getProjects());
        //log.info("<CategoryDto> constuctCategoryDto({}) set project[0].projectId = {}", category, categoryDto.getProjects().get(0).getProjectId());

        return categoryDto;
    }
}
