package com.sergiisavin.kickstarter.project.container;

import javax.naming.OperationNotSupportedException;

import com.sergiisavin.kickstarter.project.Project;

public interface Projects {

	public abstract void add(Project project) throws OperationNotSupportedException;

	public abstract int getSize();

	public abstract Project getProject(int index);

	public class ProjectsFileCorruptedException extends RuntimeException{
		
	}

}