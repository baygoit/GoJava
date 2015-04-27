package ua.com.goit.gojava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.goit.gojava.entity.Category;
import ua.com.goit.gojava.repository.CategoryRository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRository categoryRository;
	
	public List<Category> findAll(){
		return categoryRository.findAll();
	}

	public Category findOne(int id) {
		// TODO Auto-generated method stub
		return categoryRository.findOne(id);
	}
}
