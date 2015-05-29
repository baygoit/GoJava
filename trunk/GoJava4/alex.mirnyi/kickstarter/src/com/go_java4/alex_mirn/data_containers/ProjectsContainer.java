package com.go_java4.alex_mirn.data_containers;

import java.util.ArrayList;
import java.util.List;

import com.go_java4.alex_mirn.data.Project;

public class ProjectsContainer extends EntityContainer<Project>{

	public ProjectsContainer() {
		data = new ArrayList<Project>();
	}
}
