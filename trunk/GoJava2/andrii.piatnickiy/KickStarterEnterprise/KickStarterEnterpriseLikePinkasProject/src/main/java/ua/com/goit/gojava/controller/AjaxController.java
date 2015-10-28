package ua.com.goit.gojava.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ua.com.goit.gojava.entity.Category;
import ua.com.goit.gojava.service.CategoryService;

@Controller
public class AjaxController {
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/ajax")
	public String ajax() {
		return "ajax";
	}

	@RequestMapping(value = "/ajaxtest", method = RequestMethod.GET)
	@ResponseBody
	public Set<String> ajaxTest() {
		Set<String> records = new HashSet<String>();
		records.add("Record #1");
		records.add("Record #2");
		
		return records;
	}
	
//	@RequestMapping("/ajax1")
//	public String categories(Model model) {
//		model.addAttribute("categories", categoryService.findAll());
//		return "categories";
//	}
	
	@RequestMapping(value = "/ajaxcategory", method = RequestMethod.GET)
	@ResponseBody
	public Category ajaxCategory() {
		Category category = categoryService.findOne(1);
		return category;
	}
	
    @RequestMapping(value = "/ajaxcategories", method = RequestMethod.GET)
    @ResponseBody
    public List<Category> ajaxCategories() {
    	List<Category> categories = categoryService.findAll();
        return categories;
    }
}