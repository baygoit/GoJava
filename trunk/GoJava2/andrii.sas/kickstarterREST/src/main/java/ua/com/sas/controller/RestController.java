package ua.com.sas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ua.com.sas.model.Category;
import ua.com.sas.model.Project;
import ua.com.sas.service.ProjectsService;

@Controller
public class RestController {

	@Autowired
	private ProjectsService service;

	@RequestMapping (value = "/categories")
	public @ResponseBody List<Category> getAll(){
		return service.getAll();
	}
	
	@RequestMapping (value = "/categories/{id}")
	public @ResponseBody List<Project> getProjects(@PathVariable int id){
		return service.getWithProjects(id).getProjects();
	}
}
