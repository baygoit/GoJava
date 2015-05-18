package com.gojava2.kickstarter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gojava2.kickstarter.entity.ProjectStatus;
import com.gojava2.kickstarter.repository.ProjectStatusRepository;

@Service
public class ProjectStatusService {

	@Autowired
	private ProjectStatusRepository projectStatusRepository;

	public ProjectStatus get(int id) {
		return projectStatusRepository.findOne(id);
	}
	
	public void invest(ProjectStatus projectStatus, Integer amount) {
		if (amount > 0) {
			projectStatus.setTotal(projectStatus.getTotal() + amount);
			projectStatus.addBaker();
			projectStatusRepository.save(projectStatus);
		}
	}
}